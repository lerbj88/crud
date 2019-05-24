package crud.services;

import crud.entity.Clientes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClientesServices  {
    Page<Clientes> getPages(Pageable pageable, String txt);
}
