package sistema.services;

import sistema.entity.Usuario;
import org.springframework.data.domain.Page;

public interface UsuarioService {

   String actualizarContrasena(String fiusuario, String fcpassword, String fcpassword1, String fcpassword2);
   Page<Usuario> Paginado(int pag, int size);
   Page<Usuario> Paginado(int pag, int size, String texto);

}
