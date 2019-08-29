package sistema.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sistema.dao.Factura_detalleDao;
import sistema.entity.Facturas_detalle;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class Factura_detalleDaoImpl extends JdbcDaoImpl implements Factura_detalleDao {


    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public Factura_detalleDaoImpl(DataSource dataSource) {
        this.setDataSource(dataSource);
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Facturas_detalle> getFactura_detalle(Integer no) {


        List<Facturas_detalle> lista = new ArrayList<Facturas_detalle>();


        String sql = "SELECT fifactura, finum,  fiarticulo, ficantidad, fcclave, fcdescripcion, fiprecio, fiimporte  FROM facturas_detalle  where fifactura = " + no;

        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        for (Map row : rows) {
            Facturas_detalle Facturas_detalle = new Facturas_detalle();
            Facturas_detalle.setFifactura((Integer) row.get("fifactura"));
            Facturas_detalle.setFinum((Integer) row.get("finum"));
            Facturas_detalle.setFiarticulo((Integer) row.get("fiarticulo"));
            Facturas_detalle.setFicantidad((Integer) row.get("ficantidad"));
            Facturas_detalle.setFcclave((String) row.get("fcclave"));
            Facturas_detalle.setFcdescripcion((String) row.get("fcdescripcion"));
            Facturas_detalle.setFiprecio((Double) row.get("fiprecio"));
            Facturas_detalle.setFiimporte((Double) row.get("fiimporte"));
            lista.add(Facturas_detalle);
        }


        logger.info(lista);
        return lista;


    }

    public void crearFactura_detalle(Integer fifactura, Integer numpartida, Integer fiarticulo, Integer ficantidad, String fcclave, String fcdescripcion, Double fiprecio, Double fiimporte) {

        jdbcTemplate.update("INSERT INTO FACTURAS_DETALLE (FIFACTURA, FINUM, FIARTICULO, FICANTIDAD, FCCLAVE , FCDESCRIPCION, FIPRECIO , FIIMPORTE)VALUES(?,?,?,?,?,?,?,?)", fifactura,numpartida,fiarticulo,ficantidad, fcclave, fcdescripcion, fiprecio, fiimporte);


    }

}
