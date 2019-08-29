package sistema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import sistema.dao.ArticulosDao;
import sistema.entity.Articulos;
import sistema.services.ArticulosService;


@Controller
public class ArticulosController {

    @Autowired
    private  ArticulosService articulosService;

    @Autowired
    private ArticulosDao articulosDao;

    @RequestMapping(value = { "articulos/list" }, method = RequestMethod.GET)
    public String getClientes(@RequestParam(name = "text", required = false) String text,
                              @PageableDefault(size = 5) Pageable pageable,
                              ModelMap modelMap){

        Page<Articulos> lista = articulosService.getPages(pageable, text);
        PageWrapper<Articulos> page = new PageWrapper<Articulos>(lista, "list");
        modelMap.addAttribute("lista", page.getContent());
        modelMap.addAttribute("page", page);


        return "articulos/list";
 
    }



    @GetMapping("articulos/form")
    public String form(
            @ModelAttribute(value = "articulos") Articulos articulos,
            ModelMap model){

        Articulos articulo = new Articulos();
        model.addAttribute("articulo", articulo);
        return "articulos/form";

    }


    @GetMapping("articulos/edit")
    public String edit(@RequestParam(name = "fiid", required = false) Integer fiid,
                       @ModelAttribute(value = "articulos") Articulos articulos,
                       ModelMap model){

        Articulos articulo = articulosDao.obtenerArticulo(fiid);
        model.addAttribute("articulo", articulo);
        return "articulos/edit";


    }


    @PostMapping("articulos/form")
    public String Agregar(
            @ModelAttribute(value = "articulos") Articulos articulos,
            ModelMap model) {

        if(articulos.getFiid()!=null){
           articulosDao.actualizarArticulo(articulos.getFiid(),articulos.getFcclave(),articulos.getFcdescripcion(),articulos.getFccategoria(), articulos.getFcmarca(),articulos.getFccodigobarras(),articulos.getFicosto(),articulos.getFiprecio(),articulos.getFnstatus());

        }else {

            articulosDao.crearArticulo(articulos.getFcclave(),articulos.getFcdescripcion(),articulos.getFccategoria(), articulos.getFcmarca(),articulos.getFccodigobarras(),articulos.getFicosto(),articulos.getFiprecio(),articulos.getFitipo());

        }
        return "redirect:list";
    }



    @RequestMapping("articulos/eliminar")
    public String Eliminar(@RequestParam(name = "fiid", required = false) Integer fiid) {
        articulosDao.eliminarArticulo(fiid);
        return "redirect:list";
    }

}
