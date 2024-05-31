package com.springboot.aereolinea.Model.Service;

import com.springboot.aereolinea.Model.Entity.Reserva;

import java.util.List;

public interface InterfaceReservaService {

    public List<Reserva> findAll();

    public void save(Reserva reserva);

    public Reserva findOne(Long id);

    public void delete(Long id);

    public long obtenerTotalReservas();
}
