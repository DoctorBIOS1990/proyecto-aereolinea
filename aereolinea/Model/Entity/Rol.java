package com.springboot.aereolinea.Model.Entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="authorities", uniqueConstraints =
        {@UniqueConstraint(columnNames = {"user_id", "authorities"})})

public class Rol implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String authority;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
