package sistema.dto;

import java.sql.Timestamp;

public class Facturas_DetalleDto {

    private Integer fiid;
    private String fccliente;
    private String fccorreo;
    private String fctelefono;
    private String fcplacas;
    private String fccolor;
    private String fcmarca;
    private String fcempleado;
    private Double fitotal;
    private Timestamp fdfecha;
    private Integer fistatus;

    public Facturas_DetalleDto() {
    }

    public Facturas_DetalleDto(Integer fiid, String fccliente, String fccorreo, String fctelefono, String fcplacas, String fccolor, String fcmarca, String fcempleado, Double fitotal, Timestamp fdfecha, Integer fistatus) {
        this.fiid = fiid;
        this.fccliente = fccliente;
        this.fccorreo = fccorreo;
        this.fctelefono = fctelefono;
        this.fcplacas = fcplacas;
        this.fccolor = fccolor;
        this.fcmarca = fcmarca;
        this.fcempleado = fcempleado;
        this.fitotal = fitotal;
        this.fdfecha = fdfecha;
        this.fistatus = fistatus;
    }

    public Integer getFiid() {
        return fiid;
    }

    public void setFiid(Integer fiid) {
        this.fiid = fiid;
    }

    public String getFccliente() {
        return fccliente;
    }

    public void setFccliente(String fccliente) {
        this.fccliente = fccliente;
    }

    public String getFccorreo() {
        return fccorreo;
    }

    public void setFccorreo(String fccorreo) {
        this.fccorreo = fccorreo;
    }

    public String getFctelefono() {
        return fctelefono;
    }

    public void setFctelefono(String fctelefono) {
        this.fctelefono = fctelefono;
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

    public String getFcempleado() {
        return fcempleado;
    }

    public void setFcempleado(String fcempleado) {
        this.fcempleado = fcempleado;
    }

    public Double getFitotal() {
        return fitotal;
    }

    public void setFitotal(Double fitotal) {
        this.fitotal = fitotal;
    }

    public Timestamp getFdfecha() {
        return fdfecha;
    }

    public void setFdfecha(Timestamp fdfecha) {
        this.fdfecha = fdfecha;
    }

    public Integer getFistatus() {
        return fistatus;
    }

    public void setFistatus(Integer fistatus) {
        this.fistatus = fistatus;
    }

    @Override
    public String toString() {
        return "Facturas_DetalleDto{" +
                "fiid=" + fiid +
                ", fccliente='" + fccliente + '\'' +
                ", fccorreo='" + fccorreo + '\'' +
                ", fctelefono='" + fctelefono + '\'' +
                ", fcplacas='" + fcplacas + '\'' +
                ", fccolor='" + fccolor + '\'' +
                ", fcmarca='" + fcmarca + '\'' +
                ", fcempleado='" + fcempleado + '\'' +
                ", fitotal=" + fitotal +
                ", fdfecha=" + fdfecha +
                ", fistatus=" + fistatus +
                '}';
    }
}
