
package com.springboot.aereolinea.Model.Service;

import com.springboot.aereolinea.Model.Dao.InterfaceAvionDAO;
import com.springboot.aereolinea.Model.Entity.Aereopuerto;
import com.springboot.aereolinea.Model.Entity.Avion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ImplAvionService implements InterfaceAvionService{

    @Autowired
    private InterfaceAvionDAO avionDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Avion> findAll() {
        return (List<Avion>) avionDAO.findAll();
    }

    @Override
    @Transactional
    public void save(Avion avion) {
        avionDAO.save(avion);
    }

    @Override
    @Transactional(readOnly = true)
    public Avion findOne(Long id) {
        return avionDAO.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        avionDAO.deleteById(id);
    }

    @Override
    public long obtenerTotalAviones(){
        return avionDAO.contarAviones();
    }

}
