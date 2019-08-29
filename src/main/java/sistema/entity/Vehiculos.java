package sistema.entity;

import java.sql.Timestamp;

public class Vehiculos {

    private Integer fiid;
    private String fcplacas;
    private String fccolor;
    private String fcmarca;
    private Timestamp fdfecha;

    public Vehiculos() {
    }

    public Vehiculos(Integer fiid, String fcplacas, String fccolor, String fcmarca, Timestamp fdfecha) {
        this.fiid = fiid;
        this.fcplacas = fcplacas;
        this.fccolor = fccolor;
        this.fcmarca = fcmarca;
        this.fdfecha = fdfecha;
    }

    public Integer getFiid() {
        return fiid;
    }

    public void setFiid(Integer fiid) {
        this.fiid = fiid;
    }

    public String getFcplacas() {
        return fcplacas;
    }

    public void setFcplacas(String fcplacas) {
        this.fcplacas = fcplacas;
    }

    public String getFccolor() {
        return fccolor;
    }

    public void setFccolor(String fccolor) {
        this.fccolor = fccolor;
    }

    public String getFcmarca() {
        return fcmarca;
    }

    public void setFcmarca(String fcmarca) {
        this.fcmarca = fcmarca;
    }

    public Timestamp getFdfecha() {
        return fdfecha;
    }

    public void setFdfecha(Timestamp fdfecha) {
        this.fdfecha = fdfecha;
    }

    @Override
    public String toString() {
        return "Vehiculos{" +
                "fiid=" + fiid +
                ", fcplacas='" + fcplacas + '\'' +
                ", fccolor='" + fccolor + '\'' +
                ", fcmarca='" + fcmarca + '\'' +
                ", fdfecha=" + fdfecha +
                '}';
    }
}
