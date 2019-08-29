package sistema.dao;

import sistema.dto.Nomina_detalleEmpleadoDto;
import sistema.entity.nominas_detalle;

import java.util.List;

public interface Nominas_detalleDao {

    List<nominas_detalle> getDetalles(Integer fiid);
    List<Nomina_detalleEmpleadoDto> getDetalle_nomina(Integer fiid);
    void crearNomina_detalle(Integer finomina, Integer finum, Integer fiarticulo, String fcclave, String fcdescripcion, Double fiprecio, Double fitotal);



}
