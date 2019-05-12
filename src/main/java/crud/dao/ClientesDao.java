package crud.dao;


import crud.entity.Clientes;

import java.util.List;

public interface ClientesDao {

    void crearCliente(String cliente, String tienda, String email, String telefono);
    List<Clientes> getClientes () ;
    List<Clientes> getClientes(String text);
    Clientes obtenerCliente(Integer fiid);
    void actualizarCliente(Integer fiid, String cliente, String tienda, String email, String telefono);
    void eliminarCliente(Integer fiid);

}
