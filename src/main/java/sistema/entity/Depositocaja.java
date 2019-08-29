package sistema.entity;

import java.sql.Timestamp;

public class Depositocaja {

    private Integer fiid;
    private Double fideposito;
    private String fcdescripcion;
    private Integer ficortecaja;
    private String fcusuario;
    private Timestamp fdfecha;

    public Depositocaja() {
    }

    public Depositocaja(Integer fiid, Double fideposito, String fcdescripcion, Integer ficortecaja, String fcusuario, Timestamp fdfecha) {
        this.fiid = fiid;
        this.fideposito = fideposito;
        this.fcdescripcion = fcdescripcion;
        this.ficortecaja = ficortecaja;
        this.fcusuario = fcusuario;
        this.fdfecha = fdfecha;
    }

    public Integer getFiid() {
        return fiid;
    }

    public void setFiid(Integer fiid) {
        this.fiid = fiid;
    }

    public Double getFideposito() {
        return fideposito;
    }

    public void setFideposito(Double fideposito) {
        this.fideposito = fideposito;
    }

    public String getFcdescripcion() {
        return fcdescripcion;
    }

    public void setFcdescripcion(String fcdescripcion) {
        this.fcdescripcion = fcdescripcion;
    }

    public Integer getFicortecaja() {
        return ficortecaja;
    }

    public void setFicortecaja(Integer ficortecaja) {
        this.ficortecaja = ficortecaja;
    }

    public String getFcusuario() {
        return fcusuario;
    }

    public void setFcusuario(String fcusuario) {
        this.fcusuario = fcusuario;
    }

    public Timestamp getFdfecha() {
        return fdfecha;
    }

    public void setFdfecha(Timestamp fdfecha) {
        this.fdfecha = fdfecha;
    }

    @Override
    public String toString() {
        return "Depositocaja{" +
                "fiid=" + fiid +
                ", fideposito=" + fideposito +
                ", fcdescripcion='" + fcdescripcion + '\'' +
                ", ficortecaja=" + ficortecaja +
                ", fcusuario='" + fcusuario + '\'' +
                ", fdfecha=" + fdfecha +
                '}';
    }
}
