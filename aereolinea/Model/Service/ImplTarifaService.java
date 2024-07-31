package com.springboot.aereolinea.Model.Service;

import com.springboot.aereolinea.Model.Dao.InterfaceTarifaDAO;
import com.springboot.aereolinea.Model.Entity.Aereopuerto;
import com.springboot.aereolinea.Model.Entity.Tarifa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ImplTarifaService implements InterfaceTarifaService{

    @Autowired
    private InterfaceTarifaDAO tarifaDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Tarifa> findAll() {
        return (List<Tarifa>) tarifaDAO.findAll();
    }

    @Override
    @Transactional
    public void save(Tarifa tarifa) {
        tarifaDAO.save(tarifa);
    }

    @Override
    @Transactional(readOnly = true)
    public Tarifa findOne(Long id) {
        return tarifaDAO.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        tarifaDAO.deleteById(id);
    }

    @Override
    public long obtenerTotalTarifas() {
        return tarifaDAO.contarTarifas();
    }
}
