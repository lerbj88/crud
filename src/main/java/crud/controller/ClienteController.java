package crud.controller;

import crud.dao.ClientesDao;
import crud.entity.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/cliente")
public class ClienteController {



    @Autowired
    private ClientesDao clientesDao;


    @GetMapping("/home")
    public String getHome(
            ModelMap modelMap){
        return "home";
    }


    @RequestMapping(value = { "clientes/list" }, method = RequestMethod.GET)
    public String getClientes(@RequestParam(name = "text", required = false) String text,
                                //@PageableDefault(size = 5) Pageable pageable,
                                ModelMap modelMap){
        if (text!=null){
            List<Clientes> lista = clientesDao.getClientes(text);
            modelMap.addAttribute("lista", lista);
        }else {
            List<Clientes> lista = clientesDao.getClientes();
            modelMap.addAttribute("lista", lista);
        }
            return "clientes/list";

    }

    @GetMapping("clientes/form")
    public String form(@RequestParam(name = "id", required = false) Integer fiid,
            @ModelAttribute(value = "clientes") Clientes clientes,
            ModelMap model){
        if (fiid!=null) {
            Clientes cliente = clientesDao.obtenerCliente(fiid);
            model.addAttribute("clientes", cliente);
            return "clientes/form";
        }
        else {
            Clientes cliente = new Clientes();
            model.addAttribute("clientes", cliente);
            return "clientes/form";
        }

    }


    @PostMapping("clientes/form")
    public String Agregar(
            @ModelAttribute(value = "clientes") Clientes clientes,
                          ModelMap model) {

        if(clientes.getFiid()!=null){
        clientesDao.actualizarCliente(clientes.getFiid(),clientes.getFccliente(), clientes.getFctienda(), clientes.getFcemail(), clientes.getFctelefono());

        }else {

            clientesDao.crearCliente(clientes.getFccliente(), clientes.getFctienda(), clientes.getFcemail(), clientes.getFctelefono());
        }
        return "redirect:list";
    }

    @RequestMapping("clientes/eliminar")
    public String Eliminar(@RequestParam(name = "id", required = false) Integer fiid) {
            clientesDao.eliminarCliente(fiid);
            return "redirect:list";
    }


}