package com.springboot.aereolinea.Model.Dao;

import com.springboot.aereolinea.Model.Entity.Reserva;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface InterfaceReservaDAO  extends CrudRepository<Reserva, Long> {

    @Query("SELECT COUNT(s) FROM Reserva s")
    long contarReservas();
}
