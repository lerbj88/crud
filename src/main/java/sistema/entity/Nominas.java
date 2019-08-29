package sistema.entity;

import java.sql.Timestamp;

public class Nominas {

    private Integer fiid;
    private Integer fiempleado;
    private Double fitotalbruto;
    private Double fidescuento;
    private Double fitotalneto;
    private Timestamp fdfecha;

    public Nominas() {
    }

    public Nominas(Integer fiid, Integer fiempleado, Double fitotalbruto, Double fidescuento, Double fitotalneto, Timestamp fdfecha) {
        this.fiid = fiid;
        this.fiempleado = fiempleado;
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

    public Integer getFiempleado() {
        return fiempleado;
    }

    public void setFiempleado(Integer fiempleado) {
        this.fiempleado = fiempleado;
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
        return "Nominas{" +
                "fiid=" + fiid +
                ", fiempleado=" + fiempleado +
                ", fitotalbruto=" + fitotalbruto +
                ", fidescuento=" + fidescuento +
                ", fitotalneto=" + fitotalneto +
                ", fdfecha=" + fdfecha +
                '}';
    }
}
