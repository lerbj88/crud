package sistema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sistema.dao.*;
import sistema.dto.ArticulosDto;
import sistema.dto.ClienteDto;
import sistema.entity.Articulos;
import sistema.entity.Empleado;
import sistema.entity.Vehiculos;
import sistema.services.FacturasService;
import sistema.services.PuntoventaService;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Controller
@Scope("session")
public class PuntoventaController {

    /*
    @GetMapping("/puntoventa/puntoventa")
    public String getPuntoventa(
            ModelMap modelMap){
        return "/puntoventa/puntoventa";
    }
*/


    @Autowired
    ClientesDao clientesDao;

    @Autowired
    VehiculosDao vehiculosDao;

    @Autowired
    ArticulosDao articulosDao;

    @Autowired
    EmpleadosDao empleadosDao;

    @Autowired
    PuntoventaService puntoventaService;

    @Autowired
    FacturasService facturasService;

    @Autowired
    FacturasDao facturasDao;


    private List<ArticulosDto> artdto;


    private final static Logger logger = Logger.getLogger("sistema.services.Impl.PuntoventaServiceImpl");


    @GetMapping("puntoventa/puntoventa")
    public String form(
            @RequestParam(name = "placas", required = false) String fcplacas,
            @RequestParam(name = "fiarticulo", required = false) Integer fiarticulo,
            ModelMap model) {

        String text = null;

        List<Articulos> listaarticulos = articulosDao.getArticulos(text);
        List<Empleado> listarempleados = empleadosDao.listarEmpleados(text);
        //List<ArticulosDto> artdto = new ArrayList<ArticulosDto>();


        if (fcplacas != null) {

            Integer existe = vehiculosDao.existeAuto(fcplacas);



            if (existe ==1) {
                ClienteDto clienteDto = puntoventaService.obtenerCliente(fcplacas);

                model.addAttribute("clienteDto", clienteDto);
                model.addAttribute("clienteDto2", clienteDto);
                model.addAttribute("mensaje", "");

            } else {
                ClienteDto clienteDto = new ClienteDto();
                model.addAttribute("clienteDto", clienteDto);
                model.addAttribute("clienteDto2", clienteDto);
                model.addAttribute("mensaje", "Las placas: " + fcplacas + " no existen en sistema");

            }

            model.addAttribute("listaarticulos", listaarticulos);
            model.addAttribute("listaempleados", listarempleados);
            model.addAttribute("listaartdto", artdto);

            return "puntoventa/puntoventa";
        } else {
            ClienteDto clienteDto = new ClienteDto();
            Vehiculos vehiculo = new Vehiculos();
            artdto = null;
            model.addAttribute("clienteDto", clienteDto);
            model.addAttribute("clienteDto2", clienteDto);
            model.addAttribute("mensaje", "");

            model.addAttribute("listaarticulos", listaarticulos);
            model.addAttribute("listaempleados", listarempleados);
            model.addAttribute("listaartdto", artdto);


            return "puntoventa/puntoventa";
        }

    }


    @PostMapping("puntoventa/puntoventa")
    public String Agregar(
            @RequestParam(name = "fiarticulo", required = false) Integer fiid,
            @RequestParam(name = "fcplacas", required = false) String fcplacas,
            @RequestParam(name = "ficantidad", required = false) Integer ficantidad,
            @RequestParam(name = "action", required = false) Integer action,
            ModelMap model) {

        String text = null;
        List<Articulos> listaarticulos = articulosDao.getArticulos(text);
        Articulos articulo = null;

        logger.warning("valor de fcplacas" + fcplacas);

        fcplacas = (fcplacas == null || fcplacas.isEmpty()) ? "GENERICO" : fcplacas;

        ClienteDto clienteDto = puntoventaService.obtenerCliente(fcplacas);


        switch (action) {

            case 5:
                Articulos articul = articulosDao.obtenerArticulo(fiid);
                articulo = articul;
                break;

            case 4:
                articul = articulosDao.obtenerArticulo(9);
                articulo = articul;
                break;

            case 3:
                articul = articulosDao.obtenerArticulo(8);
                articulo = articul;
                break;


            case 2:
                articul = articulosDao.obtenerArticulo(2);
                articulo = articul;
                break;

            case 1:
                articul = articulosDao.obtenerArticulo(1);
                articulo = articul;
                break;


        }


        List<Empleado> listarempleados = empleadosDao.listarEmpleados(text);

        if (artdto == null) {
            artdto = new ArrayList<ArticulosDto>();
        }


        int existe = validarArticuloLista(articulo.getFiid());

        logger.warning("el valor de existe es " + existe);


        if (existe == 0) {

            ArticulosDto articulosDto = new ArticulosDto(articulo.getFiid(),  artdto.size()+1, ficantidad, articulo.getFcclave(), articulo.getFcdescripcion(), articulo.getFiprecio(), (articulo.getFiprecio()*ficantidad ) );
            artdto.add(articulosDto);
        } else {

            int posicionlista = obtenerPosicionLista(articulo.getFiid());
            artdto.get(posicionlista).setCantidad(artdto.get(posicionlista).getCantidad() + 1);
            artdto.get(posicionlista).setFiimporte(artdto.get(posicionlista).getCantidad() * artdto.get(posicionlista).getFiprecio());

        }


        //   ClienteDto clienteDto = new ClienteDto();

        Double totalfactura = artdto.stream().mapToDouble(o -> o.getFiimporte()).sum();


        //model.addAttribute("clienteDto", clienteDto);
        // model.addAttribute("clienteDto2", clienteDto);

        model.addAttribute("listaarticulos", listaarticulos);
        model.addAttribute("listaempleados", listarempleados);
        model.addAttribute("listaartdto", artdto);
        model.addAttribute("totalfactura", totalfactura);
        model.addAttribute("clienteDto", clienteDto);
        model.addAttribute("clienteDto2", clienteDto);
        model.addAttribute("mensaje", "");


        return "puntoventa/puntoventa";

    }

    @PostMapping("puntoventa/crearfactura")
    public String crearFActura(
            @RequestParam(name = "ficliente", required = false) Integer ficliente,
            @RequestParam(name = "fiauto", required = false) Integer fiauto,
            @RequestParam(name = "fitotalfactura", required = false) Double fitotalfactura,
            @RequestParam(name = "filavador", required = false) Integer[] filavador,
            @RequestParam(value = "listacantidad") Integer[] filistacantidades,
            @RequestParam(value = "listapartidas") Integer[] listapartidas,
            ModelMap model) {

        facturasService.crearFactura(ficliente, fiauto, fitotalfactura, filavador, filistacantidades, listapartidas);
        Integer fifactura = facturasDao.maxId();

        return "redirect:/facturas/listDetalle?fiid=" + fifactura;

    }

    private Integer validarArticuloLista(Integer id) {

        Integer num = 0;

        for (int i = 0; i < artdto.size(); i++) {
            if (artdto.get(i).getId().equals(id)) {
                num = 1;
            }
        }
        return num;
    }

    private Integer obtenerPosicionLista(Integer id) {

        Integer reg = null;

        for (int i = 0; i < artdto.size(); i++) {
            if (artdto.get(i).getId().equals(id)) {
                reg = i;
            }
        }
        logger.warning("posicion de lista " + reg);
        return reg;
    }

}
