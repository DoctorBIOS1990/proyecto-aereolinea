package com.springboot.aereolinea.Model.Service;

import com.springboot.aereolinea.Model.Entity.Tramo;

import java.util.List;

public interface InterfaceTramoService {

    public List<Tramo> findAll();

    public void save(Tramo tramo);

    public Tramo findOne(Long id);

    public void delete(Long id);

    public long obtenerTotalTramos();
}
