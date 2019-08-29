package sistema.dto;

import java.sql.Timestamp;

public class FacturasDto {

    private Integer fiid;
    private String fccliente;
    private String fcplacas;
    private String fcempleado;
    private Double fitotal;
    private Timestamp fdfecha;
    private Integer fistatus;

    public FacturasDto() {
    }

    public FacturasDto(Integer fiid, String fccliente, String fcplacas,  Double fitotal, Timestamp fdfecha, Integer fistatus) {
        this.fiid = fiid;
        this.fccliente = fccliente;
        this.fcplacas = fcplacas;
        this.fitotal = fitotal;
        this.fdfecha = fdfecha;
        this.fistatus = fistatus;
    }

    public FacturasDto(Integer fiid, String fccliente, String fcplacas, String fcempleado, Double fitotal, Timestamp fdfecha, Integer fistatus) {
        this.fiid = fiid;
        this.fccliente = fccliente;
        this.fcplacas = fcplacas;
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

    public String getFcempleado() {
        return fcempleado;
    }

    public String getFcplacas() {
        return fcplacas;
    }

    public void setFcplacas(String fcplacas) {
        this.fcplacas = fcplacas;
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
        return "FacturasDto{" +
                "fiid=" + fiid +
                ", fccliente='" + fccliente + '\'' +
                ", fcplacas='" + fcplacas + '\'' +
                ", fcempleado='" + fcempleado + '\'' +
                ", fitotal=" + fitotal +
                ", fdfecha=" + fdfecha +
                ", fistatus=" + fistatus +
                '}';
    }
}
