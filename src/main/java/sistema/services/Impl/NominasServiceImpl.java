package sistema.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sistema.dao.FacturasDao;
import sistema.dao.NominasDao;
import sistema.dao.Nominas_detalleDao;
import sistema.dto.NominasDto;
import sistema.services.NominasService;

import java.util.List;
import java.util.logging.Logger;

@Repository
@Transactional
public class NominasServiceImpl implements NominasService {

    @Autowired
    NominasDao nominasDao;

    @Autowired
    Nominas_detalleDao nominas_detalleDao;

    @Autowired
    FacturasDao facturasDao;

    private final static Logger logger = Logger.getLogger("sistema.services.Impl.NominasServiceImpl");


    public Page<NominasDto> getPages(Pageable pageable, Integer fiid) {


        List<NominasDto> lista = nominasDao.getNominas(fiid);
        int start = pageable.getOffset();
        int end = (start + pageable.getPageSize()) > lista.size() ? lista.size() : (start + pageable.getPageSize());
        Page<NominasDto> pages;
        pages = new PageImpl<NominasDto>(lista.subList(start, end), pageable, lista.size());

        return pages;

    }

    public void crearNomina(Integer fiempleado, Double fitotal, Integer[] finum, Integer[] fiarticulo, String[] fcclave, String[] fcdescripcion, Double[] fiprecio, Double[] fitotaln) {

        Double fidescuento = 0.0;
        Double fitotalneto = fitotal - fidescuento;

        nominasDao.crearNomina(fiempleado, fitotal, fidescuento, fitotalneto);
        Integer maximoNomina = nominasDao.maxId();

        for (int i = 0; i < finum.length; i++) {

            nominas_detalleDao.crearNomina_detalle(maximoNomina,finum[i],fiarticulo[i],fcclave[i],fcdescripcion[i],fiprecio[i],fitotaln[i]);

        }

        facturasDao.updCortenomina(fiempleado);

    }
}
