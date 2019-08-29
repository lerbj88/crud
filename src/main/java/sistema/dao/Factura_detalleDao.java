package sistema.dao;

import sistema.entity.Facturas_detalle;

import java.util.List;

public interface Factura_detalleDao {

    List<Facturas_detalle> getFactura_detalle(Integer no);
    void crearFactura_detalle(Integer fifactura, Integer numpartida, Integer fiarticulo, Integer ficantidad, String fcclave, String fcdescripcion, Double fiprecio, Double fiimporte);



}
