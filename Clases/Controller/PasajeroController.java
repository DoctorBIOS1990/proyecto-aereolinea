package com.springboot.aereolinea.Controller;

import com.springboot.aereolinea.Model.Entity.Aereopuerto;
import com.springboot.aereolinea.Model.Entity.Pasajero;
import com.springboot.aereolinea.Model.Service.InterfaceAereopuertoService;
import com.springboot.aereolinea.Model.Service.InterfacePasajeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping("/pasajero")
public class PasajeroController {
    @Autowired
    private InterfacePasajeroService pasajeroService;

    @RequestMapping(value = "listar", method = RequestMethod.GET)
    public String listar(Model model) {
        model.addAttribute("titulo", "LISTADO DE PASAJEROS");
        model.addAttribute("pasajero", pasajeroService.findAll());
        return "pasajero/listar";
    }

    @RequestMapping(value = "form")
    public String crear(Map<String, Object> model) {
        Pasajero pasajero = new Pasajero();
        model.put("titulo", "NUEVO PASAJERO");
        model.put("pasajero", pasajero);
        return "pasajero/form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(Pasajero pasajero) {
        pasajeroService.save(pasajero);
        return "redirect:listar";
    }

    @RequestMapping(value = "/form/{dni}")
    public String editar(@PathVariable(value = "dni") Long dni, Map<String, Object> model) {
        Pasajero pasajero = null;
        if (dni > 0)
            pasajero = pasajeroService.findOne(dni);
        else
            return "pasajero/listar";

        model.put("pasajero", pasajero);
        model.put("titulo", "EDITAR PASAJERO");
        return "pasajero/form";
    }

    @RequestMapping(value = "eliminar/{dni}")
    public String eliminar(@PathVariable(value = "dni") Long dni) {
        if (dni > 0)
            pasajeroService.delete(dni);
        return "redirect:/pasajero/listar";
    }


}
