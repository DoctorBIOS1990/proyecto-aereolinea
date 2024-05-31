package com.springboot.aereolinea.Model.Dao;

import com.springboot.aereolinea.Model.Entity.Avion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface InterfaceAvionDAO extends CrudRepository<Avion,Long> {
    @Query("SELECT COUNT(a) FROM Avion a")
    long contarAviones();
}
