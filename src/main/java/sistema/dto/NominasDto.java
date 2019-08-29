package sistema.dto;

import java.sql.Timestamp;

public class NominasDto {

    private Integer fiid;
    private String fcempleado;
    private Double fitotalbruto;
    private Double fidescuento;
    private Double fitotalneto;
    private Timestamp fdfecha;

    public NominasDto() {
    }

    public NominasDto(Integer fiid, String fcempleado, Double fitotalbruto, Double fidescuento, Double fitotalneto, Timestamp fdfecha) {
        this.fiid = fiid;
        this.fcempleado = fcempleado;
        this.fitotalbruto = fitotalbruto;
        this.fidescuento = fidescuento;
        this.fitotalneto = fitotalneto;
        this.fdfecha = fdfecha;
    }

    public Integer getFiid() {
        return fiid;
    }

    public void setFiid(Integer fiid) {
        this.fiid = fiid;
    }

    public String getFcempleado() {
        return fcempleado;
    }

    public void setFcempleado(String fcempleado) {
        this.fcempleado = fcempleado;
    }

    public Double getFitotalbruto() {
        return fitotalbruto;
    }

    public void setFitotalbruto(Double fitotalbruto) {
        this.fitotalbruto = fitotalbruto;
    }

    public Double getFidescuento() {
        return fidescuento;
    }

    public void setFidescuento(Double fidescuento) {
        this.fidescuento = fidescuento;
    }

    public Double getFitotalneto() {
        return fitotalneto;
    }

    public void setFitotalneto(Double fitotalneto) {
        this.fitotalneto = fitotalneto;
    }

    public Timestamp getFdfecha() {
        return fdfecha;
    }

    public void setFdfecha(Timestamp fdfecha) {
        this.fdfecha = fdfecha;
    }

    @Override
    public String toString() {
        return "NominasDto{" +
                "fiid=" + fiid +
                ", fcempleado='" + fcempleado + '\'' +
                ", fitotalbruto=" + fitotalbruto +
                ", fidescuento=" + fidescuento +
                ", fitotalneto=" + fitotalneto +
                ", fdfecha=" + fdfecha +
                '}';
    }
}

