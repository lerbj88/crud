package sistema.dao;


import sistema.entity.Clientes;

import java.util.List;

public interface ClientesDao  {

   void crearCliente(String cliente, String email, String telefono);
   List<Clientes> getClientes(String text);
    Clientes obtenerCliente(Integer fiid);
    Clientes obtenerCliente(String fcplacas);
    void actualizarCliente(Integer fiid, String cliente,  String email, String telefono);
    void eliminarCliente(Integer fiid);


}
