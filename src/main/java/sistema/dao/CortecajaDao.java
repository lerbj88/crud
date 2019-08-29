package sistema.dao;

import sistema.entity.Cortecaja;

import java.util.List;

public interface CortecajaDao {
    List<Cortecaja> getCortescaja(Integer no);
    Double totalRestante();
    void crear(Double totalcajainicial, Double firetiro, String fcdescripcion, String user, Double cajarestante);
    void cancelarCortecaja(Integer fiid);
}
