package com.springboot.aereolinea.Model.Dao;

import com.springboot.aereolinea.Model.Entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface InterfaceUsuarioDAO  extends CrudRepository <Usuario, Long> {

    public Usuario findByUsername (String username);


}
