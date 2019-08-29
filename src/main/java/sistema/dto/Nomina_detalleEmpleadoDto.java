package sistema.dto;

import java.math.BigInteger;

public class Nomina_detalleEmpleadoDto {

    private BigInteger finum;
    private Integer fiarticulo;
    private String fcclave;
    private String fcdescripcion;
    private Double fiimporte;
    private Double fipercepcion;

    public Nomina_detalleEmpleadoDto() {
    }

    public Nomina_detalleEmpleadoDto(BigInteger finum, Integer fiarticulo, String fcclave, String fcdescripcion, Double fiimporte, Double fipercepcion) {
        this.finum = finum;
        this.fiarticulo = fiarticulo;
        this.fcclave = fcclave;
        this.fcdescripcion = fcdescripcion;
        this.fiimporte = fiimporte;
        this.fipercepcion = fipercepcion;
    }


    public BigInteger getFinum() {
        return finum;
    }

    public void setFinum(BigInteger finum) {
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

    public Double getFiimporte() {
        return fiimporte;
    }

    public void setFiimporte(Double fiimporte) {
        this.fiimporte = fiimporte;
    }

    public Double getFipercepcion() {
        return fipercepcion;
    }

    public void setFipercepcion(Double fipercepcion) {
        this.fipercepcion = fipercepcion;
    }

    @Override
    public String toString() {
        return "Nomina_detalleEmpleadoDto{" +
                "finum=" + finum +
                ", fiarticulo=" + fiarticulo +
                ", fcclave='" + fcclave + '\'' +
                ", fcdescripcion='" + fcdescripcion + '\'' +
                ", fiimporte=" + fiimporte +
                ", fipercepcion=" + fipercepcion +
                '}';
    }
}
