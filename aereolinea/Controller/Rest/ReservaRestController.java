package com.springboot.aereolinea.Controller.Rest;

import com.springboot.aereolinea.Model.Entity.Reserva;
import com.springboot.aereolinea.Model.Service.InterfaceReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reservas")
public class ReservaRestController {

    @Autowired
    private InterfaceReservaService reservaService;

    @GetMapping("/listar")
    public List<Reserva> getReservas(){
        return reservaService.findAll();
    }

}
