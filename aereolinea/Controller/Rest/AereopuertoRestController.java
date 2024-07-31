package com.springboot.aereolinea.Controller.Rest;


import com.springboot.aereolinea.Model.Entity.Aereopuerto;
import com.springboot.aereolinea.Model.Service.InterfaceAereopuertoService;
import groovyjarjarasm.asm.tree.TryCatchBlockNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/aereopuertos")
public class AereopuertoRestController {

    @Autowired
    private InterfaceAereopuertoService aereopuertoService;

    @GetMapping(path = "/listar")
    public List<Aereopuerto> getAllAeropuertos(){
        return aereopuertoService.findAll();
    }

    @GetMapping(path = "/listar/{id}")
    public ResponseEntity<Aereopuerto> getAeropuerto(@PathVariable("id") Long id){
        try{
                Aereopuerto aereopuerto = aereopuertoService.findOne(id);
                return new ResponseEntity<Aereopuerto>(aereopuerto, HttpStatus.OK);
            }
        catch (Exception excepcion){
                return new ResponseEntity<Aereopuerto>(HttpStatus.NOT_FOUND);
            }
    }

    @PostMapping("/agregar")
    public void guardarAereopuerto(@RequestBody Aereopuerto aereopuerto){
        aereopuertoService.save(aereopuerto);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarAereopuerto(@RequestBody Aereopuerto aereopuerto,
                                                   @PathVariable("id") Long id)
    {
        try{
            Aereopuerto aereopuertoExistente = aereopuertoService.findOne(id);

            aereopuertoExistente.setNombre(aereopuerto.getNombre());
            aereopuertoExistente.setSigla(aereopuerto.getSigla());
            aereopuertoExistente.setCiudad(aereopuerto.getCiudad());
            aereopuertoService.save(aereopuertoExistente);
            
            return new ResponseEntity<Aereopuerto>(HttpStatus.OK);
        }
        catch (Exception excepcion){
            return new ResponseEntity<Aereopuerto>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/eliminar/{id}")
    public void eliminarAeropuerto(@PathVariable("id")Long id){
        aereopuertoService.delete(id);
    }


}

