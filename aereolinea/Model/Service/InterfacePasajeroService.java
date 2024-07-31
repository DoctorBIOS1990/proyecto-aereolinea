package com.springboot.aereolinea.Model.Service;

import com.springboot.aereolinea.Model.Entity.Pasajero;

import java.util.List;

public interface InterfacePasajeroService {
    public List<Pasajero> findAll();

    public void save(Pasajero pasajero);

    public Pasajero findOne(Long id);

    public void delete(Long id);

    public long obtenerTotalPasajeros();
}
