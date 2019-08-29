package sistema.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sistema.entity.Articulos;

public interface ArticulosService {
    Page<Articulos> getPages(Pageable pageable, String txt);
}
