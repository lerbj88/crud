package sistema.dao;

import sistema.dto.FacturasDto;
import sistema.dto.Facturas_DetalleDto;

import java.util.List;

public interface FacturasDao {

    List<FacturasDto> getFacturas(Integer no);
    List<FacturasDto> getFacturasxlavador(Integer filavador);
    Facturas_DetalleDto obtenerFactura(Integer no);
    void crearFactura(Integer ficliente, Integer fiauto, Integer fiempleado, Double fitotal);
    Integer maxId ();
    void cancelarFactura(Integer fifactura);
    Double getTotalFacturas();
    void updCortecaja();
    void updCortenomina(Integer fiempleado);
    void crearFactura_lavadores(Integer fifactura, Integer filavador);
    List<Integer>getFactura_lavadores(Integer fifactura);

}
