package sistema.entity;

public class Entradasinventario_detalle {

    private Integer fientradainventario;
    private Integer finum;
    private Integer fiarticulo;
    private Integer ficantidad;
    private String fcclave;
    private String fcdescripcion;
    private Double ficosto;
    private Double fiimporte;

    public Entradasinventario_detalle() {
    }

    public Entradasinventario_detalle(Integer fientradainventario, Integer finum, Integer fiarticulo, Integer ficantidad, String fcclave, String fcdescripcion, Double ficosto, Double fiimporte) {
        this.fientradainventario = fientradainventario;
        this.finum = finum;
        this.fiarticulo = fiarticulo;
        this.ficantidad = ficantidad;
        this.fcclave = fcclave;
        this.fcdescripcion = fcdescripcion;
        this.ficosto = ficosto;
        this.fiimporte = fiimporte;
    }

    public Integer getFientradainventario() {
        return fientradainventario;
    }

    public void setFientradainventario(Integer fientradainventario) {
        this.fientradainventario = fientradainventario;
    }

    public Integer getFinum() {
        return finum;
    }

    public void setFinum(Integer finum) {
        this.finum = finum;
    }

    public Integer getFiarticulo() {
        return fiarticulo;
    }

    public void setFiarticulo(Integer fiarticulo) {
        this.fiarticulo = fiarticulo;
    }

    public Integer getFicantidad() {
        return ficantidad;
    }

    public void setFicantidad(Integer ficantidad) {
        this.ficantidad = ficantidad;
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

    public Double getFicosto() {
        return ficosto;
    }

    public void setFicosto(Double ficosto) {
        this.ficosto = ficosto;
    }

    public Double getFiimporte() {
        return fiimporte;
    }

    public void setFiimporte(Double fiimporte) {
        this.fiimporte = fiimporte;
    }

    @Override
    public String toString() {
        return "Entradasinventario_detalle{" +
                "fientradainventario=" + fientradainventario +
                ", finum=" + finum +
                ", fiarticulo=" + fiarticulo +
                ", ficantidad=" + ficantidad +
                ", fcclave='" + fcclave + '\'' +
                ", fcdescripcion='" + fcdescripcion + '\'' +
                ", ficosto=" + ficosto +
                ", fiimporte=" + fiimporte +
                '}';
    }
}
