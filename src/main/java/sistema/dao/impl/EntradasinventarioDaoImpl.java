package sistema.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sistema.dao.EntradasinventarioDao;
import sistema.entity.Entradasinventario;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class EntradasinventarioDaoImpl extends JdbcDaoImpl implements EntradasinventarioDao {


    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public EntradasinventarioDaoImpl(DataSource dataSource) {
        this.setDataSource(dataSource);
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Entradasinventario> getEntradas(Integer fiid) {
        List<Entradasinventario> lista = new ArrayList<>();

        String sql = "";
        String sql1 = "SELECT fiid, fcdescripcion, fcusuario, fitotal, fistatus, fdfecha from entradasinventario where fiid = " + fiid;
        String sql2 = "SELECT fiid, fcdescripcion, fcusuario, fitotal, fistatus, fdfecha from entradasinventario ";

        sql = (fiid == null) ? sql2 : sql1;

        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        for (Map row : rows) {
            Entradasinventario entradasinventario = new Entradasinventario();
            entradasinventario.setFiid((Integer) row.get("fiid"));
            entradasinventario.setFcdescripcion((String) row.get("fcdescripcion"));
            entradasinventario.setFcusuario((String) row.get("fcusuario"));
            entradasinventario.setFitotal((Double) row.get("fitotal"));
            entradasinventario.setFistatus((Integer) row.get("fistatus"));
            entradasinventario.setFdfecha((Timestamp) row.get("fdfecha"));
            lista.add(entradasinventario);
        }


        return lista;

    }


    public Entradasinventario getEntrada(Integer fiid) {


        String sql = "SELECT  fiid, fcdescripcion, fcusuario,fitotal, fistatus, fdfecha FROM entradasinventario where fiid = ?";

        Entradasinventario entradasinventario = (Entradasinventario) getJdbcTemplate().queryForObject(
                sql, new Object[]{fiid},
                new BeanPropertyRowMapper(Entradasinventario.class));

        return entradasinventario;
    }


    public  void crearEntrada(String fcdescripcion, String fcusuario, Double fitotal){

        jdbcTemplate.update("INSERT INTO ENTRADASINVENTARIO (FCDESCRIPCION,  FCUSUARIO, FITOTAL)VALUES(?,?,?)",fcdescripcion,fcusuario,fitotal);

    }


    public Integer maxId (){


        String sql = "SELECT MAX(fiid) FROM entradasinventario";

        String max = (String)getJdbcTemplate().queryForObject(
                sql, new Object[] {  }, String.class);

        Integer max2 =Integer.parseInt(max);

        logger.warn("valor de max2" +max2);
        return max2;

    }



}
