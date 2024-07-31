package com.springboot.aereolinea.Controller;

import com.springboot.aereolinea.Model.Entity.Aereopuerto;
import com.springboot.aereolinea.Model.Entity.Tramo;
import com.springboot.aereolinea.Model.Entity.Vuelo;
import com.springboot.aereolinea.Model.Service.InterfaceAereopuertoService;
import com.springboot.aereolinea.Model.Service.InterfaceTramoService;
import com.springboot.aereolinea.Model.Service.InterfaceVueloService;
import nz.net.ultraq.thymeleaf.layoutdialect.models.extensions.IModelExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/tramo")
public class TramoController {

    @Autowired
    private InterfaceTramoService tramoService;

    @Autowired
    private InterfaceVueloService vueloService;

    @Autowired
    private InterfaceAereopuertoService aereopuertoService;

    @RequestMapping(value = "listar", method = RequestMethod.GET)
    public String listar(Model model) {
        model.addAttribute("titulo", "LISTADO DE TRAMOS");
        model.addAttribute("tramo", tramoService.findAll());
        return "tramo/listar";
    }

    @RequestMapping(value = "form")
    public String crear(Map<String, Object> model) {
        Tramo tramo = new Tramo();
        List<Aereopuerto> aereopuertoList = aereopuertoService.findAll();
        List<Vuelo> vueloList = vueloService.findAll();
        model.put("tramo", tramo);
        model.put("titulo", "NUEVO TRAMO");
        model.put("aereopuertoLista", aereopuertoList);
        model.put("vueloLista", vueloList);
        return "tramo/form";
    }

    @RequestMapping(value = "form", method = RequestMethod.POST)
    public String guardar(Tramo tramo) {
        tramoService.save(tramo);
        return "redirect:listar";
    }

    @RequestMapping(value = "/form/{idTramo}")
    public String editar(@PathVariable(value = "idTramo") Long id, Map<String, Object> model) {

        Tramo tramo = null;
        if (id > 0)
            tramo = tramoService.findOne(id);
        else
            return "redirect:listar";

        List<Aereopuerto> aereopuertoList = aereopuertoService.findAll();
        List<Vuelo> vueloList = vueloService.findAll();
        model.put("tramo", tramo);
        model.put("titulo", "EDITAR TRAMO");
        model.put("aereopuertoLista", aereopuertoList);
        model.put("vueloLista", vueloList);
        return "tramo/form";
    }

    @RequestMapping(value = "eliminar/{idTramo}")
    public String eliminar(@PathVariable(value = "idTramo") Long id) {
        if (id > 0)
            vueloService.delete(id);
        return "redirect:/tramo/listar";
    }
}
