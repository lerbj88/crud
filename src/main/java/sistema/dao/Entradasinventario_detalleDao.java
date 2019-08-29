package sistema.dao;

import sistema.entity.Entradasinventario_detalle;

import java.util.List;

public interface Entradasinventario_detalleDao {

    List<Entradasinventario_detalle> getDetalles(Integer fiid);
    void crearEntrada_detalle(Integer fientrada, Integer numpartida, Integer fiarticulo, Integer ficantidad, String fcclave, String fcdescripcion, Double ficosto, Double fiimporte);
}
