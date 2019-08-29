package sistema.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sistema.dao.NominasDao;
import sistema.dto.NominasDto;
import sistema.dto.Nominas_detalleDto;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Repository
@Transactional
public class NominasDaoImpl extends JdbcDaoImpl implements NominasDao {


    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public NominasDaoImpl(DataSource dataSource) {
        this.setDataSource(dataSource);
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }



  public List<NominasDto> getNominas( Integer fiempleado){
        List <NominasDto> lista = new ArrayList<NominasDto>();

      String sql = "SELECT  a.fiid, b.fcnombre, a.fitotalbruto, a.fidescuento, a.fitotalneto, a.fdfecha from nominas a inner join empleados b on a.fiempleado = b.fiid where a.fiempleado = " + fiempleado ;

      List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
      for (Map row : rows) {
          NominasDto nominasDto = new NominasDto();
          nominasDto.setFiid((Integer) row.get("fiid"));
          nominasDto.setFcempleado((String) row.get("fcnombre"));
          nominasDto.setFitotalbruto((Double) row.get("fitotalbruto"));
          nominasDto.setFidescuento((Double) row.get("fidescuento"));
          nominasDto.setFitotalneto((Double) row.get("fitotalneto"));
          nominasDto.setFdfecha((Timestamp) row.get("fdfecha"));
          lista.add(nominasDto);
      }

      logger.info(lista);


        return lista;
    }


    public NominasDto getNomina (Integer fiid){


        String sql = "a.fiid, b.fcnombre, a.fitotalbruto, a.fidescuento, a.fitotalneto, a.fdfecha from nominas a inner join empleados b on a.fiempleado = b.fiid where a.fiid = ?" ;

        NominasDto facturas_DetalleDto = (NominasDto) getJdbcTemplate().queryForObject(
                sql, new Object[] { fiid },
                new BeanPropertyRowMapper(NominasDto.class));
        return facturas_DetalleDto;

    }



    public Nominas_detalleDto getNomina_detalle (Integer fiid){

        String sql = "SELECT A.FIID, B.FCNOMBRE as fcempleado, B.FCDIRECCION, B.FCTELEFONO as telefono, B.FDFECHAINGRESO as fechaingreso, CASE when b.FiPUESTO=1 then 'lavador' when b.fipuesto=2 then 'administrativo' end as fcpuesto, a.fitotalbruto, a.fidescuento, a.fitotalneto, a.fdfecha from nominas a inner join empleados b on a.fiempleado=b.fiid  where a.fiid = ?" ;

        Nominas_detalleDto nominas_DetalleDto = (Nominas_detalleDto) getJdbcTemplate().queryForObject(
                sql, new Object[] { fiid },
                new BeanPropertyRowMapper(Nominas_detalleDto.class));

        logger.warn(nominas_DetalleDto);
        return nominas_DetalleDto;
    }


    public void crearNomina(Integer fiempleado, Double fitotalbruto, Double fidescuento, Double fitotalneto){

        jdbcTemplate.update("INSERT INTO NOMINAS (FIEMPLEADO,  FITOTALBRUTO, FIDESCUENTO, FITOTALNETO)VALUES(?,?,?,?)",fiempleado,fitotalbruto,fidescuento,fitotalneto);
    }



    public Integer maxId (){


        String sql = "SELECT MAX(fiid) FROM nominas";

        String max = (String)getJdbcTemplate().queryForObject(
                sql, new Object[] {  }, String.class);

        Integer max2 =Integer.parseInt(max);

        logger.warn("valor de max2" +max2);
        return max2;

    }

    public Double gettotalNominas(){

        String sql = "SELECT sum(fitotalneto) FROM nominas where ficortecaja=0";

        String max = (String)getJdbcTemplate().queryForObject(
                sql, new Object[] {  }, String.class);

        max = (max==null)? String.valueOf(0) :max;
        Double tot =Double.parseDouble(max);

        return tot;
    }


    public void updCortecaja(){

        jdbcTemplate.update("update nominas set ficortecaja=1 where FICORTECAJA=0");
    }



    }
