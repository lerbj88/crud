package sistema.entity;

public class Facturas_detalle {

    private Integer fifactura;
    private Integer finum;
    private Integer fiarticulo;
    private Integer ficantidad;
    private String fcclave;
    private String fcdescripcion;
    private Double fiprecio;
    private Double fiimporte;

    public Facturas_detalle() {
    }

    public Facturas_detalle(Integer fifactura, Integer finum, Integer fiarticulo, Integer ficantidad, String fcclave, String fcdescripcion, Double fiprecio, Double fiimporte) {
        this.fifactura = fifactura;
        this.finum = finum;
        this.fiarticulo = fiarticulo;
        this.ficantidad = ficantidad;
        this.fcclave = fcclave;
        this.fcdescripcion = fcdescripcion;
        this.fiprecio = fiprecio;
        this.fiimporte = fiimporte;
    }

    public Integer getFifactura() {
        return fifactura;
    }

    public void setFifactura(Integer fifactura) {
        this.fifactura = fifactura;
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

    public Double getFiprecio() {
        return fiprecio;
    }

    public void setFiprecio(Double fiprecio) {
        this.fiprecio = fiprecio;
    }

    public Double getFiimporte() {
        return fiimporte;
    }

    public void setFiimporte(Double fiimporte) {
        this.fiimporte = fiimporte;
    }

    @Override
    public String toString() {
        return "Facturas_detalle{" +
                "fifactura=" + fifactura +
                ", finum=" + finum +
                ", fiarticulo=" + fiarticulo +
                ", ficantidad=" + ficantidad +
                ", fcclave='" + fcclave + '\'' +
                ", fcdescripcion='" + fcdescripcion + '\'' +
                ", fiprecio=" + fiprecio +
                ", fiimporte=" + fiimporte +
                '}';
    }
}
