package sistema.entity;

import java.sql.Timestamp;

public class Entradasinventario {

    private Integer fiid;
    private String fcdescripcion;
    private String fcusuario;
    private Double fitotal;
    private Integer fistatus;
    private Timestamp fdfecha;

    public Entradasinventario() {
    }

    public Entradasinventario(Integer fiid, String fcdescripcion, String fcusuario, Double fitotal, Integer fistatus, Timestamp fdfecha) {
        this.fiid = fiid;
        this.fcdescripcion = fcdescripcion;
        this.fcusuario = fcusuario;
        this.fitotal = fitotal;
        this.fistatus = fistatus;
        this.fdfecha = fdfecha;
    }

    public Integer getFiid() {
        return fiid;
    }

    public void setFiid(Integer fiid) {
        this.fiid = fiid;
    }

    public String getFcdescripcion() {
        return fcdescripcion;
    }

    public void setFcdescripcion(String fcdescripcion) {
        this.fcdescripcion = fcdescripcion;
    }

    public String getFcusuario() {
        return fcusuario;
    }

    public void setFcusuario(String fcusuario) {
        this.fcusuario = fcusuario;
    }

    public Double getFitotal() {
        return fitotal;
    }

    public void setFitotal(Double fitotal) {
        this.fitotal = fitotal;
    }

    public Integer getFistatus() {
        return fistatus;
    }

    public void setFistatus(Integer fistatus) {
        this.fistatus = fistatus;
    }

    public Timestamp getFdfecha() {
        return fdfecha;
    }

    public void setFdfecha(Timestamp fdfecha) {
        this.fdfecha = fdfecha;
    }

    @Override
    public String toString() {
        return "Entradasinventario{" +
                "fiid=" + fiid +
                ", fcdescripcion='" + fcdescripcion + '\'' +
                ", fcusuario='" + fcusuario + '\'' +
                ", fitotal=" + fitotal +
                ", fistatus=" + fistatus +
                ", fdfecha=" + fdfecha +
                '}';
    }
}
