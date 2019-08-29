package sistema.dao;

import sistema.entity.Articulos;

import java.util.List;

public interface ArticulosDao {

    void crearArticulo(String fcclave, String fcdescripcion, String fccategoria, String fcmarca, String fccodigobarras, Double ficosto, Double fiprecio, Integer fitipo  );
    List<Articulos> getArticulos(String text);
    List<Articulos> getArticulosEntradas();
    Articulos obtenerArticulo(Integer fiid);
    void actualizarArticulo(Integer fiid, String fcclave, String fcdescripcion, String fccategoria, String fcmarca, String fccodigobarras, Double ficosto, Double fiprecio,  Boolean fnstatus );
    void eliminarArticulo(Integer fiid);

}
