package com.springboot.aereolinea.Controller.Rest;

import com.springboot.aereolinea.Model.Entity.Pasajero;
import com.springboot.aereolinea.Model.Service.InterfacePasajeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pasajeros")
public class PasajeroRestController {

    @Autowired
    private InterfacePasajeroService pasajeroService;

    @GetMapping(value = "/listar")
    public List<Pasajero> getPasajeros(){
        return pasajeroService.findAll();
    }

}

