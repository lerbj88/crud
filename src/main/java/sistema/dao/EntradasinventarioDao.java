package sistema.dao;

import sistema.entity.Entradasinventario;

import java.util.List;

public interface EntradasinventarioDao {

    List<Entradasinventario> getEntradas(Integer fiid);
    Entradasinventario getEntrada(Integer fiid);
    void crearEntrada(String fcdescripcion, String fcusuario, Double fitotal);
    Integer maxId ();

}
