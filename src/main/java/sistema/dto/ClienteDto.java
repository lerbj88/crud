package sistema.dto;

public class ClienteDto {

    private Integer fiidcliente;
    private String fcnombre;
    private String email;
    private String fctelefono;
    private Integer fiidvehiculo;
    private String fcplacas;
    private String Color;
    private String marca;


    public ClienteDto() {
    }


    public ClienteDto(Integer fiidcliente, String fcnombre, String email, String fctelefono, Integer fiidvehiculo, String fcplacas, String color, String marca) {
        this.fiidcliente = fiidcliente;
        this.fcnombre = fcnombre;
        this.email = email;
        this.fctelefono = fctelefono;
        this.fiidvehiculo = fiidvehiculo;
        this.fcplacas = fcplacas;
        Color = color;
        this.marca = marca;
    }


    public Integer getFiidcliente() {
        return fiidcliente;
    }

    public void setFiidcliente(Integer fiidcliente) {
        this.fiidcliente = fiidcliente;
    }

    public String getFcnombre() {
        return fcnombre;
    }

    public void setFcnombre(String fcnombre) {
        this.fcnombre = fcnombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFctelefono() {
        return fctelefono;
    }

    public void setFctelefono(String fctelefono) {
        this.fctelefono = fctelefono;
    }

    public Integer getFiidvehiculo() {
        return fiidvehiculo;
    }

    public void setFiidvehiculo(Integer fiidvehiculo) {
        this.fiidvehiculo = fiidvehiculo;
    }

    public String getFcplacas() {
        return fcplacas;
    }

    public void setFcplacas(String fcplacas) {
        this.fcplacas = fcplacas;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "ClienteDto{" +
                "fiidcliente=" + fiidcliente +
                ", fcnombre='" + fcnombre + '\'' +
                ", email='" + email + '\'' +
                ", fctelefono='" + fctelefono + '\'' +
                ", fiidvehiculo=" + fiidvehiculo +
                ", fcplacas='" + fcplacas + '\'' +
                ", Color='" + Color + '\'' +
                ", marca='" + marca + '\'' +
                '}';
    }
}
