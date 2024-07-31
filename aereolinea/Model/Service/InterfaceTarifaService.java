package com.springboot.aereolinea.Model.Service;

import com.springboot.aereolinea.Model.Entity.Aereopuerto;
import com.springboot.aereolinea.Model.Entity.Tarifa;

import java.util.List;

public interface InterfaceTarifaService {

    public List<Tarifa> findAll();

    public void save(Tarifa tarifa);

    public Tarifa findOne(Long id);

    public void delete(Long id);

    public long obtenerTotalTarifas();
}
