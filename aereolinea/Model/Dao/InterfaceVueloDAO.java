package com.springboot.aereolinea.Model.Dao;

import com.springboot.aereolinea.Model.Entity.Vuelo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface InterfaceVueloDAO extends CrudRepository<Vuelo,Long> {
    @Query("SELECT COUNT(v) FROM Vuelo v")
    long contarVuelos();
}
