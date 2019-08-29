package sistema.entity;


public class Empleado {

    private Integer fiid;
    private String fcnombre;
    private String fccorreo;
    private String fcdireccion;
    private String fctelefono;
    private String fdfechanacimiento;
    private String fdfechaingreso;
    private Integer fiporcentaje;
    private Integer fipuesto;
    private String fccurp;
    private Boolean fnstatus;

    public Empleado() {
    }

    public Empleado(Integer fiid, String fcnombre, String fccorreo, String fcdireccion, String fctelefono, String fdfechanacimiento, String fdfechaingreso, Integer fiporcentaje, Integer fipuesto, String fccurp, Boolean fnstatus) {
        this.fiid = fiid;
        this.fcnombre = fcnombre;
        this.fccorreo = fccorreo;
        this.fcdireccion = fcdireccion;
        this.fctelefono = fctelefono;
        this.fdfechanacimiento = fdfechanacimiento;
        this.fdfechaingreso = fdfechaingreso;
        this.fiporcentaje = fiporcentaje;
        this.fipuesto = fipuesto;
        this.fccurp = fccurp;
        this.fnstatus = fnstatus;
    }

    public Integer getFiid() {
        return fiid;
    }

    public void setFiid(Integer fiid) {
        this.fiid = fiid;
    }

    public String getFcnombre() {
        return fcnombre;
    }

    public void setFcnombre(String fcnombre) {
        this.fcnombre = fcnombre;
    }

    public String getFccorreo() {
        return fccorreo;
    }

    public void setFccorreo(String fccorreo) {
        this.fccorreo = fccorreo;
    }

    public String getFcdireccion() {
        return fcdireccion;
    }

    public void setFcdireccion(String fcdireccion) {
        this.fcdireccion = fcdireccion;
    }

    public String getFctelefono() {
        return fctelefono;
    }

    public void setFctelefono(String fctelefono) {
        this.fctelefono = fctelefono;
    }

    public String getFdfechanacimiento() {
        return fdfechanacimiento;
    }

    public void setFdfechanacimiento(String fdfechanacimiento) {
        this.fdfechanacimiento = fdfechanacimiento;
    }

    public String getFdfechaingreso() {
        return fdfechaingreso;
    }

    public void setFdfechaingreso(String fdfechaingreso) {
        this.fdfechaingreso = fdfechaingreso;
    }

    public Integer getFiporcentaje() {
        return fiporcentaje;
    }

    public void setFiporcentaje(Integer fiporcentaje) {
        this.fiporcentaje = fiporcentaje;
    }

    public Integer getFipuesto() {
        return fipuesto;
    }

    public void setFipuesto(Integer fipuesto) {
        this.fipuesto = fipuesto;
    }

    public String getFccurp() {
        return fccurp;
    }

    public void setFccurp(String fccurp) {
        this.fccurp = fccurp;
    }

    public Boolean getFnstatus() {
        return fnstatus;
    }

    public void setFnstatus(Boolean fnstatus) {
        this.fnstatus = fnstatus;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "fiid=" + fiid +
                ", fcnombre='" + fcnombre + '\'' +
                ", fccorreo='" + fccorreo + '\'' +
                ", fcdireccion='" + fcdireccion + '\'' +
                ", fctelefono='" + fctelefono + '\'' +
                ", fdfechanacimiento=" + fdfechanacimiento +
                ", fdfechaingreso=" + fdfechaingreso +
                ", fiporcentaje=" + fiporcentaje +
                ", fipuesto=" + fipuesto +
                ", fccurp='" + fccurp + '\'' +
                ", fnstatus=" + fnstatus +
                '}';
    }
}
