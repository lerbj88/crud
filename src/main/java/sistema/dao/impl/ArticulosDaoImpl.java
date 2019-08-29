package sistema.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sistema.dao.ArticulosDao;
import sistema.entity.Articulos;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class ArticulosDaoImpl extends  JdbcDaoImpl implements ArticulosDao {

    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;


    public ArticulosDaoImpl(DataSource dataSource) {
        this.setDataSource(dataSource);
        this.jdbcTemplate = new JdbcTemplate(dataSource);
}

    public List<Articulos> getArticulos(String text){



        List<Articulos> lista = new ArrayList<Articulos>();
        String texto = "'%"+text+"%'";
        String sql="";
        String sql1 = "SELECT  fiid, fcclave, fcdescripcion, fccategoria, fcmarca, ficosto, fiprecio, fiexistencia, fitipo FROM articulos where fcclave like "+texto+" or fcdescripcion like "+texto+" or fccategoria like "+texto;
        String sql2 = "SELECT  fiid, fcclave, fcdescripcion, fccategoria, fcmarca, ficosto, fiprecio, fiexistencia, fitipo FROM articulos  ";

        sql =(text==null) ? sql2 : sql1;

        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        for (Map row : rows) {
            Articulos articulos = new Articulos();
            articulos.setFiid((Integer)row.get("fiid"));
            articulos.setFcclave((String)row.get("fcclave"));
            articulos.setFcdescripcion((String)row.get("fcdescripcion"));
            articulos.setFccategoria((String)row.get("fccategoria"));
            articulos.setFcmarca((String)row.get("fcmarca"));
            articulos.setFicosto((Double)row.get("ficosto"));
            articulos.setFiprecio((Double)row.get("fiprecio"));
            articulos.setFiexistencia((Integer)row.get("fiexistencia"));
            articulos.setFitipo((Integer)row.get("fitipo"));
            lista.add(articulos);
        }

    return lista;

    }

    public List<Articulos> getArticulosEntradas(){



        List<Articulos> lista = new ArrayList<Articulos>();

        String sql = "SELECT  fiid, fcclave, fcdescripcion, fccategoria, fcmarca, ficosto, fiprecio, fiexistencia, fitipo FROM articulos where fitipo=2 and fnstatus=1" ;

        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        for (Map row : rows) {
            Articulos articulos = new Articulos();
            articulos.setFiid((Integer)row.get("fiid"));
            articulos.setFcclave((String)row.get("fcclave"));
            articulos.setFcdescripcion((String)row.get("fcdescripcion"));
            articulos.setFccategoria((String)row.get("fccategoria"));
            articulos.setFcmarca((String)row.get("fcmarca"));
            articulos.setFicosto((Double)row.get("ficosto"));
            articulos.setFiprecio((Double)row.get("fiprecio"));
            articulos.setFiexistencia((Integer)row.get("fiexistencia"));
            articulos.setFitipo((Integer)row.get("fitipo"));
            lista.add(articulos);
        }

        return lista;

    }

    public void crearArticulo(String fcclave, String fcdescripcion, String fccategoria, String fcmarca, String fccodigobarras, Double ficosto, Double fiprecio, Integer fitipo  ){

        Integer fiexistencia=0;
        Integer fnstatus=1;
        Date date = new Date();
        java.sql.Date fdfechaalta = new java.sql.Date(date.getTime());

        jdbcTemplate.update("INSERT INTO articulos (FCCLAVE, fcdescripcion, fccategoria, fcmarca, fccodigobarras , ficosto, fiprecio, fiexistencia,fitipo, fdfechaalta, fnstatus)VALUES(?,?,?,?,?,?,?,?,?,?,?)",fcclave,fcdescripcion,fccategoria,fcmarca, fccodigobarras, ficosto, fiprecio, fiexistencia, fitipo, fdfechaalta,fnstatus);


    }



    public Articulos  obtenerArticulo(Integer fiid){

        String sql = "SELECT fiid, fcclave, fcdescripcion, fccategoria, fcmarca, fccodigobarras,ficosto,fiprecio,fiexistencia,fitipo,fnstatus  FROM articulos WHERE fiid=?";

        Articulos  articulo = (Articulos) getJdbcTemplate().queryForObject(
                sql, new Object[] { fiid },
                new BeanPropertyRowMapper(Articulos.class));

        return articulo;
    }


    public void actualizarArticulo(Integer fiid,String fcclave, String fcdescripcion, String fccategoria, String fcmarca, String fccodigobarras, Double ficosto, Double fiprecio,  Boolean fnstatus){

        jdbcTemplate.update("UPDATE articulos set fcclave=?, fcdescripcion=?, fccategoria=?, fcmarca=?, fccodigobarras=?, ficosto=?, fiprecio=?,fnstatus=? WHERE FIID=?", fcclave,fcdescripcion,fccategoria,fcmarca,fccodigobarras,ficosto,fiprecio,fnstatus,fiid);

    }

    public void eliminarArticulo(Integer fiid){

        jdbcTemplate.update("DELETE  FROM articulos  WHERE FIID=?",fiid);

    }


    }
