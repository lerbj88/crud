package sistema.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sistema.dto.FacturasDto;

public interface FacturasService {

    Page<FacturasDto> getPages(Pageable pageable, Integer fiid);
    Page<FacturasDto> getFacturasxlavador(Pageable pageable, Integer filavador);
    void crearFactura(Integer ficliente, Integer fiauto, Double fitotalfactura, Integer[] filavador, Integer[] filistacantidades, Integer[] listapartidas );
    String getLavadoresxfactura(Integer fifactura);
}
