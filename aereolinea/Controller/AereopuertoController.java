package com.springboot.aereolinea.Controller;

import com.springboot.aereolinea.Model.Entity.Aereopuerto;
import com.springboot.aereolinea.Model.Service.InterfaceAereopuertoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping("/aereopuerto")
public class AereopuertoController {
    @Autowired
    private InterfaceAereopuertoService aereopuertoService;

    @RequestMapping(value = "listar", method = RequestMethod.GET)
    public String listar(Model model) {
        model.addAttribute("titulo", "LISTADO DE AEREOPUERTOS");
        model.addAttribute("aereopuertos", aereopuertoService.findAll());
        return "aereopuerto/listar";
    }

    @RequestMapping(value = "form")
    public String crear(Map<String, Object> model) {
        Aereopuerto aereopuerto = new Aereopuerto();
        model.put("titulo", "NUEVO AEREOPUERTO");
        model.put("aereopuerto", aereopuerto);
        return "aereopuerto/form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(Aereopuerto aereopuerto) {
        aereopuertoService.save(aereopuerto);
        return "redirect:listar";
    }

    @RequestMapping(value = "/form/{id}")
    public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model) {
        Aereopuerto aereopuerto = null;
        if (id > 0)
            aereopuerto = aereopuertoService.findOne(id);
        else
            return "aereopuerto/listar";

        model.put("aereopuerto", aereopuerto);
        model.put("titulo", "EDITAR AEREOPUERTO");
        return "aereopuerto/form";
    }

    @RequestMapping(value = "eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id) {
        if (id > 0)
            aereopuertoService.delete(id);
        return "redirect:/aereopuerto/listar";
    }

}
