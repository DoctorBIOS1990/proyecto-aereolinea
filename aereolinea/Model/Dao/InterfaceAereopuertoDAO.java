package com.springboot.aereolinea.Model.Dao;

import com.springboot.aereolinea.Model.Entity.Aereopuerto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface InterfaceAereopuertoDAO extends CrudRepository<Aereopuerto,Long> {
    @Query("SELECT COUNT(r) FROM Aereopuerto r")
    long contarAereopuertos();
}
