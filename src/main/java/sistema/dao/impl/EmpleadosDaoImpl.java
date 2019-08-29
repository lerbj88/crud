package sistema.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sistema.dao.EmpleadosDao;
import sistema.entity.Empleado;

import javax.sql.DataSource;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class EmpleadosDaoImpl  extends JdbcDaoImpl implements EmpleadosDao {

    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public EmpleadosDaoImpl(DataSource dataSource) {
        this.setDataSource(dataSource);
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public List<Empleado> listarEmpleados(String text){



        List<Empleado> lista = new ArrayList<Empleado>();
        String texto = "'%"+text+"%'";
        String sql="";
        String sql1 = "SELECT  fiid, fcnombre, fccorreo, fcdireccion, fctelefono, fdfechanacimiento,fdfechaingreso,fiporcentaje,fipuesto,fccurp,fnstatus FROM empleados where fcnombre like "+texto+" or fccorreo like "+texto+" or fiid like "+texto;
        String sql2 = "SELECT  fiid, fcnombre, fccorreo, fcdireccion, fctelefono, fdfechanacimiento, fdfechaingreso,fiporcentaje,fipuesto,fccurp,fnstatus FROM empleados  ";

        sql =(text==null) ? sql2 : sql1;

        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        for (Map row : rows) {
            Empleado empleado = new Empleado();
            empleado.setFiid((Integer)row.get("fiid"));
            empleado.setFcnombre((String)row.get("fcnombre"));
            empleado.setFccorreo((String)row.get("fccorreo"));
            empleado.setFcdireccion((String)row.get("fcdireccion"));
            empleado.setFctelefono((String)row.get("fctelefono"));
            empleado.setFdfechanacimiento(String.valueOf((Date) row.get("fdfechanacimiento")));
            empleado.setFdfechaingreso(String.valueOf((Date) row.get("fdfechaingreso")));
            empleado.setFiporcentaje((Integer)row.get("fiporcentaje"));
            empleado.setFipuesto((Integer)row.get("fipuesto"));
            empleado.setFccurp((String)row.get("fccurp"));
            empleado.setFnstatus((Boolean)row.get("fnstatus"));

            lista.add(empleado);
        }


        logger.info(lista);
        return lista;
    }

    public void crearEmpleado(String fcnombre, String fccorreo, String fcdireccion, String fctelefono, String fdfechanacimiento, String fdfechaingreso, Integer fiporcentaje, Integer fipuesto, String fccurp, Integer fnstatus)  {

        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechanacimiento = LocalDate.parse(fdfechanacimiento, inputFormat);
        LocalDate fechaingreso = LocalDate.parse(fdfechaingreso, inputFormat);


        jdbcTemplate.update("INSERT INTO EMPLEADOS (FCNOMBRE, FCCORREO, FCDIRECCION, FCTELEFONO, fdfechanacimiento , fdfechaingreso, fiporcentaje, fipuesto,FCCURP, fnstatus)VALUES(?,?,?,?,?,?,?,?,?,?)",fcnombre,fccorreo,fcdireccion,fctelefono, fechanacimiento, fechaingreso, fiporcentaje, fipuesto, fccurp, fnstatus);

    }


    public Empleado  obtenerEmpleado(Integer fiid){

        String sql = "SELECT fiid, fcnombre, fccorreo, fcdireccion, fctelefono, fdfechanacimiento,fdfechaingreso,fiporcentaje,fipuesto,fccurp,fnstatus  FROM empleados WHERE fiid=?";

        Empleado  empleado = (Empleado) getJdbcTemplate().queryForObject(
                sql, new Object[] { fiid },
                new BeanPropertyRowMapper(Empleado.class));

        return empleado;
    }


    public void actualizarEmpleado(Integer fiid, String fcnombre, String fccorreo, String fcdireccion, String fctelefono, String fdfechanacimiento, String fdfechaingreso, Integer fiporcentaje, Integer fipuesto, String fccurp, Boolean fnstatus){


        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechanacimiento = LocalDate.parse(fdfechanacimiento, inputFormat);
        LocalDate fechaingreso = LocalDate.parse(fdfechaingreso, inputFormat);

        jdbcTemplate.update("UPDATE empleados set fcnombre=?, fccorreo=?, fcdireccion=?, fctelefono=?, fdfechanacimiento=?, fdfechaingreso=?, fiporcentaje=?, fipuesto=?,fccurp=?, fnstatus=? WHERE FIID=?", fcnombre,fccorreo,fcdireccion,fctelefono,fechanacimiento,fechaingreso,fiporcentaje,fipuesto,fccurp,fnstatus,fiid);

    }

    public void eliminarEmpleado(Integer fiid){

        jdbcTemplate.update("DELETE  FROM empleados  WHERE FIID=?",fiid);

    }

    public List<Empleado> listarEmpleados(){

        List<Empleado> lista = new ArrayList<Empleado>();

        String sql = "SELECT  fiid, fcnombre, fccorreo, fcdireccion, fctelefono, fdfechanacimiento, fdfechaingreso,fiporcentaje,fipuesto,fccurp,fnstatus FROM empleados where fnstatus=1 ";

        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        for (Map row : rows) {
            Empleado empleado = new Empleado();
            empleado.setFiid((Integer)row.get("fiid"));
            empleado.setFcnombre((String)row.get("fcnombre"));
            empleado.setFccorreo((String)row.get("fccorreo"));
            empleado.setFcdireccion((String)row.get("fcdireccion"));
            empleado.setFctelefono((String)row.get("fctelefono"));
            empleado.setFdfechanacimiento(String.valueOf((Date) row.get("fdfechanacimiento")));
            empleado.setFdfechaingreso(String.valueOf((Date) row.get("fdfechaingreso")));
            empleado.setFiporcentaje((Integer)row.get("fiporcentaje"));
            empleado.setFipuesto((Integer)row.get("fipuesto"));
            empleado.setFccurp((String)row.get("fccurp"));
            empleado.setFnstatus((Boolean)row.get("fnstatus"));
            lista.add(empleado);
        }


        logger.info(lista);
        return lista;
    }


    public String getlLavador (Integer filavador){


        String sql = "SELECT fcnombre FROM empleados where fiid="+filavador;

        String lavador = (String)getJdbcTemplate().queryForObject(
                sql, new Object[] {  }, String.class);

        return lavador;

    }

}
