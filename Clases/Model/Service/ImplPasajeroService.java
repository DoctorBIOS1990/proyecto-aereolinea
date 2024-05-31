package com.springboot.aereolinea.Model.Service;

import com.springboot.aereolinea.Model.Dao.InterfaceAereopuertoDAO;
import com.springboot.aereolinea.Model.Dao.InterfacePasajeroDAO;
import com.springboot.aereolinea.Model.Entity.Aereopuerto;
import com.springboot.aereolinea.Model.Entity.Pasajero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ImplPasajeroService implements InterfacePasajeroService{

    @Autowired
    private InterfacePasajeroDAO pasajeroDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Pasajero> findAll() {
        return (List<Pasajero>) pasajeroDAO.findAll();
    }

    @Override
    @Transactional
    public void save(Pasajero pasajero) {
        pasajeroDAO.save(pasajero);
    }

    @Override
    @Transactional(readOnly = true)
    public Pasajero findOne(Long id) {
        return pasajeroDAO.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        pasajeroDAO.deleteById(id);
    }

    @Override
    public long obtenerTotalPasajeros() {
        return pasajeroDAO.contarPasajeros();
    }

}
