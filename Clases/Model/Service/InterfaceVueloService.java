package com.springboot.aereolinea.Model.Service;

import com.springboot.aereolinea.Model.Entity.Tarifa;
import com.springboot.aereolinea.Model.Entity.Vuelo;

import java.util.List;

public interface InterfaceVueloService {

    public List<Vuelo> findAll();

    public void save(Vuelo vuelo);

    public Vuelo findOne(Long id);

    public void delete(Long id);

    public long obtenerTotalVuelos();


}
