package com.springboot.aereolinea.Controller;

import com.springboot.aereolinea.Model.Entity.Aereopuerto;
import com.springboot.aereolinea.Model.Entity.Tarifa;
import com.springboot.aereolinea.Model.Service.InterfaceAereopuertoService;
import com.springboot.aereolinea.Model.Service.InterfaceTarifaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping("/tarifa")
public class TarifaController {
    @Autowired
    private InterfaceTarifaService tarifaService;

    @RequestMapping(value = "listar", method = RequestMethod.GET)
    public String listar(Model model) {
        model.addAttribute("titulo", "LISTADO DE TARIFAS");
        model.addAttribute("tarifa", tarifaService.findAll());
        return "tarifa/listar";
    }

    @RequestMapping(value = "form")
    public String crear(Map<String, Object> model) {
        Tarifa tarifa = new Tarifa();
        model.put("titulo", "NUEVA TARIFA");
        model.put("tarifa", tarifa);
        return "tarifa/form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(Tarifa tarifa) {
        tarifaService.save(tarifa);
        return "redirect:listar";
    }

    @RequestMapping(value = "/form/{id}")
    public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model) {
        Tarifa tarifa = null;
        if (id > 0)
            tarifa = tarifaService.findOne(id);
        else
            return "tarifa/listar";

        model.put("tarifa", tarifa);
        model.put("titulo", "EDITAR TARIFA");
        return "tarifa/form";
    }

    @RequestMapping(value = "eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id) {
        if (id > 0)
            tarifaService.delete(id);
        return "redirect:/tarifa/listar";
    }
}
