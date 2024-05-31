package com.springboot.aereolinea.Model.Service;

import com.springboot.aereolinea.Model.Entity.Aereopuerto;
import com.springboot.aereolinea.Model.Entity.Avion;

import java.util.List;

public interface InterfaceAvionService {

    public List<Avion> findAll();

    public void save(Avion avion);

    public Avion findOne(Long id);

    public void delete(Long id);

    public long obtenerTotalAviones();
}
