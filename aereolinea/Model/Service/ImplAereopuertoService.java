package com.springboot.aereolinea.Model.Service;

import com.springboot.aereolinea.Model.Dao.InterfaceAereopuertoDAO;
import com.springboot.aereolinea.Model.Entity.Aereopuerto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ImplAereopuertoService implements InterfaceAereopuertoService {

    @Autowired
    private InterfaceAereopuertoDAO aereopuertoDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Aereopuerto> findAll() {
        return (List<Aereopuerto>) aereopuertoDAO.findAll();
    }

    @Override
    @Transactional
    public void save(Aereopuerto aereopuerto) {
        aereopuertoDAO.save(aereopuerto);
    }

    @Override
    @Transactional(readOnly = true)
    public Aereopuerto findOne(Long id) {
        return aereopuertoDAO.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        aereopuertoDAO.deleteById(id);
    }

    @Override
    public long obtenerTotalAereopuertos() {
        return aereopuertoDAO.contarAereopuertos();
    }
}
