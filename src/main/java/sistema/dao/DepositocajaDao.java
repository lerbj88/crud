package sistema.dao;

import sistema.entity.Depositocaja;

import java.util.List;

public interface DepositocajaDao {

    List<Depositocaja> getDepositos(Integer fiid);
    void crear(Double fideposito, String fcdescripcion, String fcusuario);
    Double getTotalDepositos ();
    void updCortecaja();
}
