package sistema.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sistema.entity.Cortecaja;

public interface CortescajaService {

    Page<Cortecaja> getPages(Pageable pageable, Integer fiid);
    Double totalCaja();
    void crear(Double firetiro, String fcdescripcion);
}
