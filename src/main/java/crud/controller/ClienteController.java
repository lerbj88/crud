package crud.controller;

import crud.dao.ClientesDao;
import crud.entity.Clientes;
import crud.services.ClientesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping("/cliente")
public class ClienteController {



    @Autowired
    private ClientesDao clientesDao;

    @Autowired
    private ClientesServices clientesServices;


    @GetMapping("/home")
    public String getHome(
            ModelMap modelMap){
        return "home";
    }


    @RequestMapping(value = { "clientes/list" }, method = RequestMethod.GET)
    public String getClientes(@RequestParam(name = "text", required = false) String text,
                                @PageableDefault(size = 5) Pageable pageable,
                                ModelMap modelMap){

            Page<Clientes> lista = clientesServices.getPages(pageable, text);
            PageWrapper<Clientes> page = new PageWrapper<Clientes>(lista, "list");
            modelMap.addAttribute("lista", page.getContent());
            modelMap.addAttribute("page", page);


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