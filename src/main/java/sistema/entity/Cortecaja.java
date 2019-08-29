package sistema.entity;

import java.sql.Timestamp;

public class Cortecaja {

    private Integer fiid;
    private Double ficantidad_inicial;
    private Double firetiro;
    private String fcdescripcion;
    private String fcusuario;
    private Integer fistatus;
    private Timestamp  fdfecha;
    private Double ficajarestante;


    public Cortecaja() {
    }


    public Cortecaja(Integer fiid, Double ficantidad_inicial, Double firetiro, String fcdescripcion, String fcusuario, Integer fistatus, Timestamp fdfecha, Double ficajarestante) {
        this.fiid = fiid;
        this.ficantidad_inicial = ficantidad_inicial;
        this.firetiro = firetiro;
        this.fcdescripcion = fcdescripcion;
        this.fcusuario = fcusuario;
        this.fistatus= fistatus;
        this.fdfecha = fdfecha;
        this.ficajarestante= ficajarestante;
    }


    public Integer getFiid() {
        return fiid;
    }

    public void setFiid(Integer fiid) {
        this.fiid = fiid;
    }

    public Double getFicantidad_inicial() {
        return ficantidad_inicial;
    }

    public void setFicantidad_inicial(Double ficantidad_inicial) {
        this.ficantidad_inicial = ficantidad_inicial;
    }

    public Double getFiretiro() {
        return firetiro;
    }

    public void setFiretiro(Double firetiro) {
        this.firetiro = firetiro;
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

    public Timestamp getFdfecha() {
        return fdfecha;
    }

    public Integer getFistatus() {
        return fistatus;
    }

    public void setFistatus(Integer fistatus) {
        this.fistatus = fistatus;
    }

    public void setFdfecha(Timestamp fdfecha) {
        this.fdfecha = fdfecha;
    }

    public Double getFicajarestante() {
        return ficajarestante;
    }

    public void setFicajarestante(Double ficajarestante) {
        this.ficajarestante = ficajarestante;
    }

    @Override
    public String toString() {
        return "Cortecaja{" +
                "fiid=" + fiid +
                ", ficantidad_inicial=" + ficantidad_inicial +
                ", firetiro=" + firetiro +
                ", fcdescripcion=" + fcdescripcion +
                ", fcusuario='" + fcusuario + '\'' +
                ", fistatus='" + fistatus + '\'' +
                ", fdfecha=" + fdfecha +
                ", ficajarestante=" + ficajarestante +
                '}';
    }
}
