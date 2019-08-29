package sistema.entity;

import java.sql.Timestamp;

public class Facturas {

    private Integer fiid;
    private Integer ficliente;
    private Integer fiempleado;
    private Integer fitotal;
    private Timestamp fdfecha;

    public Facturas() {
    }

    public Facturas(Integer fiid, Integer ficliente, Integer fiempleado, Integer fitotal, Timestamp fdfecha) {
        this.fiid = fiid;
        this.ficliente = ficliente;
        this.fiempleado = fiempleado;
        this.fitotal = fitotal;
        this.fdfecha = fdfecha;
    }

    public Integer getFiid() {
        return fiid;
    }

    public void setFiid(Integer fiid) {
        this.fiid = fiid;
    }

    public Integer getFicliente() {
        return ficliente;
    }

    public void setFicliente(Integer ficliente) {
        this.ficliente = ficliente;
    }

    public Integer getFiempleado() {
        return fiempleado;
    }

    public void setFiempleado(Integer fiempleado) {
        this.fiempleado = fiempleado;
    }

    public Integer getFitotal() {
        return fitotal;
    }

    public void setFitotal(Integer fitotal) {
        this.fitotal = fitotal;
    }

    public Timestamp getFdfecha() {
        return fdfecha;
    }

    public void setFdfecha(Timestamp fdfecha) {
        this.fdfecha = fdfecha;
    }

    @Override
    public String toString() {
        return "Facturas{" +
                "fiid=" + fiid +
                ", ficliente=" + ficliente +
                ", fiempleado=" + fiempleado +
                ", fitotal=" + fitotal +
                ", fdfecha=" + fdfecha +
                '}';
    }
}
