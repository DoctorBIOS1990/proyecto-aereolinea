package com.springboot.aereolinea.Model.Service;

import com.springboot.aereolinea.Model.Entity.Aereopuerto;

import java.util.List;

public interface InterfaceAereopuertoService {
    public List<Aereopuerto> findAll();

    public void save(Aereopuerto aereopuerto);

    public Aereopuerto findOne(Long id);

    public void delete(Long id);

    public long obtenerTotalAereopuertos();
}
