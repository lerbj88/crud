package sistema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import sistema.dao.EmpleadosDao;
import sistema.dao.NominasDao;
import sistema.dao.Nominas_detalleDao;
import sistema.dto.FacturasDto;
import sistema.dto.Nomina_detalleEmpleadoDto;
import sistema.dto.NominasDto;
import sistema.dto.Nominas_detalleDto;
import sistema.entity.Empleado;
import sistema.entity.nominas_detalle;
import sistema.services.EmpleadoService;
import sistema.services.FacturasService;
import sistema.services.NominasService;

import java.util.List;
import java.util.logging.Logger;

@Controller
public class EmpleadoController {

    private final static Logger logger = Logger.getLogger("sistema.controller.EmpleadosController");


    @Autowired
    EmpleadoService empleadoService;

    @Autowired
    EmpleadosDao empleadosDao;

    @Autowired
    FacturasService facturasService;

    @Autowired
    NominasService nominasService;


    @Autowired
    NominasDao nominasDao;

    @Autowired
    Nominas_detalleDao nominas_detalleDao;

    @RequestMapping(value = { "empleados/list" }, method = RequestMethod.GET)
    public String getClientes(@RequestParam(name = "text", required = false) String text,
                              @PageableDefault(size = 15) Pageable pageable,
                              ModelMap modelMap){

        Page<Empleado> lista = empleadoService.getPages(pageable, text);
        PageWrapper<Empleado> page = new PageWrapper<Empleado>(lista, "list");
        modelMap.addAttribute("lista", page.getContent());
        modelMap.addAttribute("page", page);
        return "empleados/list";
    }

    @GetMapping("empleados/form")
    public String form(
                       @ModelAttribute(value = "empleado") Empleado empleado,
                       ModelMap model){

            Empleado emplead = new Empleado();
            model.addAttribute("empleado", emplead);
            return "empleados/form";


    }


    @GetMapping("empleados/edit")
    public String edit(@RequestParam(name = "fiid", required = false) Integer fiid,
                       @ModelAttribute(value = "empleado") Empleado empleado,
                       ModelMap model){

            Empleado emplead = empleadosDao.obtenerEmpleado(fiid);
            model.addAttribute("empleado", emplead);
            return "empleados/edit";


    }


    @PostMapping("empleados/form")
    public String Agregar(
            @ModelAttribute(value = "empleados") Empleado empleado,
            ModelMap model) {

        if(empleado.getFiid()!=null){
            empleadosDao.actualizarEmpleado(empleado.getFiid(),empleado.getFcnombre(),empleado.getFccorreo(),empleado.getFcdireccion(),empleado.getFctelefono(),empleado.getFdfechanacimiento(),empleado.getFdfechaingreso(),empleado.getFiporcentaje(),empleado.getFipuesto(),empleado.getFccurp(),empleado.getFnstatus());

        }else {

            empleadosDao.crearEmpleado(empleado.getFcnombre(),empleado.getFccorreo(),empleado.getFcdireccion(), empleado.getFctelefono(),empleado.getFdfechanacimiento(),empleado.getFdfechaingreso(),empleado.getFiporcentaje(),empleado.getFipuesto(),empleado.getFccurp(),1);

        }
        return "redirect:list";
    }


    @RequestMapping("empleados/eliminar")
    public String Eliminar(@RequestParam(name = "fiid", required = false) Integer fiid) {
        empleadosDao.eliminarEmpleado(fiid);
        return "redirect:list";
    }



    @RequestMapping(value = { "empleados/nomina" }, method = RequestMethod.GET)
    public String getFacturasxlavador(@RequestParam(name = "fiid", required = false) Integer fiid,
                              @PageableDefault(size = 15) Pageable pageable,
                              ModelMap modelMap){

        Page<FacturasDto> lista = facturasService.getFacturasxlavador(pageable, fiid);
        PageWrapper<FacturasDto> page = new PageWrapper<FacturasDto>(lista, "nomina");
        modelMap.addAttribute("lista", page.getContent());
        modelMap.addAttribute("page", page);
        modelMap.addAttribute("lavador",page.getContent().get(0).getFcempleado());

        return "empleados/nomina";

    }



