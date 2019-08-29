package sistema.entity;

public class Articulos {

    private Integer fiid;
    private String fcclave;
    private String fcdescripcion;
    private String fccategoria;
    private String fcmarca;
    private String fccodigobarras;
    private Double ficosto;
    private Double fiprecio;
    private Integer fiexistencia;
    private Integer fitipo;
    private String fdfechaalta;
    private Boolean fnstatus;


    public Articulos() {
    }


    public Articulos(Integer fiid, String fcclave, String fcdescripcion, String fccategoria, String fcmarca, String fccodigobarras, Double ficosto, Double fiprecio, Integer fiexistencia, Integer fitipo, String fdfechaalta, Boolean fnstatus) {
        this.fiid = fiid;
        this.fcclave = fcclave;
        this.fcdescripcion = fcdescripcion;
        this.fccategoria = fccategoria;
        this.fcmarca = fcmarca;
        this.fccodigobarras = fccodigobarras;
        this.ficosto = ficosto;
        this.fiprecio = fiprecio;
        this.fiexistencia = fiexistencia;
        this.fitipo = fitipo;
        this.fdfechaalta = fdfechaalta;
        this.fnstatus = fnstatus;
    }

    public Integer getFiid() {
        return fiid;
    }

    public void setFiid(Integer fiid) {
        this.fiid = fiid;
    }

    public String getFcclave() {
        return fcclave;
    }

    public void setFcclave(String fcclave) {
        this.fcclave = fcclave;
    }

    public String getFcdescripcion() {
        return fcdescripcion;
    }

    public void setFcdescripcion(String fcdescripcion) {
        this.fcdescripcion = fcdescripcion;
    }

    public String getFccategoria() {
        return fccategoria;
    }

    public void setFccategoria(String fccategoria) {
        this.fccategoria = fccategoria;
    }

    public String getFcmarca() {
        return fcmarca;
    }

    public void setFcmarca(String fcmarca) {
        this.fcmarca = fcmarca;
    }

    public String getFccodigobarras() {
        return fccodigobarras;
    }

    public void setFccodigobarras(String fccodigobarras) {
        this.fccodigobarras = fccodigobarras;
    }

    public Double getFicosto() {
        return ficosto;
    }

    public void setFicosto(Double ficosto) {
        this.ficosto = ficosto;
    }

    public Double getFiprecio() {
        return fiprecio;
    }

    public void setFiprecio(Double fiprecio) {
        this.fiprecio = fiprecio;
    }

    public Integer getFiexistencia() {
        return fiexistencia;
    }

    public void setFiexistencia(Integer fiexistencia) {
        this.fiexistencia = fiexistencia;
    }

    public Integer getFitipo() {
        return fitipo;
    }

    public void setFitipo(Integer fitipo) {
        this.fitipo = fitipo;
    }

    public String getFdfechaalta() {
        return fdfechaalta;
    }

    public void setFdfechaalta(String fdfechaalta) {
        this.fdfechaalta = fdfechaalta;
    }

    public Boolean getFnstatus() {
        return fnstatus;
    }

    public void setFnstatus(Boolean fnstatus) {
        this.fnstatus = fnstatus;
    }

    @Override
    public String toString() {
        return "Articulos{" +
                "fiid=" + fiid +
                ", fcclave='" + fcclave + '\'' +
                ", fcdescripcion='" + fcdescripcion + '\'' +
                ", fccategoria='" + fccategoria + '\'' +
                ", fcmarca='" + fcmarca + '\'' +
                ", fccodigobarras='" + fccodigobarras + '\'' +
                ", ficosto=" + ficosto +
                ", fiprecio=" + fiprecio +
                ", fiexistencia=" + fiexistencia +
                ", fitipo=" + fitipo +
                ", fdfechaalta='" + fdfechaalta + '\'' +
                ", fnstatus=" + fnstatus +
                '}';
    }


}
