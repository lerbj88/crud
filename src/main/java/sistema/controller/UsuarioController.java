package sistema.controller;


import sistema.dao.UsuarioDao;
import sistema.entity.Usuario;
import sistema.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Optional;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private UsuarioService usuarioService;


    @RequestMapping(value = { "usuarios/list" }, method = RequestMethod.GET)
    public String listarUsuarios(@PageableDefault(size = 5) Pageable pageable,
                                 @RequestParam(name = "fiusuario", required = false) String texto,
                                 @RequestParam(value = "pag") Optional<Integer> page1,
                                 @RequestParam("size") Optional<Integer> size,
                                 Model model) throws SQLException {
        if (texto != null) {
            model.addAttribute("key", texto);
            Integer currentPage = page1.orElse(0);
            int pageSize = size.orElse(10);

            Page<Usuario> lista = usuarioService.Paginado(currentPage , pageSize, texto);
            PageWrapper<Usuario> page = new PageWrapper<Usuario>(lista, "/usuarios/list");
            model.addAttribute("lista", page.getContent());
            model.addAttribute("page", page);

            return "usuarios/list";
        } else {
            Integer currentPage = page1.orElse(0);
            int pageSize = size.orElse(5);

            Page<Usuario> lista = usuarioService.Paginado(currentPage , pageSize);
            PageWrapper<Usuario> page = new PageWrapper<Usuario>(lista, "/usuarios/list");
            model.addAttribute("lista", page.getContent());
            model.addAttribute("page", page);


            return "usuarios/list";
        }
    }



    @RequestMapping(value = {"usuarios/form"}, method = RequestMethod.GET)
    public String form(@RequestParam(name = "fiusuario", required = false) String fiusuario, ModelMap model)throws SQLException {
            Usuario usuario = new Usuario();
            model.addAttribute("usuario", usuario);
            model.addAttribute("outMessage", "");
        return "usuarios/form";
    }


    @RequestMapping(value = {"usuarios/edit"}, method = RequestMethod.GET)
    public String editarUsuario(@RequestParam(name = "fiusuario", required = false) String fiusuario, ModelMap model)throws SQLException {
            Usuario usuario = (Usuario) usuarioDao.obtenerUsuario(fiusuario);
            model.addAttribute("usuario", usuario);
        return "usuarios/edit";
    }


    @PostMapping(value = "/usuarios/form")
    public String crearUsusario(@RequestParam("fiusuario") String fiusuario,
                         @RequestParam("fiidrole") Integer idrol,
                         @RequestParam("fcnombre") String fcnombre,
                         @RequestParam("fccorreo") String fccorreo,
                         @RequestParam("fctelefono") String fctelefono,
                          Model model) {
        usuarioDao.crearUsuario(fiusuario, fcnombre, fccorreo, fctelefono, idrol);
        return "redirect:/usuarios/list";
    }



    @PostMapping(value = "/usuarios/edit")
    public String editarUsusario(@RequestParam("fiusuario") String fiusuario,

                                 @RequestParam("fcnombre") String fcnombre,
                                 @RequestParam("fccorreo") String fccorreo,
                                 @RequestParam("fctelefono") String fctelefono,
                                @RequestParam("fiidrole") Integer fcidrol,
                                Model model) {
        usuarioDao.editarUsuario(fiusuario, fcnombre, fccorreo, fctelefono, fcidrol);
        return "redirect:/usuarios/list";
    }

    @RequestMapping("usuarios/eliminar")
    public String eliminarUsuario (@RequestParam("fiusuario") String fiusuario){
        System.out.println("entro controler");
        usuarioDao.eliminarUsuario(fiusuario);
        return "redirect:list";
    }

    @RequestMapping("/usuarios/resetpwd")
    public String reiniciarContrasena (@RequestParam("fiusuario") String fiusuario){
        usuarioDao.reiniciarContrasena(fiusuario);
        return "redirect:list";
    }

    @RequestMapping(value = {"usuarios/perfil"}, method = RequestMethod.GET)
    public String perfilrUsuario( ModelMap model)throws SQLException {
        final String user = SecurityContextHolder.getContext().getAuthentication().getName();
        //Integer  fiusuario = Integer.parseInt(user);
        Usuario usuario = (Usuario) usuarioDao.perfilUsuario(user);
        model.addAttribute("usuario", usuario);
        return "usuarios/perfil";
    }


    @RequestMapping(value = {"usuarios/editperfil"}, method = RequestMethod.GET)
    public String editperfilrUsuario(ModelMap model)throws SQLException {
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        model.addAttribute("mensaje", "");
        return "usuarios/editperfil";
    }


    @PostMapping(value = "usuarios/editperfil")
    public String actualizarContrasena  (@ModelAttribute(value = "usuario") Usuario usuario,
                                 @RequestParam("fiusuario") String fiusuario,
                                 @RequestParam("fcpassword") String fcpassword,
                                 @RequestParam("fcpassword1") String fcpassword1,
                                 @RequestParam("fcpassword2") String fcpassword2,
                                 Model model) {
        String mensaje = usuarioService.actualizarContrasena(fiusuario, fcpassword, fcpassword1, fcpassword2);
        model.addAttribute("usuario",usuario);
        model.addAttribute("mensaje",mensaje);


        return "usuarios/editperfil";
    }


}
