package com.springboot.aereolinea.Model.Dao;

import com.springboot.aereolinea.Model.Entity.Tarifa;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface InterfaceTarifaDAO extends CrudRepository<Tarifa,Long> {

    @Query("SELECT COUNT(t) FROM Tarifa t")
    long contarTarifas();
}
