package sistema.dao;

import sistema.entity.Empleado;

import java.util.List;

public interface    EmpleadosDao {
    List<Empleado>listarEmpleados(String text);
    List<Empleado>listarEmpleados();
    void crearEmpleado(String fcnombre, String fccorreo, String fcdireccion, String fctelefono, String fdfechanacimiento, String fdfechaingreso, Integer fiporcentaje, Integer fipuesto, String fccurp, Integer fnstatus) ;
    Empleado obtenerEmpleado(Integer fiid);
    void actualizarEmpleado (Integer fiid, String fcnombre, String fccorreo, String fcdireccion, String fctelefono, String fdfechanacimiento, String fdfechaingreso, Integer fiporcentaje, Integer fipuesto, String fccurp, Boolean fnstatus);
    void eliminarEmpleado(Integer fiid);
    String getlLavador (Integer filavador);
}
