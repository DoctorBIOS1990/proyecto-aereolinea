package com.springboot.aereolinea.Model.Dao;

import com.springboot.aereolinea.Model.Entity.Tramo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface InterfaceTramoDAO extends CrudRepository<Tramo,Long> {
    @Query("SELECT COUNT(t) FROM Tramo t")
    long contarTramos();
}
