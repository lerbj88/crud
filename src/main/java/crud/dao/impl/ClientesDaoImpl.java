package crud.dao.impl;

import crud.dao.ClientesDao;
import crud.entity.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Repository
@Transactional
public class ClientesDaoImpl extends JdbcDaoImpl implements ClientesDao {


    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public ClientesDaoImpl(DataSource dataSource) {
        this.setDataSource(dataSource);
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Clientes> getClientes(){


    String sql = "SELECT  fiid, fccliente, fctienda, fcemail, fctelefono, fdfecha FROM clientes  ";

    List<Clientes> lista = new ArrayList<Clientes>();

    List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
    for (Map row : rows) {
        Clientes clientes = new Clientes();
        clientes.setFiid((Integer)row.get("fiid"));
        clientes.setFccliente((String)row.get("fccliente"));
        clientes.setFctienda((String)row.get("fctienda"));
        clientes.setFcemail((String)row.get("fcemail"));
        clientes.setFctelefono((String)row.get("fctelefono"));
        clientes.setFdfecha((Timestamp) row.get("fdfecha"));
        lista.add(clientes);
    }

    logger.info(lista);
    return lista;
}


    public List<Clientes> getClientes(String text){

String texto = "'%"+text+"%'";
        String sql = "SELECT  fiid, fccliente, fctienda, fcemail, fctelefono, fdfecha FROM clientes where fccliente like "+texto+" or fctienda like "+texto+" or fcemail like "+texto;

        List<Clientes> list = new ArrayList<Clientes>();

        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        for (Map row : rows) {
            Clientes clientes = new Clientes();
            clientes.setFiid((Integer)row.get("fiid"));
            clientes.setFccliente((String)row.get("fccliente"));
            clientes.setFctienda((String)row.get("fctienda"));
            clientes.setFcemail((String)row.get("fcemail"));
            clientes.setFctelefono((String)row.get("fctelefono"));
            clientes.setFdfecha((Timestamp) row.get("fdfecha"));
            list.add(clientes);
        }

        logger.info(list);
        return list;
    }



    public void crearCliente(String cliente, String tienda, String email, String telefono){

        jdbcTemplate.update("INSERT INTO CLIENTES (FCCLIENTE, FCTIENDA, FCEMAIL, FCTELEFONO)VALUES(?,?,?,?)",cliente,tienda,email,telefono);


    }


    public Clientes  obtenerCliente(Integer fiid){

        String sql = "SELECT fiid, fccliente,fctienda, fcemail, fctelefono  FROM Clientes WHERE fiid=?";

        Clientes  cliente = (Clientes) getJdbcTemplate().queryForObject(
                sql, new Object[] { fiid },
                new BeanPropertyRowMapper(Clientes.class));

        return cliente;
    }

    public void actualizarCliente(Integer fiid, String cliente, String tienda, String email, String telefono){

        jdbcTemplate.update("UPDATE CLIENTES set FCCLIENTE=?, FCTIENDA=?, FCEMAIL=?, FCTELEFONO=? WHERE FIID=?",cliente,tienda,email,telefono,fiid);


    }

    public void eliminarCliente(Integer fiid){

        jdbcTemplate.update("DELETE  FROM CLIENTES  WHERE FIID=?",fiid);

    }

}
