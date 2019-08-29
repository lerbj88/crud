package sistema.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sistema.dao.CortecajaDao;
import sistema.entity.Cortecaja;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class CortecajaDaoImpl extends JdbcDaoImpl implements CortecajaDao {


    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public CortecajaDaoImpl(DataSource dataSource) {
        this.setDataSource(dataSource);
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }



    public List<Cortecaja> getCortescaja(Integer fiid) {

        List<Cortecaja> lista = new ArrayList<Cortecaja>();

        String sql = "";
        String sql1 = "SELECT fiid, ficantidad_inicial, firetiro, ficajarestante, fcdescripcion, fcusuario, fistatus, fdfecha FROM cortescaja where fiid = " + fiid ;
        String sql2 = "SELECT fiid, ficantidad_inicial, firetiro, ficajarestante, fcdescripcion, fcusuario, fistatus, fdfecha FROM cortescaja order by fiid desc";

        sql = (fiid == null) ? sql2 : sql1;

        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        for (Map row : rows) {
            Cortecaja cortecaja = new Cortecaja();
            cortecaja.setFiid((Integer) row.get("fiid"));
            cortecaja.setFicantidad_inicial((Double) row.get("ficantidad_inicial"));
            cortecaja.setFiretiro((Double) row.get("firetiro"));
            cortecaja.setFicajarestante((Double) row.get("ficajarestante"));
            cortecaja.setFcdescripcion((String) row.get("fcdescripcion"));
            cortecaja.setFcusuario((String) row.get("fcusuario"));
            cortecaja.setFistatus((Integer) row.get("fistatus"));
            cortecaja.setFdfecha((Timestamp) row.get("fdfecha"));
            lista.add(cortecaja);
        }

        logger.info(lista);
        return lista;

    }


    public Double totalRestante(){

        Double val = null;

        String sql = "SELECT  ficajarestante  FROM cortescaja where fistatus=1 order by fdfecha desc limit 1   ";
        String max = (String)getJdbcTemplate().queryForObject(
                sql, new Object[] {  }, String.class);

        val =Double.valueOf(max);
        logger.warn("valor de ficajarestante "+val);

        return val;
    }

    public void crear(Double totalcajainicial, Double firetiro, String fcdescripcion, String user, Double cajarestante){

        jdbcTemplate.update("INSERT INTO CORTESCAJA (FICANTIDAD_INICIAL,  FIRETIRO, FCDESCRIPCION, FCUSUARIO, FICAJARESTANTE)VALUES(?,?,?,?,?)",totalcajainicial,firetiro,fcdescripcion,user,cajarestante);


    }

    public   void cancelarCortecaja(Integer fiid){

        jdbcTemplate.update("UPDATE cortescaja set fistatus=2 WHERE FIID=?", fiid);

    }

}
