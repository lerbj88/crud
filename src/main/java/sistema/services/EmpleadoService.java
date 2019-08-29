package sistema.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sistema.entity.Empleado;

public interface EmpleadoService {
    Page<Empleado> getPages(Pageable pageable, String txt);
    Page<Empleado> getPages(Pageable pageable);

}
