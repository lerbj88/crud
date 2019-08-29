package sistema.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sistema.dao.FacturasDao;
import sistema.dto.FacturasDto;
import sistema.dto.Facturas_DetalleDto;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Repository
@Transactional
public class FacturasDaoImpl extends JdbcDaoImpl implements FacturasDao {


    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public FacturasDaoImpl(DataSource dataSource) {
        this.setDataSource(dataSource);
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }



    public List<FacturasDto>getFacturas(Integer fiid) {

        List<FacturasDto> lista = new ArrayList<FacturasDto>();

        String sql = "";
        String sql1 = "SELECT  a.fiid, b.fccliente, d.fcplacas,  a.fitotal, a.fdfecha, a.fistatus FROM facturas a inner join  clientes b on a.ficliente= b.fiid  inner join vehiculos d on a.fiauto=d.fiid where a.fiid = " + fiid ;
        String sql2 = "SELECT  a.fiid, b.fccliente, d.fcplacas,  a.fitotal, a.fdfecha, a.fistatus FROM facturas a inner join  clientes b on a.ficliente= b.fiid  inner join vehiculos d on a.fiauto=d.fiid order by a.fiid desc";

        sql = (fiid == null) ? sql2 : sql1;

        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        for (Map row : rows) {
            FacturasDto facturasDto = new FacturasDto();
            facturasDto.setFiid((Integer) row.get("fiid"));
            facturasDto.setFccliente((String) row.get("fccliente"));
            facturasDto.setFcplacas((String) row.get("fcplacas"));
           // facturasDto.setFcempleado((String) row.get("fcnombre"));
            facturasDto.setFitotal((Double) row.get("fitotal"));
            facturasDto.setFdfecha((Timestamp) row.get("fdfecha"));
            facturasDto.setFistatus((Integer) row.get("fistatus"));
            lista.add(facturasDto);
        }


        logger.info(lista);
        return lista;

    }


    public Facturas_DetalleDto  obtenerFactura(Integer fiid){

        String sql = "SELECT  a.fiid, b.fccliente, b.fcemail as fccorreo, b.fctelefono, d.fcplacas, d.fccolor, d.fcmarca, 1 as fcempleado, a.fitotal, a.fdfecha, a.fistatus FROM facturas a inner join  clientes b on a.ficliente= b.fiid  inner join vehiculos d  on a.fiauto=d.fiid  where a.fiid = ?" ;

        Facturas_DetalleDto facturas_DetalleDto = (Facturas_DetalleDto) getJdbcTemplate().queryForObject(
                sql, new Object[] { fiid },
                new BeanPropertyRowMapper(Facturas_DetalleDto.class));
        return facturas_DetalleDto;
    }

   public void crearFactura(Integer ficliente, Integer fiauto, Integer fiempleado, Double fitotal){

       jdbcTemplate.update("INSERT INTO FACTURAS (FICLIENTE,  FIAUTO, FIEMPLEADO, FITOTAL, FISTATUS)VALUES(?,?,?,?,1)",ficliente,fiauto,fiempleado,fitotal);
   }


   public Integer maxId (){


       String sql = "SELECT MAX(fiid) FROM facturas";

       String max = (String)getJdbcTemplate().queryForObject(
               sql, new Object[] {  }, String.class);

       Integer max2 =Integer.parseInt(max);

       logger.warn("valor de max2" +max2);
       return max2;

   }

   public void cancelarFactura (Integer fifactura){

       jdbcTemplate.update("UPDATE facturas SET fistatus=2  WHERE FIID=?",fifactura);

   }


    public List<FacturasDto>getFacturasxlavador(Integer filavador) {

        List<FacturasDto> lista = new ArrayList<FacturasDto>();

        String sql = "SELECT  a.fiid, b.fccliente, d.fcplacas, c.fcnombre, a.fitotal, a.fdfecha, a.fistatus FROM facturas a inner join  clientes b on a.ficliente= b.fiid inner join empleados c on a.fiempleado = c.fiid  inner join vehiculos d on a.fiauto=d.fiid where a.fiempleado = " + filavador ;


        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        for (Map row : rows) {
            FacturasDto facturasDto = new FacturasDto();
            facturasDto.setFiid((Integer) row.get("fiid"));
            facturasDto.setFccliente((String) row.get("fccliente"));
            facturasDto.setFcplacas((String) row.get("fcplacas"));
            facturasDto.setFcempleado((String) row.get("fcnombre"));
            facturasDto.setFitotal((Double) row.get("fitotal"));
            facturasDto.setFdfecha((Timestamp) row.get("fdfecha"));
            facturasDto.setFistatus((Integer) row.get("fistatus"));
            lista.add(facturasDto);
        }


        logger.info(lista);
        return lista;

    }


    public Double getTotalFacturas(){

        Double total = null;
        String sql = "SELECT SUM(FITOTAL) FROM FACTURAS where FISTATUS=1 AND FICORTECAJA=0";

        String max = (String)getJdbcTemplate().queryForObject(
                sql, new Object[] {  }, String.class);

        max = (max==null)? String.valueOf(0) :max;
        total =Double.valueOf(max);
        return total;
    }

    public void updCortecaja(){

        jdbcTemplate.update("update FACTURAS set ficortecaja=1 where FISTATUS=1 AND FICORTECAJA=0");

    }

    public void updCortenomina(Integer fiempleado){

        jdbcTemplate.update("update facturas  A INNER JOIN facturas_lavadores B ON A.FIID=B.fifactura  set a.ficortenomina=a.ficortenomina+1  WHERE a.FISTATUS=1 AND a.FICORTENOMINA<2 and B.filavador="+fiempleado);

    }

    public void crearFactura_lavadores(Integer fifactura, Integer filavador){

        jdbcTemplate.update("INSERT INTO FACTURAS_lavadores (fifactura,filavador)VALUES(?,?)",fifactura, filavador);


    }

    public List<Integer>getFactura_lavadores(Integer fifactura){



        String query= "select filavador from facturas_lavadores where fifactura ="+fifactura;

        List<Integer>data=jdbcTemplate.queryForList(query,Integer.class);

        logger.warn(data);

        return data;
    }

}

