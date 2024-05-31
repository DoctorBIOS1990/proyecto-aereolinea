package com.springboot.aereolinea.Controller;

import com.springboot.aereolinea.Model.Entity.Aereopuerto;
import com.springboot.aereolinea.Model.Entity.Avion;
import com.springboot.aereolinea.Model.Service.InterfaceAereopuertoService;
import com.springboot.aereolinea.Model.Service.InterfaceAvionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/avion")
public class AvionController {
    @Autowired
    private InterfaceAvionService avionService;

    @Autowired
    private InterfaceAereopuertoService aereopuertoService;

    @RequestMapping(value = "listar", method = RequestMethod.GET)
    public String listar(Model model) {
        model.addAttribute("titulo", "LISTADO DE AVIONES");
        model.addAttribute("avion", avionService.findAll());
        return "avion/listar";
    }

    @RequestMapping(value = "form")
    public String crear(Map<String, Object> model) {
        Avion avion = new Avion();
        List<Aereopuerto> aereopuertoList = aereopuertoService.findAll();
        model.put("titulo", "NUEVO AVION");
        model.put("avion", avion);
        model.put("aereopuertoLista", aereopuertoList);
        return "avion/form";
    }

    @RequestMapping(value = "form", method = RequestMethod.POST)
    public String guardar(Avion avion) {
        avionService.save(avion);
        return "redirect:listar";
    }

    @RequestMapping(value = "/form/{idAvion}")
    public String editar(@PathVariable(value = "idAvion") Long id, Map<String, Object> model) {

        Avion avion = null;
        if (id > 0)
            avion = avionService.findOne(id);
        else
            return "redirect:listar";

        List<Aereopuerto> aereopuertoList = aereopuertoService.findAll();
        model.put("avion", avion);
        model.put("titulo", "EDITAR AVION");
        model.put("aereopuertoLista", aereopuertoList);
        return "avion/form";
    }

    @RequestMapping(value = "eliminar/{idAvion}")
    public String eliminar(@PathVariable(value = "idAvion") Long id) {
        if (id > 0)
            avionService.delete(id);
        return "redirect:/avion/listar";
    }



}
