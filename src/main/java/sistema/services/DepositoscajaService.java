package sistema.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sistema.entity.Depositocaja;

public interface DepositoscajaService {

    Page<Depositocaja> getPages(Pageable pageable, Integer fiid);
}
