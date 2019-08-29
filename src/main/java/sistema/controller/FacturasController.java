package sistema.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import sistema.dao.CortecajaDao;
import sistema.dao.DepositocajaDao;
import sistema.dao.Factura_detalleDao;
import sistema.dao.FacturasDao;
import sistema.dto.FacturasDto;
import sistema.dto.Facturas_DetalleDto;
import sistema.entity.Cortecaja;
import sistema.entity.Depositocaja;
import sistema.entity.Facturas_detalle;
import sistema.services.CortescajaService;
import sistema.services.DepositoscajaService;
import sistema.services.FacturasService;
import sistema.services.NominasService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class FacturasController {


    @Autowired
    FacturasService facturasService;


    @Autowired
    Factura_detalleDao factura_detalleDao;

    @Autowired
    FacturasDao facturasDao;


    @Autowired
    CortescajaService cortescajaService;

    @Autowired
    CortecajaDao cortecajaDao;

    @Autowired
    NominasService nominasService;

    @Autowired
    DepositoscajaService depositoscajaService;

    @Autowired
    DepositocajaDao depositocajaDao;


    @RequestMapping(value = { "facturas/list" }, method = RequestMethod.GET)
    public String getFacturas(@RequestParam(name = "text", required = false) Integer fiid,
                              @PageableDefault(size = 5) Pageable pageable,
                              ModelMap modelMap){

        Page<FacturasDto> lista = facturasService.getPages(pageable, fiid);
        PageWrapper<FacturasDto> page = new PageWrapper<FacturasDto>(lista, "list");
        modelMap.addAttribute("lista", page.getContent());
        modelMap.addAttribute("page", page);
        return "facturas/list";

    }

    @RequestMapping(value = { "facturas/listDetalle" }, method = RequestMethod.GET)
    public String getFacturas_detalle(@RequestParam(name = "fiid", required = false) Integer fiid,
                              ModelMap modelMap){
        Facturas_DetalleDto facturaCabecero = facturasDao.obtenerFactura(fiid);
        List<Facturas_detalle> detalleFactura = factura_detalleDao.getFactura_detalle(fiid);
        String fclavadores = facturasService.getLavadoresxfactura(fiid);

        modelMap.addAttribute("cabeceroFactura", facturaCabecero);
        modelMap.addAttribute("detalleFactura", detalleFactura);
        modelMap.addAttribute("fclavadores",fclavadores);
        return "facturas/listDetalle";

    }

    @RequestMapping("facturas/cancelar")
    public String CancelarFactura(@RequestParam(name = "id", required = false) Integer fifactura) {
        facturasDao.cancelarFactura(fifactura);
        return "redirect:list";
    }





    @RequestMapping(value = { "facturas/listcortecaja" }, method = RequestMethod.GET)
    public String getCortescaja(@RequestParam(name = "text", required = false) Integer fiid,
                              @PageableDefault(size = 5) Pageable pageable,
                              ModelMap modelMap){

        Page<Cortecaja> lista = cortescajaService.getPages(pageable, fiid);
        PageWrapper<Cortecaja> page = new PageWrapper<Cortecaja>(lista, "listcortecaja");
        Double totalcaja = cortescajaService.totalCaja();
        modelMap.addAttribute("totalcaja", totalcaja);
        modelMap.addAttribute("lista", page.getContent());
        modelMap.addAttribute("page", page);
        return "facturas/listcortecaja";

    }


    @GetMapping("facturas/cortecaja")
    public String cortecaja(
            @ModelAttribute(value = "cortecaja") Cortecaja cortecaja,
            ModelMap model){
        Date fecha = new Date();
        DateFormat Formato = new SimpleDateFormat("dd/mm/yyyy HH:mm:ss");

        Cortecaja cortecaja1 = new Cortecaja();
        model.addAttribute("cortecaja", cortecaja1);
        Double totalcaja = cortescajaService.totalCaja();
        model.addAttribute("totalcaja", totalcaja);
        model.addAttribute("fdfecha", Formato.format(fecha));

        return "facturas/cortecaja";

    }


    @PostMapping("facturas/cortecaja")
    public String Agregar(
            @ModelAttribute(value = "cortecaja") Cortecaja cortecaja,
            ModelMap model) {

        cortescajaService.crear(cortecaja.getFiretiro(),cortecaja.getFcdescripcion());

        return "redirect:listcortecaja";
    }


    @RequestMapping("facturas/cancelarcorte")
    public String Eliminar(@RequestParam(name = "id", required = false) Integer fiid) {

        cortecajaDao.cancelarCortecaja(fiid);

        return "redirect:listcortecaja";
    }

    @RequestMapping(value = { "facturas/listdepositocaja" }, method = RequestMethod.GET)
    public String getdepositoscaja(@RequestParam(name = "text", required = false) Integer fiid,
                                @PageableDefault(size = 5) Pageable pageable,
                                ModelMap modelMap){

        Page<Depositocaja> lista = depositoscajaService.getPages(pageable, fiid);
        PageWrapper<Depositocaja> page = new PageWrapper<Depositocaja>(lista, "listdepositocaja");

        modelMap.addAttribute("lista", page.getContent());
        modelMap.addAttribute("page", page);
        return "facturas/listdepositocaja";

    }


    @GetMapping("facturas/depositocaja")
    public String depositocaja(
            @ModelAttribute(value = "depositocaja") Depositocaja depositocaja,
            ModelMap model){
        Date fecha = new Date();
        DateFormat Formato = new SimpleDateFormat("dd/mm/yyyy HH:mm:ss");

        Depositocaja depositocaja1 = new Depositocaja();
        model.addAttribute("depositocaja", depositocaja1);
        Double totalcaja = cortescajaService.totalCaja();
        model.addAttribute("totalcaja", totalcaja);
        model.addAttribute("fdfecha", Formato.format(fecha));

        return "facturas/depositocaja";

    }


    @PostMapping("facturas/depositocaja")
    public String AgregarDeposito(
            @ModelAttribute(value = "depositocaja") Depositocaja depositocaja,
            ModelMap model) {

        final String fcusuario = SecurityContextHolder.getContext().getAuthentication().getName();
        depositocajaDao.crear(depositocaja.getFideposito(),depositocaja.getFcdescripcion(),fcusuario);

        return "redirect:listdepositocaja";
    }

}



