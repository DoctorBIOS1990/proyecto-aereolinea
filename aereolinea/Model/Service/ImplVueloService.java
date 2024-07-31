package com.springboot.aereolinea.Model.Service;

import com.springboot.aereolinea.Model.Dao.InterfaceTarifaDAO;
import com.springboot.aereolinea.Model.Dao.InterfaceVueloDAO;
import com.springboot.aereolinea.Model.Entity.Tarifa;
import com.springboot.aereolinea.Model.Entity.Vuelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ImplVueloService implements  InterfaceVueloService{

    @Autowired
    private InterfaceVueloDAO vueloDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Vuelo> findAll() {
        return (List<Vuelo>) vueloDAO.findAll();
    }

    @Override
    @Transactional
    public void save(Vuelo vuelo) { vueloDAO.save(vuelo);}

    @Override
    @Transactional(readOnly = true)
    public Vuelo findOne(Long id) {
        return vueloDAO.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        vueloDAO.deleteById(id);
    }

    @Override
    public long obtenerTotalVuelos() {
        return vueloDAO.contarVuelos();
    }
}
