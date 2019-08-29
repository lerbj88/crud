package sistema.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sistema.dao.ArticulosDao;
import sistema.dao.EmpleadosDao;
import sistema.dao.Factura_detalleDao;
import sistema.dao.FacturasDao;
import sistema.dto.FacturasDto;
import sistema.entity.Articulos;
import sistema.services.FacturasService;

import java.util.List;
import java.util.logging.Logger;


@Repository
@Transactional
public class FacturasServiceImpl implements FacturasService {

    @Autowired
    FacturasDao facturasDao;

    @Autowired
    Factura_detalleDao facturas_detalleDao;

    @Autowired
    ArticulosDao articulosDao;

    @Autowired
    EmpleadosDao empleadosDao;

    private final static Logger logger = Logger.getLogger("sistema.services.Impl.FacturasServiceImpl");


    public Page<FacturasDto> getPages(Pageable pageable, Integer fiid) {


        List<FacturasDto> lista = facturasDao.getFacturas(fiid);
        int start = pageable.getOffset();
        int end = (start + pageable.getPageSize()) > lista.size() ? lista.size() : (start + pageable.getPageSize());
        Page<FacturasDto> pages;
        pages = new PageImpl<FacturasDto>(lista.subList(start, end), pageable, lista.size());

        return pages;

    }

    public void crearFactura(Integer ficliente, Integer fiauto, Double fitotalfactura, Integer[] filavador, Integer[] filistacantidades, Integer[] listapartidas) {

        facturasDao.crearFactura(ficliente, fiauto, 0, fitotalfactura);

        Articulos articulo = null;
        Integer cant = null;


        Integer fifactura = facturasDao.maxId();


        logger.warning("valor de listapartidas" + listapartidas[0]);
        logger.warning("valor de listacantdades" + filistacantidades[0]);


        for (int i = 0; i < listapartidas.length; i++) {
            articulo = articulosDao.obtenerArticulo(listapartidas[i]);

            facturas_detalleDao.crearFactura_detalle(fifactura, i + 1, listapartidas[i], filistacantidades[i], articulo.getFcclave(), articulo.getFcdescripcion(), articulo.getFiprecio(), (articulo.getFiprecio() * filistacantidades[i]));

        }
        for (int j = 0; j < filavador.length; j++) {
            facturasDao.crearFactura_lavadores(fifactura, filavador[j]);
        }

        //  facturas_detalleDao.crearFactura_detalle(fifactura,1,listapartidas[0], filistacantidades[0], articulo.getFcclave(),articulo.getFcdescripcion(),articulo.getFiprecio(),(articulo.getFiprecio() * filistacantidades[0]));
    }


    public Page<FacturasDto> getFacturasxlavador(Pageable pageable, Integer filavador) {


        List<FacturasDto> lista = facturasDao.getFacturasxlavador(filavador);
        int start = pageable.getOffset();
        int end = (start + pageable.getPageSize()) > lista.size() ? lista.size() : (start + pageable.getPageSize());
        Page<FacturasDto> pages;
        pages = new PageImpl<FacturasDto>(lista.subList(start, end), pageable, lista.size());

        return pages;

    }

    public String getLavadoresxfactura(Integer fifactura) {

        String lavadores = "";

        List<Integer> empleadoslist = facturasDao.getFactura_lavadores(fifactura);

        for (int i = 0; i < empleadoslist.size(); i++) {

            String lavador = empleadosDao.getlLavador(empleadoslist.get(i));

            lavadores = lavadores.concat( lavador+", ");


        }

        lavadores= lavadores.substring(0,lavadores.length()-2);
        logger.warning(lavadores);

        return lavadores;
    }


}
