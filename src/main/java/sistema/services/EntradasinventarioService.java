package sistema.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sistema.entity.Entradasinventario;

public interface EntradasinventarioService {

    Page<Entradasinventario> getPages(Pageable pageable, Integer fiid);
    void guardarEntrada(String fcdescripcion, Double fitotalentrada, Integer[] filistacantidades, Integer[] listapartidas, Double[] filistacostos);
}
