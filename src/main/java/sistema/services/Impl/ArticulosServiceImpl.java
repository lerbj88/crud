package sistema.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sistema.dao.ArticulosDao;
import sistema.entity.Articulos;
import sistema.services.ArticulosService;

import java.util.List;


@Repository
@Transactional
public class ArticulosServiceImpl implements ArticulosService {

    @Autowired
    ArticulosDao articulosDao;


    public Page<Articulos> getPages(Pageable pageable, String txt){

        List<Articulos> lista = articulosDao.getArticulos(txt);
        int start = pageable.getOffset();
        int end = (start + pageable.getPageSize()) > lista.size() ? lista.size() : (start + pageable.getPageSize());
        Page<Articulos> pages;
        pages = new PageImpl<Articulos>(lista.subList(start, end), pageable, lista.size());

        return pages;
    }

}
