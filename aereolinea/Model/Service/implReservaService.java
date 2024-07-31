package com.springboot.aereolinea.Model.Service;

import com.springboot.aereolinea.Model.Dao.InterfaceReservaDAO;
import com.springboot.aereolinea.Model.Dao.InterfaceVueloDAO;
import com.springboot.aereolinea.Model.Entity.Reserva;
import com.springboot.aereolinea.Model.Entity.Tarifa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class implReservaService implements InterfaceReservaService{


    @Autowired
    private InterfaceReservaDAO reservaDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Reserva> findAll() {
        return (List<Reserva>) reservaDAO.findAll();
    }

    @Override
    @Transactional
    public void save(Reserva reserva) {
        reservaDAO.save(reserva);
    }

    @Override
    @Transactional(readOnly = true)
    public Reserva findOne(Long id) {
        return reservaDAO.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        reservaDAO.deleteById(id);
    }

    @Override
    public long obtenerTotalReservas() {
        return reservaDAO.contarReservas();
    }
}
