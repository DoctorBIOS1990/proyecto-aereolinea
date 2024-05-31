package com.springboot.aereolinea.Model.Service;

import com.springboot.aereolinea.Model.Dao.InterfaceTramoDAO;
import com.springboot.aereolinea.Model.Entity.Tramo;
import com.springboot.aereolinea.Model.Entity.Vuelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ImplTramoService  implements InterfaceTramoService{

    @Autowired
    private InterfaceTramoDAO tramoDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Tramo> findAll() {
         return (List<Tramo>) tramoDAO.findAll();
    }

    @Override
    @Transactional
    public void save(Tramo tramo) {
          tramoDAO.save(tramo);
    }

    @Override
    @Transactional(readOnly = true)
    public Tramo findOne(Long id) {
        return tramoDAO.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        tramoDAO.deleteById(id);
    }

    @Override
    public long obtenerTotalTramos() {
        return tramoDAO.contarTramos();
    }
}
