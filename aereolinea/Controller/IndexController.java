package com.springboot.aereolinea.Controller;

import com.springboot.aereolinea.Model.Dao.InterfaceReservaDAO;
import com.springboot.aereolinea.Model.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired
    private InterfaceAvionService avionService;
    @Autowired
    private InterfacePasajeroService pasajeroService;
    @Autowired
    private InterfaceVueloService vueloService;
    @Autowired
    private InterfaceTarifaService tarifaService;
    @Autowired
    private InterfaceAereopuertoService aereopuertoService;
    @Autowired
    private InterfaceReservaService reservaService;
    @Autowired
    private InterfaceTramoService tramoService;

    @GetMapping(value = "/index")
    public String showIndex(Model model) {
        long totalAviones = avionService.obtenerTotalAviones();
        long totalPasajeros = pasajeroService.obtenerTotalPasajeros();
        long totalVuelos = vueloService.obtenerTotalVuelos();
        long totalTarifas = tarifaService.obtenerTotalTarifas();
        long totalAereopuertos = aereopuertoService.obtenerTotalAereopuertos();
        long totalReservas = reservaService.obtenerTotalReservas();
        long totalTramos = tramoService.obtenerTotalTramos();


        model.addAttribute("totalAviones", totalAviones);
        model.addAttribute("totalPasajeros", totalPasajeros);
        model.addAttribute("totalVuelos", totalVuelos);
        model.addAttribute("totalTarifas", totalTarifas);
        model.addAttribute("totalAereopuertos", totalAereopuertos);
        model.addAttribute("totalReservas", totalReservas);
        model.addAttribute("totalTramos", totalTramos);

        return "index";
    }
}
