package sistema.dao;

import sistema.entity.Vehiculos;

import java.util.List;

public interface VehiculosDao {

    Vehiculos obtenerVehiculo(String fcplaca);
    List<Vehiculos> obenerVehiculos (Integer ficliente);
    void crearVehiculo (Integer fiid, String fcplacas, String fccolor, String fcmarca);
    void eliminarAuto(Integer fiid);
    Integer existeAuto (String fcplacas);

}
