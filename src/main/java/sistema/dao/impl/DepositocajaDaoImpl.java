package sistema.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sistema.dao.DepositocajaDao;
import sistema.entity.Depositocaja;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class DepositocajaDaoImpl extends JdbcDaoImpl implements DepositocajaDao {


    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public DepositocajaDaoImpl(DataSource dataSource) {
        this.setDataSource(dataSource);
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

        public  List<Depositocaja> getDepositos( Integer fiid){

        List<Depositocaja> lista = new ArrayList<Depositocaja>();

            String sql = "SELECT FIID, FIDEPOSITO, FCDESCRIPCION, FICORTECAJA, FCUSUARIO, FDFECHA from depositoscaja where fiid="+fiid;
            String sql2 = "SELECT FIID, FIDEPOSITO, FCDESCRIPCION, FICORTECAJA, FCUSUARIO, FDFECHA from depositoscaja";

            String sql3 = (fiid!=null)? sql:sql2;

            List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql3);
            for (Map row : rows) {
                Depositocaja depositocaja = new Depositocaja();
                depositocaja.setFiid((Integer) row.get("fiid"));
                depositocaja.setFideposito((Double) row.get("fideposito"));
                depositocaja.setFcdescripcion((String) row.get("fcdescripcion"));
                depositocaja.setFcusuario((String) row.get("fcusuario"));
                depositocaja.setFicortecaja((Integer) row.get("ficortecaja"));
                depositocaja.setFdfecha((Timestamp) row.get("fdfecha"));
                lista.add(depositocaja);
            }


        return lista;

    }

    public void crear(Double fideposito, String fcdescripcion, String fcusuario){

        jdbcTemplate.update("INSERT INTO DEPOSITOSCAJA (  FIDEPOSITO, FCDESCRIPCION, FCUSUARIO)VALUES(?,?,?)",fideposito,fcdescripcion,fcusuario);

    }

    public Double getTotalDepositos (){


        Double total = null;
        String sql = "SELECT SUM(fideposito) FROM depositoscaja where FICORTECAJA=0";

        String max = (String)getJdbcTemplate().queryForObject(
                sql, new Object[] {  }, String.class);

        max = (max==null)? String.valueOf(0) :max;
        total =Double.valueOf(max);
        return total;

    }


    public void updCortecaja(){

        jdbcTemplate.update("update depositoscaja set ficortecaja=1 where FICORTECAJA=0");
    }

}
