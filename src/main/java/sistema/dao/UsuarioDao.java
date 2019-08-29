package sistema.dao;


import sistema.entity.Usuario;

import java.util.List;

public interface UsuarioDao  {
     List <Usuario> findAll();
    void crearUsuario(String fiusuario, String fcnombre, String fccorreo, String fctelefono, Integer idrol);
    void editarUsuario(String fiusuario, String fcnombre, String fccorreo, String fctelefono, Integer idrol);
    public Usuario findByUsuario(String usuario);
     Usuario obtenerUsuario(String fiusuario);
    Usuario perfilUsuario(String fiusuario);
    void eliminarUsuario(String fiusuario);
    void validarPassword();
     String obtenerContrasena(String fiusuario);
     String actualizarContrasena(String fiusuario, String fcpassword);
     String reiniciarContrasena(String fiusuario);
     List<Usuario> consultarUsuarios(String text);

}
