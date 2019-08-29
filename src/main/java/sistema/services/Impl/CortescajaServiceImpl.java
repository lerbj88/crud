package sistema.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sistema.dao.CortecajaDao;
import sistema.dao.DepositocajaDao;
import sistema.dao.FacturasDao;
import sistema.dao.NominasDao;
import sistema.entity.Cortecaja;
import sistema.services.CortescajaService;

import java.util.List;

@Repository
@Transactional
public class CortescajaServiceImpl implements CortescajaService {


    @Autowired
    CortecajaDao cortecajaDao;

    @Autowired
    FacturasDao facturasDao;

    @Autowired
    NominasDao nominasDao;

    @Autowired
    DepositocajaDao depositocajaDao;


    public Page<Cortecaja> getPages(Pageable pageable, Integer fiid) {


        List<Cortecaja> lista = cortecajaDao.getCortescaja(fiid);
        int start = pageable.getOffset();
        int end = (start + pageable.getPageSize()) > lista.size() ? lista.size() : (start + pageable.getPageSize());
        Page<Cortecaja> pages;
        pages = new PageImpl<Cortecaja>(lista.subList(start, end), pageable, lista.size());

        return pages;

    }

    public Double totalCaja() {

        Double totcaja = null;
        Double cajarestante = null;
        Double totdepositos = null;
        totcaja = facturasDao.getTotalFacturas();
        Double totalnominas= nominasDao.gettotalNominas();
        cajarestante= cortecajaDao.totalRestante();
        totdepositos = depositocajaDao.getTotalDepositos();

        totcaja = totcaja+cajarestante-totalnominas+totdepositos;

        return totcaja;

    }

    public  void crear(Double firetiro, String fcdescripcion){

        Double totalcajainicial= totalCaja();
        Double cajarestante= totalcajainicial - firetiro;
        facturasDao.updCortecaja();
        nominasDao.updCortecaja();
        depositocajaDao.updCortecaja();
        final String user = SecurityContextHolder.getContext().getAuthentication().getName();

        cortecajaDao.crear(totalcajainicial, firetiro, fcdescripcion, user, cajarestante);

    }


}
