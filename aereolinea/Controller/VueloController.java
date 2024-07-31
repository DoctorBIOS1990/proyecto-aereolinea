package com.springboot.aereolinea.Controller;

import com.springboot.aereolinea.Model.Entity.Aereopuerto;
import com.springboot.aereolinea.Model.Entity.Vuelo;
import com.springboot.aereolinea.Model.Service.InterfaceAereopuertoService;
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
@RequestMapping("/vuelo")
public class VueloController {
    @Autowired
    private InterfaceVueloService vueloService;

    @Autowired
    private InterfaceAereopuertoService aereopuertoService;

    @RequestMapping(value = "listar", method = RequestMethod.GET)
    public String listar(Model model) {
        model.addAttribute("titulo", "LISTADO DE VUELOS");
        model.addAttribute("vuelo", vueloService.findAll());
        return "vuelo/listar";
    }

    @RequestMapping(value = "form")
    public String crear(Map<String, Object> model) {
        Vuelo vuelo = new Vuelo();
        List<Aereopuerto> aereopuertoList = aereopuertoService.findAll();
        model.put("titulo", "NUEVO VUELO");
        model.put("vuelo", vuelo);
        model.put("aereopuertoLista", aereopuertoList);
        return "vuelo/form";
    }

    @RequestMapping(value = "form", method = RequestMethod.POST)
    public String guardar(Vuelo vuelo) {
        vueloService.save(vuelo);
        return "redirect:listar";
    }

    @RequestMapping(value = "/form/{idVuelo}")
    public String editar(@PathVariable(value = "idVuelo") Long id, Map<String, Object> model) {

        Vuelo vuelo = null;
        if (id > 0)
            vuelo = vueloService.findOne(id);
        else
            return "redirect:listar";

        List<Aereopuerto> aereopuertoList = aereopuertoService.findAll();
        model.put("vuelo", vuelo);
        model.put("titulo", "EDITAR VUELO");
        model.put("aereopuertoLista", aereopuertoList);
        return "vuelo/form";
    }

    @RequestMapping(value = "eliminar/{idVuelo}")
    public String eliminar(@PathVariable(value = "idVuelo") Long id) {
        if (id > 0)
            vueloService.delete(id);
        return "redirect:/vuelo/listar";
    }
}
