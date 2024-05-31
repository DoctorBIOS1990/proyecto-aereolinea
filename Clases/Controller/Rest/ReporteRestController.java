package com.springboot.aereolinea.Controller.Rest;

import com.springboot.aereolinea.Model.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ReporteRestController {

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

    @GetMapping(value = "/reportes")
    public List<String> getReport(Model model) {
        long totalAviones = avionService.obtenerTotalAviones();
        long totalPasajeros = pasajeroService.obtenerTotalPasajeros();
        long totalVuelos = vueloService.obtenerTotalVuelos();
        long totalTarifas = tarifaService.obtenerTotalTarifas();
        long totalAereopuertos = aereopuertoService.obtenerTotalAereopuertos();
        long totalReservas = reservaService.obtenerTotalReservas();
        long totalTramos = tramoService.obtenerTotalTramos();

        return List.of(

                "REPORTES ESTADISTICOS: ",
                "====================== ",
                "Total de Aviones: " + Long.toString(totalAviones),
                "Total de Pasajeros: " + Long.toString(totalPasajeros),
                "Total de Vuelos: " + Long.toString(totalVuelos),
                "Total de Tarifas: " + Long.toString(totalTarifas),
                "Total de Reservas: " + Long.toString(totalReservas),
                "Total de Aeropuertos: " + Long.toString(totalAereopuertos),
                "Total de Tramos: " + Long.toString(totalTramos)
        );
    }
}