    @RequestMapping(value = { "empleados/nominalist" }, method = RequestMethod.GET)
    public String getEmpleados(@RequestParam(name = "text", required = false) String text,
                              @PageableDefault(size = 15) Pageable pageable,
                              ModelMap modelMap){

        Page<Empleado> lista = empleadoService.getPages(pageable);
        PageWrapper<Empleado> page = new PageWrapper<Empleado>(lista, "nominalist");
        modelMap.addAttribute("lista", page.getContent());
        modelMap.addAttribute("page", page);
        return "empleados/nominalist";
    }


    @RequestMapping(value = { "empleados/nominalistxempleado" }, method = RequestMethod.GET)
    public String getNominasxempleado(@RequestParam(name = "fiid", required = false) Integer fiid,
                                      @PageableDefault(size = 5) Pageable pageable,
                                      ModelMap modelMap){

        Page<NominasDto> lista = nominasService.getPages(pageable, fiid);
        PageWrapper<NominasDto> page = new PageWrapper<NominasDto>(lista, "nominalistxempleado");

        modelMap.addAttribute("lista", page.getContent());
        modelMap.addAttribute("page", page);
        return "empleados/nominalistxempleado";

    }

    @RequestMapping(value = { "empleados/nominaDetalle" }, method = RequestMethod.GET)
    public String getDetalleNomina(@RequestParam(name = "fiid", required = false) Integer fiid,
                                      @PageableDefault(size = 5) Pageable pageable,
                                      ModelMap modelMap){

        Nominas_detalleDto nominasDto= nominasDao.getNomina_detalle(fiid);
        List<nominas_detalle> detallenomina = nominas_detalleDao.getDetalles(fiid);

        modelMap.addAttribute("cabeceroNomina", nominasDto);
        modelMap.addAttribute("detalleNomina", detallenomina);

        return "empleados/nominaDetalle";

    }

    @RequestMapping(value = { "empleados/crearNomina" }, method = RequestMethod.GET)
    public String getcrearNomina(@RequestParam(name = "fiid") Integer fiid,
                                   ModelMap modelMap){

        Empleado empleado = empleadosDao.obtenerEmpleado(fiid);
        List<Nomina_detalleEmpleadoDto> detallesNomina = nominas_detalleDao.getDetalle_nomina(fiid);

        Double totalpercepcion = detallesNomina.stream().mapToDouble(o -> o.getFipercepcion()).sum();

        modelMap.addAttribute("empleado", empleado);
        modelMap.addAttribute("detalleNomina", detallesNomina);
        modelMap.addAttribute("totalpercepcion", totalpercepcion);

        return "empleados/crearNomina";

    }



    @PostMapping("empleados/crearNomina")
    public String crearFActura(
            @RequestParam(name = "fiempleado", required = false) Integer fiempleado,
            @RequestParam(name = "fitotal", required = false) Double fitotal,
            @RequestParam(value = "finum") Integer[] finum,
            @RequestParam(value = "fiarticulo") Integer[] fiarticulo,
            @RequestParam(value = "fcclave") String[] fcclave,
            @RequestParam(value = "fcdescripcion") String[] fcdescripcion,
            @RequestParam(value = "fiprecio") Double[] fiprecio,
            @RequestParam(value = "fitotaln") Double[] fitotaln,
            ModelMap model) {

        nominasService.crearNomina(fiempleado, fitotal, finum, fiarticulo, fcclave, fcdescripcion,fiprecio,fitotaln);
        Integer finomina = nominasDao.maxId();

        return "redirect:/empleados/nominaDetalle?fiid=" + finomina;

    }



}
