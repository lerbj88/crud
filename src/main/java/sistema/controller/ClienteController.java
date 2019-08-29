package sistema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import sistema.dao.ClientesDao;
import sistema.dao.VehiculosDao;
import sistema.entity.Clientes;
import sistema.entity.Vehiculos;
import sistema.services.ClientesServices;

import java.util.List;
import java.util.logging.Logger;

@Controller
//@RequestMapping("/cliente")
public class ClienteController {


    @Autowired
    private ClientesDao clientesDao;

    @Autowired
    private ClientesServices clientesServices;

    @Autowired
    private VehiculosDao vehiculosDao;

    private final static Logger logger = Logger.getLogger("sistema.controller.ClienteController");


    @GetMapping("/home")
    public String getHome(
            ModelMap modelMap) {
        return "/home";
    }


    @RequestMapping(value = {"clientes/list"}, method = RequestMethod.GET)
    public String getClientes(@RequestParam(name = "text", required = false) String text,
                              @PageableDefault(size = 5) Pageable pageable,
                              ModelMap modelMap) {

        Page<Clientes> lista = clientesServices.getPages(pageable, text);
        PageWrapper<Clientes> page = new PageWrapper<Clientes>(lista, "list");
        modelMap.addAttribute("lista", page.getContent());
        modelMap.addAttribute("page", page);
        return "clientes/list";

    }


    @GetMapping("clientes/form")
    public String form(@RequestParam(name = "id", required = false) Integer fiid,
                       @ModelAttribute(value = "clientes") Clientes clientes,
                       ModelMap model) {
        if (fiid != null) {
            Clientes cliente = clientesDao.obtenerCliente(fiid);
            model.addAttribute("clientes", cliente);
            return "clientes/form";
        } else {
            Clientes cliente = new Clientes();
            model.addAttribute("clientes", cliente);
            return "clientes/form";
        }

    }


    @PostMapping("clientes/form")
    public String Agregar(
            @ModelAttribute(value = "clientes") Clientes clientes,
            ModelMap model) {

        if (clientes.getFiid() != null) {
            clientesDao.actualizarCliente(clientes.getFiid(), clientes.getFccliente(), clientes.getFcemail(), clientes.getFctelefono());

        } else {

            clientesDao.crearCliente(clientes.getFccliente(), clientes.getFcemail(), clientes.getFctelefono());
        }
        return "redirect:list";
    }

    @RequestMapping("clientes/eliminar")
    public String Eliminar(@RequestParam(name = "id", required = false) Integer fiid) {
        clientesDao.eliminarCliente(fiid);
        return "redirect:list";
    }


    @RequestMapping(value = {"clientes/listautos"}, method = RequestMethod.GET)
    public String getClientes(@RequestParam(name = "id", required = false) Integer ficliente,
                              ModelMap modelMap) {

        List<Vehiculos> lista = vehiculosDao.obenerVehiculos(ficliente);
        Clientes cliente = clientesDao.obtenerCliente(ficliente);

        modelMap.addAttribute("lista", lista);
        modelMap.addAttribute("fccliente", cliente.getFccliente());
        modelMap.addAttribute("ficliente", ficliente);
        return "clientes/listautos";

    }


    @GetMapping("clientes/formauto")
    public String formauto(
            @RequestParam(name = "id", required = false) Integer fiid,
            ModelMap model) {

        Vehiculos vehiculos = new Vehiculos();
        model.addAttribute("vehiculo", vehiculos);
        model.addAttribute("ficliente", fiid);
        return "clientes/formauto";
    }


    @PostMapping("clientes/formauto")
    public String AgregarAuto(
            @ModelAttribute(value = "vehiculo") Vehiculos vehiculo,
            ModelMap model) {

        vehiculosDao.crearVehiculo(vehiculo.getFiid(), vehiculo.getFcplacas(), vehiculo.getFccolor(), vehiculo.getFcmarca());
        return "redirect:listautos?id=" + vehiculo.getFiid();
    }

    @RequestMapping("clientes/eliminarauto")
    public String Eliminarauto(@RequestParam(name = "id") Integer fiid,
                               @RequestParam(name = "ficliente") Integer ficliente
                               ) {
        vehiculosDao.eliminarAuto(fiid);
        return "redirect:listautos?id=" + ficliente;
    }


}