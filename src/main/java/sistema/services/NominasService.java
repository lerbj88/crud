package sistema.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sistema.dto.NominasDto;

public interface NominasService {


    Page<NominasDto> getPages(Pageable pageable, Integer fiid);
    void crearNomina(Integer fiempleado, Double fitotal, Integer [] finum, Integer [] fiarticulo, String [] fcclave, String [] fcdescripcion, Double [] fiprecio, Double [] fitota);


}
