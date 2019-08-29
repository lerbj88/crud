package sistema.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sistema.dao.ArticulosDao;
import sistema.dao.EntradasinventarioDao;
import sistema.dao.Entradasinventario_detalleDao;
import sistema.dao.Factura_detalleDao;
import sistema.entity.Articulos;
import sistema.entity.Entradasinventario;
import sistema.services.EntradasinventarioService;

import java.util.List;
import java.util.logging.Logger;


@Repository
@Transactional
public class EntradasinventarioServiceImpl implements EntradasinventarioService {

    @Autowired
    EntradasinventarioDao entradasinventarioDao;

    @Autowired
    Factura_detalleDao facturas_detalleDao;

    @Autowired
    ArticulosDao articulosDao;

    @Autowired
    Entradasinventario_detalleDao entradasinventario_detalleDao;

    private final static Logger logger = Logger.getLogger("sistema.services.Impl.EntradasinventarioServiceImpl");


    public Page<Entradasinventario> getPages(Pageable pageable, Integer fiid){

        List<Entradasinventario> lista = entradasinventarioDao.getEntradas(fiid);
        int start = pageable.getOffset();
        int end = (start + pageable.getPageSize()) > lista.size() ? lista.size() : (start + pageable.getPageSize());
        Page<Entradasinventario> pages;
        pages = new PageImpl<Entradasinventario>(lista.subList(start, end), pageable, lista.size());

        return pages;

    }



    public void guardarEntrada(String fcdescripcion, Double fitotalentrada, Integer[] filistacantidades, Integer[] listapartidas, Double [] filistacostos){



        final String user = SecurityContextHolder.getContext().getAuthentication().getName();

        entradasinventarioDao.crearEntrada(fcdescripcion,user,fitotalentrada);

        Articulos articulo = null;
        Integer cant = null;


        Integer fientrada = entradasinventarioDao.maxId();


        logger.warning("valor de listapartidas"+listapartidas[0]);
        logger.warning("valor de listacantdades"+filistacantidades[0]);



        for(int i=0; i<listapartidas.length; i++ ){
        articulo = articulosDao.obtenerArticulo(listapartidas[i]);

        entradasinventario_detalleDao.crearEntrada_detalle(fientrada,i+1,listapartidas[i], filistacantidades[i], articulo.getFcclave(),articulo.getFcdescripcion(),filistacostos[i],(filistacostos[i] * filistacantidades[i]));

    }

    }



}
