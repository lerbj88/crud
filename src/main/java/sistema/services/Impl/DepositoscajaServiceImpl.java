package sistema.services.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sistema.dao.DepositocajaDao;
import sistema.entity.Depositocaja;
import sistema.services.DepositoscajaService;

import java.util.List;

@Repository
@Transactional
public class DepositoscajaServiceImpl  implements DepositoscajaService {

    @Autowired
    DepositocajaDao depositocajaDao;

  public Page<Depositocaja> getPages(Pageable pageable, Integer fiid){


        List<Depositocaja> lista = depositocajaDao.getDepositos(fiid);
        int start = pageable.getOffset();
        int end = (start + pageable.getPageSize()) > lista.size() ? lista.size() : (start + pageable.getPageSize());
        Page<Depositocaja> pages;
        pages = new PageImpl<Depositocaja>(lista.subList(start, end), pageable, lista.size());

        return pages;

    }

}
