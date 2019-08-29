package sistema.dao;

import sistema.dto.NominasDto;
import sistema.dto.Nominas_detalleDto;

import java.util.List;

public interface NominasDao {

    List<NominasDto> getNominas(Integer fiempleado);

    NominasDto getNomina (Integer fiid);
    Nominas_detalleDto getNomina_detalle (Integer fiid);
    void crearNomina(Integer fiempleado, Double fitotalbruto, Double fidescuento, Double totalneto);
    Integer maxId ();
    Double gettotalNominas();
    void updCortecaja();


}
