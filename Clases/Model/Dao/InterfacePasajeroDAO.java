package com.springboot.aereolinea.Model.Dao;

import com.springboot.aereolinea.Model.Entity.Pasajero;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface InterfacePasajeroDAO extends CrudRepository<Pasajero,Long> {

    @Query("SELECT COUNT(p) FROM Pasajero p")
    long contarPasajeros();
}
