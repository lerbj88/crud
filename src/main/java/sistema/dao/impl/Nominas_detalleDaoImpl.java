package sistema.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sistema.dao.Nominas_detalleDao;
import sistema.dto.Nomina_detalleEmpleadoDto;
import sistema.entity.nominas_detalle;

import javax.sql.DataSource;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Repository
@Transactional
public class Nominas_detalleDaoImpl extends JdbcDaoImpl implements Nominas_detalleDao {


    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public Nominas_detalleDaoImpl(DataSource dataSource) {
        this.setDataSource(dataSource);
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public List<nominas_detalle> getDetalles(Integer fiid) {

        List<nominas_detalle> lista = new ArrayList<nominas_detalle>();

        String sql = "SELECT  finomina, finum, fiarticulo, fcclave, fcdescripcion, fiprecio, fitotal from nominas_detalle where finomina=" + fiid;

        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        for (Map row : rows) {
            nominas_detalle nominas_detall = new nominas_detalle();
            nominas_detall.setFinomina((Integer) row.get("finomina"));
            nominas_detall.setFinum((Integer) row.get("finum"));
            nominas_detall.setFiarticulo((Integer) row.get("fiarticulo"));
            nominas_detall.setFcclave((String) row.get("fcclave"));
            nominas_detall.setFcdescripcion((String) row.get("fcdescripcion"));
            nominas_detall.setFiprecio((Double) row.get("fiprecio"));
            nominas_detall.setFitotal((Double) row.get("fitotal"));
            lista.add(nominas_detall);
        }


        return lista;
    }

    public List<Nomina_detalleEmpleadoDto> getDetalle_nomina(Integer fiid) {

        List<Nomina_detalleEmpleadoDto> lista = new ArrayList<Nomina_detalleEmpleadoDto>();

 String sql ="with  ventas as (\n" +
         "SELECT c.filavador,A.FIID,B.fiarticulo,B.fcclave,B.fcdescripcion, B.fiimporte \n" +
         "FROM FACTURAS A LEFT JOIN facturas_detalle B \n" +
         "ON A.FIID= B.fifactura LEFT JOIN  facturas_lavadores C ON A.FIID=C.fifactura\n" +
         "WHERE  C.FILAVADOR = "+fiid+" AND A.ficortenomina<1 AND A.fistatus=1), VENTASEMPLEADO AS (\n" +
         "SELECT B.*,C.fitipo  FROM ARTICULOS C RIGHT JOIN VENTAS B ON C.fiid = B.fiarticulo WHERE C.fitipo IN( 1,3))\n" +
         "SELECT ROW_NUMBER() OVER (ORDER BY d.fiid)finum,D.fiarticulo,d.fcclave,d.fcdescripcion, d.fiimporte, \n" +
         "CASE \n" +
         "WHEN D.FITIPO ='1' THEN\n" +
         "ROUND((D.FIIMPORTE*E.fiporcentaje/100),2)   \n" +
         "WHEN D.FITIPO ='3' THEN\n" +
         "ROUND(((D.FIIMPORTE*E.fiporcentaje/100)/2),2) END  as fipercepcion\n" +
         "FROM VENTASEMPLEADO D LEFT JOIN EMPLEADOS E ON D.FIlavador= E.fiid ";

        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        for (Map row : rows) {
            Nomina_detalleEmpleadoDto nomina_detalleEmpleadoDto = new Nomina_detalleEmpleadoDto();
            nomina_detalleEmpleadoDto.setFinum((BigInteger) row.get("finum"));
            nomina_detalleEmpleadoDto.setFiarticulo((Integer) row.get("fiarticulo"));
            nomina_detalleEmpleadoDto.setFcclave((String) row.get("fcclave"));
            nomina_detalleEmpleadoDto.setFcdescripcion((String) row.get("fcdescripcion"));
            nomina_detalleEmpleadoDto.setFiimporte((Double) row.get("fiimporte"));
            nomina_detalleEmpleadoDto.setFipercepcion((Double) row.get("fipercepcion"));
            lista.add(nomina_detalleEmpleadoDto);
        }

        return lista;

    }


    public void crearNomina_detalle(Integer finomina, Integer finum, Integer fiarticulo, String fcclave, String fcdescripcion, Double fiprecio, Double fitotal){

        jdbcTemplate.update("INSERT INTO NOMINAS_DETALLE (FINOMINA,  FINUM, FIARTICULO, FCCLAVE, FCDESCRIPCION, FIPRECIO, FITOTAL)VALUES(?,?,?,?,?,?,?)",finomina,finum,fiarticulo,fcclave,fcdescripcion,fiprecio,fitotal);
    }

}
