package sistema.dto;

import java.sql.Timestamp;

public class Nominas_detalleDto {

    private Integer fiid;
    private String fcempleado;
    private String fcdireccion;
    private String telefono;
    private Timestamp Fechaingreso;
    private String fcpuesto;
    private Double fitotalbruto;
    private Double fidescuento;
    private Double fitotalneto;
    private Timestamp fdfecha;

    public Nominas_detalleDto() {
    }

    public Nominas_detalleDto(Integer fiid, String fcempleado, String fcdireccion, String telefono, Timestamp fechaingreso, String fcpuesto, Double fitotalbruto, Double fidescuento, Double fitotalneto, Timestamp fdfecha) {
        this.fiid = fiid;
        this.fcempleado = fcempleado;
        this.fcdireccion = fcdireccion;
        this.telefono = telefono;
        Fechaingreso = fechaingreso;
        this.fcpuesto = fcpuesto;
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

    public String getFcdireccion() {
        return fcdireccion;
    }

    public void setFcdireccion(String fcdireccion) {
        this.fcdireccion = fcdireccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Timestamp getFechaingreso() {
        return Fechaingreso;
    }

    public void setFechaingreso(Timestamp fechaingreso) {
        Fechaingreso = fechaingreso;
    }

    public String getFcpuesto() {
        return fcpuesto;
    }

    public void setFcpuesto(String fcpuesto) {
        this.fcpuesto = fcpuesto;
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
        return "Nominas_detalleDto{" +
                "fiid=" + fiid +
                ", fcempleado='" + fcempleado + '\'' +
                ", fcdireccion='" + fcdireccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", Fechaingreso=" + Fechaingreso +
                ", fcpuesto='" + fcpuesto + '\'' +
                ", fitotalbruto=" + fitotalbruto +
                ", fidescuento=" + fidescuento +
                ", fitotalneto=" + fitotalneto +
                ", fdfecha=" + fdfecha +
                '}';
    }
}
