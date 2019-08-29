package sistema.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sistema.dao.VehiculosDao;
import sistema.entity.Vehiculos;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class VehiculosDaoImpl extends JdbcDaoImpl implements VehiculosDao {

    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public VehiculosDaoImpl(DataSource dataSource) {
        this.setDataSource(dataSource);
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }



    public Vehiculos obtenerVehiculo(String fcplaca){
        Vehiculos vehiculo = null;


        String sql = "SELECT fiid, fcplacas, fccolor, fcmarca  FROM Vehiculos WHERE fcplacas=?";

          vehiculo = (Vehiculos) getJdbcTemplate().queryForObject(
                sql, new Object[] { fcplaca },
                new BeanPropertyRowMapper(Vehiculos.class));

        return vehiculo;
    }


    public List<Vehiculos> obenerVehiculos (Integer ficliente){

        List<Vehiculos> lista = new ArrayList<Vehiculos>();

        String sql = "select a.fiid, a.fcplacas, a.fccolor, a.fcmarca, a.fdfecha from vehiculos a left join clientes_vehiculos b on a.fiid= b.fivehiculoid where b.ficlienteid="+ficliente;


        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        for (Map row : rows) {
            Vehiculos vehiculos = new Vehiculos();
            vehiculos.setFiid((Integer)row.get("fiid"));
            vehiculos.setFcplacas((String)row.get("fcplacas"));
            vehiculos.setFccolor((String)row.get("fccolor"));
            vehiculos.setFcmarca((String)row.get("fcmarca"));
            vehiculos.setFdfecha((Timestamp) row.get("fdfecha"));
            lista.add(vehiculos);
        }

        return lista;
    }
    public void crearVehiculo (Integer fiid, String fcplacas, String fccolor, String fcmarca){

        fcplacas = fcplacas.toUpperCase();

        jdbcTemplate.update("INSERT INTO VEHICULOS (FCPLACAS,  FCCOLOR, FCMARCA)VALUES(?,?,?)",fcplacas,fccolor,fcmarca);

        Integer idauto = getautoId(fcplacas);

        jdbcTemplate.update("INSERT INTO CLIENTES_VEHICULOS (FICLIENTEID, FIVEHICULOID)VALUES(?,?)",fiid,idauto);

    }



    private Integer getautoId (String fcplacas){


        String sql = "SELECT fiid FROM vehiculos where fcplacas='"+fcplacas+"'";

        String autoid = (String)getJdbcTemplate().queryForObject(
                sql, new Object[] {  }, String.class);

        Integer id =Integer.parseInt(autoid);

        return id;

    }



    public Integer existeAuto (String fcplacas){

        fcplacas= fcplacas.toUpperCase();


        String sql = "SELECT count(*) FROM vehiculos where fcplacas='"+fcplacas+"'";

        String autoid = (String)getJdbcTemplate().queryForObject(
                sql, new Object[] {  }, String.class);

        Integer id =Integer.parseInt(autoid);

        return id;

    }


    public void eliminarAuto(Integer fiid){

        jdbcTemplate.update("DELETE  FROM CLIENTES_VEHICULOS  WHERE FIVEHICULOID=?",fiid);
        jdbcTemplate.update("DELETE  FROM VEHICULOS  WHERE FIID=?",fiid);

    }

}
