package sistema.dto;

public class ArticulosDto {

    private Integer id;
    private Integer no;
    private Integer cantidad;
    private String fcclave;
    private String fcdescripcion;
    private Double fiprecio;
    private Double fiimporte;

    public ArticulosDto() {
    }

    public ArticulosDto(Integer id, Integer no, Integer cantidad, String fcclave, String fcdescripcion, Double fiprecio, Double fiimporte) {
        this.id = id;
        this.no = no;
        this.cantidad = cantidad;
        this.fcclave = fcclave;
        this.fcdescripcion = fcdescripcion;
        this.fiprecio = fiprecio;
        this.fiimporte = fiimporte;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
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
        return "ArticulosDto{" +
                "id=" + id +
                "no=" + no +
                ", cantidad=" + cantidad +
                ", fcclave='" + fcclave + '\'' +
                ", fcdescripcion='" + fcdescripcion + '\'' +
                ", fiprecio=" + fiprecio +
                ", fiimporte=" + fiimporte +

                '}';
    }
}
