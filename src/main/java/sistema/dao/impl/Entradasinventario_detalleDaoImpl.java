package sistema.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sistema.dao.Entradasinventario_detalleDao;
import sistema.entity.Entradasinventario_detalle;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Transactional
@Repository
public class Entradasinventario_detalleDaoImpl extends JdbcDaoImpl implements Entradasinventario_detalleDao {


    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public Entradasinventario_detalleDaoImpl(DataSource dataSource) {
        this.setDataSource(dataSource);
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Entradasinventario_detalle> getDetalles(Integer fiid){
        List<Entradasinventario_detalle> lista = new ArrayList<Entradasinventario_detalle>();

        String sql = "SELECT  fientradainventario, finum, fiarticulo, ficantidad, fcclave, fcdescripcion, ficosto, fiimporte from entradasinventario_detalle where fientradainventario=" + fiid;

        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        for (Map row : rows) {
            Entradasinventario_detalle entradasinventario_detalle = new Entradasinventario_detalle();
            entradasinventario_detalle.setFientradainventario((Integer) row.get("fientradainventario"));
            entradasinventario_detalle.setFinum((Integer) row.get("finum"));
            entradasinventario_detalle.setFiarticulo((Integer) row.get("fiarticulo"));
            entradasinventario_detalle.setFicantidad((Integer) row.get("ficantidad"));
            entradasinventario_detalle.setFcclave((String) row.get("fcclave"));
            entradasinventario_detalle.setFcdescripcion((String) row.get("fcdescripcion"));
            entradasinventario_detalle.setFicosto((Double) row.get("ficosto"));
            entradasinventario_detalle.setFiimporte((Double) row.get("fiimporte"));
            lista.add(entradasinventario_detalle);
        }

        return lista;


    }


    public  void crearEntrada_detalle(Integer fientrada, Integer numpartida, Integer fiarticulo, Integer ficantidad, String fcclave, String fcdescripcion, Double ficosto, Double fiimporte){

        jdbcTemplate.update("INSERT INTO entradasinventario_detalle (fientradainventario, FINUM, FIARTICULO, FICANTIDAD, FCCLAVE , FCDESCRIPCION, ficosto , FIIMPORTE)VALUES(?,?,?,?,?,?,?,?)", fientrada,numpartida,fiarticulo,ficantidad, fcclave, fcdescripcion, ficosto, fiimporte);

    }


}
