package crud.dao;


import crud.entity.Clientes;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface ClientesDao extends Repository<Clientes, Integer> {

  /*  void crearCliente(String cliente, String tienda, String email, String telefono);

    List<Clientes> getClientes(String text);
    Clientes obtenerCliente(Integer fiid);
    void actualizarCliente(Integer fiid, String cliente, String tienda, String email, String telefono);
    void eliminarCliente(Integer fiid);
*/

  List<Clientes> findAll();
}
