package sistema.entity;

public class nominas_detalle {

    private Integer finomina;
    private Integer finum;
    private Integer fiarticulo;
    private String fcclave;
    private String fcdescripcion;
    private Double fiprecio;
    private Double fitotal;

    public nominas_detalle() {
    }

    public nominas_detalle(Integer finomina, Integer finum, Integer fiarticulo, String fcclave, String fcdescripcion, Double fiprecio, Double fitotal) {
        this.finomina = finomina;
        this.finum = finum;
        this.fiarticulo = fiarticulo;
        this.fcclave = fcclave;
        this.fcdescripcion = fcdescripcion;
        this.fiprecio = fiprecio;
        this.fitotal = fitotal;
    }

    public Integer getFinomina() {
        return finomina;
    }

    public void setFinomina(Integer finomina) {
        this.finomina = finomina;
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

    public Double getFitotal() {
        return fitotal;
    }

    public void setFitotal(Double fitotal) {
        this.fitotal = fitotal;
    }

    @Override
    public String toString() {
        return "nominas_detalle{" +
                "finomina=" + finomina +
                ", finum=" + finum +
                ", fiarticulo=" + fiarticulo +
                ", fcclave='" + fcclave + '\'' +
                ", fcdescripcion='" + fcdescripcion + '\'' +
                ", fiprecio=" + fiprecio +
                ", fitotal=" + fitotal +
                '}';
    }
}
