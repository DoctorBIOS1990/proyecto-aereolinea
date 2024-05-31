package com.springboot.aereolinea.Controller;

import com.springboot.aereolinea.Model.Entity.*;
import com.springboot.aereolinea.Model.Service.*;
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
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    private InterfaceTramoService tramoService;

    @Autowired
    private InterfaceVueloService vueloService;

    @Autowired
    private InterfaceTarifaService tarifaService;

    @Autowired
    private InterfaceReservaService reservaService;

    @Autowired
    private InterfacePasajeroService pasajeroService;

    @RequestMapping(value = "listar", method = RequestMethod.GET)
    public String listar(Model model) {
        model.addAttribute("titulo", "LISTADO DE RESERVAS");
        model.addAttribute("reserva", reservaService.findAll());
        return "reserva/listar";
    }

    @RequestMapping(value = "form")
    public String crear(Map<String, Object> model) {
        Reserva reserva = new Reserva();

        List<Tarifa> tarifaList = tarifaService.findAll();
        List<Vuelo> vueloList = vueloService.findAll();
        List<Pasajero> pasajeroList = pasajeroService.findAll();
        List<Tramo> tramoList = tramoService.findAll();

        model.put("reserva", reserva);
        model.put("titulo", "NUEVA RESERVA");

        model.put("pasajeroLista", pasajeroList);
        model.put("tramoLista", tramoList);
        model.put("vueloLista", vueloList);
        model.put("tarifaLista", tarifaList);

        return "reserva/form";
    }

    @RequestMapping(value = "form", method = RequestMethod.POST)
    public String guardar(Reserva reserva) {
        reservaService.save(reserva);
        return "redirect:listar";
    }

    @RequestMapping(value = "/form/{idReserva}")
    public String editar(@PathVariable(value = "idReserva") Long id, Map<String, Object> model) {

        Reserva reserva = null;
        if (id > 0)
            reserva = reservaService.findOne(id);
        else
            return "redirect:listar";

        List<Tarifa> tarifaList = tarifaService.findAll();
        List<Vuelo> vueloList = vueloService.findAll();
        List<Pasajero> pasajeroList = pasajeroService.findAll();
        List<Tramo> tramoList = tramoService.findAll();

        model.put("reserva", reserva);
        model.put("titulo", "EDITAR RESERVA");

        model.put("pasajeroLista", pasajeroList);
        model.put("tramoLista", tramoList);
        model.put("vueloLista", vueloList);
        model.put("tarifaLista", tarifaList);

        return "reserva/form";
    }

    @RequestMapping(value = "eliminar/{idReserva}")
    public String eliminar(@PathVariable(value = "idReserva") Long id) {
        if (id > 0)
            reservaService.delete(id);
        return "redirect:/reserva/listar";
    }
}
