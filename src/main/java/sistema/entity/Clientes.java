package sistema.entity;

import java.sql.Timestamp;

public class Clientes {

private  Integer fiid;
private  String fccliente;

private String fcemail;
private String fctelefono;
private Timestamp fdfecha;

    public Clientes() {
    }

    public Clientes(Integer fiid, String fccliente,  String fcemail, String fctelefono, Timestamp fdfecha) {
        this.fiid = fiid;
        this.fccliente = fccliente;
        this.fcemail = fcemail;
        this.fctelefono = fctelefono;
        this.fdfecha = fdfecha;
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


    public String getFcemail() {
        return fcemail;
    }

    public void setFcemail(String fcemail) {
        this.fcemail = fcemail;
    }

    public String getFctelefono() {
        return fctelefono;
    }

    public void setFctelefono(String fctelefono) {
        this.fctelefono = fctelefono;
    }

    public Timestamp getFdfecha() {
        return fdfecha;
    }

    public void setFdfecha(Timestamp fdfecha) {
        this.fdfecha = fdfecha;
    }

    @Override
    public String toString() {
        return "Clientes{" +
                "fiid=" + fiid +
                ", fccliente='" + fccliente + '\'' +
                ", fcemail='" + fcemail + '\'' +
                ", fctelefono='" + fctelefono + '\'' +
                ", fdfecha=" + fdfecha +
                '}';
    }
}
