package sistema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import sistema.dao.ArticulosDao;
import sistema.dao.EntradasinventarioDao;
import sistema.dao.Entradasinventario_detalleDao;
import sistema.dto.ArticulosDto;
import sistema.entity.Articulos;
import sistema.entity.Entradasinventario;
import sistema.entity.Entradasinventario_detalle;
import sistema.services.EntradasinventarioService;

import java.util.ArrayList;
import java.util.List;

@Controller
@Scope("session")
public class InventarioController {


    @Autowired
    EntradasinventarioService entradasinventarioService;

    @Autowired
    EntradasinventarioDao entradasinventarioDao;
    @Autowired
    Entradasinventario_detalleDao entradasinventario_detalleDao;

    @Autowired
    ArticulosDao articulosDao;

    private  List<ArticulosDto> artsDto = new ArrayList<ArticulosDto>();

   // private static int n = 0;

    @RequestMapping(value = {"inventario/listentradas"}, method = RequestMethod.GET)
    public String getEntradas(@RequestParam(name = "text", required = false) Integer fiid,
                              @PageableDefault(size = 5) Pageable pageable,
                              ModelMap modelMap) {

        Page<Entradasinventario> lista = entradasinventarioService.getPages(pageable, fiid);
        PageWrapper<Entradasinventario> page = new PageWrapper<Entradasinventario>(lista, "listentradas");
        modelMap.addAttribute("lista", page.getContent());
        modelMap.addAttribute("page", page);
        return "inventario/listentradas";
    }

    @RequestMapping(value = {"inventario/listentradasDetalle"}, method = RequestMethod.GET)
    public String getEnradaDetalle(@RequestParam(name = "fiid", required = false) Integer fiid,
                                   ModelMap modelMap) {

        Entradasinventario cabeceroEntrada = entradasinventarioDao.getEntrada(fiid);
        List<Entradasinventario_detalle> detalleEntrada = entradasinventario_detalleDao.getDetalles(fiid);
        modelMap.addAttribute("cabeceroEntrada", cabeceroEntrada);
        modelMap.addAttribute("detalleEntrada", detalleEntrada);
        return "inventario/listentradasDetalle";

    }

    @GetMapping("inventario/crearEntrada")
    public String form(
            //    @RequestParam(name = "placas", required = false) String fcplacas,
            @RequestParam(name = "fiarticulo", required = false) Integer fiarticulo,
            ModelMap model) {

        List<Articulos> listaarticulos = articulosDao.getArticulosEntradas();
        // List<Empleado> listarempleados = empleadosDao.listarEmpleados(text);
        //List<ArticulosDto> artdto = new ArrayList<ArticulosDto>();


        model.addAttribute("listaarticulos", listaarticulos);
        artsDto = new ArrayList<ArticulosDto>();
        //n = Integer.parseInt(null);
        model.addAttribute("listaartdto", artsDto);
        return "inventario/crearEntrada";


    }


    @PostMapping("inventario/crearEntrada")
    public String Agregar(
            @RequestParam(name = "fiarticulo", required = false) Integer fiarticulo,
            @RequestParam(name = "ficantidad", required = false) Integer ficantidad,
            @RequestParam(name = "ficosto", required = false) Double ficosto,
            ModelMap model) {


        List<Articulos> listaarticulos = articulosDao.getArticulosEntradas();
        Articulos articulo = articulosDao.obtenerArticulo(fiarticulo);



        ArticulosDto artDto = new ArticulosDto(articulo.getFiid(),  artsDto.size()+1, ficantidad, articulo.getFcclave(), articulo.getFcdescripcion(), ficosto, ficantidad * ficosto );
        artsDto.add(artDto);



          Double totalentrada = artsDto.stream().mapToDouble(o -> o.getFiimporte()).sum();

        model.addAttribute("listaarticulos", listaarticulos);
        model.addAttribute("listaartdto", artsDto);
        model.addAttribute("totalentrada", totalentrada);

        return "inventario/crearEntrada";
    }

    @PostMapping("inventario/guardarEntrada")
    public String guardarEntrada(
            @RequestParam(name = "fcdescripcion", required = false) String fcdescripcion,
            @RequestParam(name = "fitotalentrada", required = false) Double fitotalentrada,
            @RequestParam(name = "listacostos") Double [] filistacostos,
            @RequestParam(value = "listacantidad") Integer[] filistacantidades,
            @RequestParam(value = "listapartidas") Integer[] listapartidas,
            ModelMap model) {

        entradasinventarioService.guardarEntrada(fcdescripcion, fitotalentrada, filistacantidades, listapartidas, filistacostos);


        Integer fientrada = entradasinventarioDao.maxId();

        return "redirect:/inventario/listentradasDetalle?fiid=" + fientrada;

    }

}
