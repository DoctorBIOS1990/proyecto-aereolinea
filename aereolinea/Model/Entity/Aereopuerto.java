package com.springboot.aereolinea.Model.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "aereopuerto")
public class Aereopuerto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String sigla;
    private String ciudad;

    @JsonIgnore
    @OneToMany(mappedBy = "aereopuerto",  fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Avion> aviones;

    @JsonIgnore
    @OneToMany(mappedBy = "llegada",  fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Tramo> llegadaTramo;

    @JsonIgnore
    @OneToMany(mappedBy = "salida",  fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Tramo> salidaTramo;

    @JsonIgnore
    @OneToMany(mappedBy = "llegada",  fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Vuelo> llegadaVuelo;

    @JsonIgnore
    @OneToMany(mappedBy = "salida",  fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Vuelo> salidaVuelo;

    public List<Vuelo> getLlegadaVuelo() {
        return llegadaVuelo;
    }

    public void setLlegadaVuelo(List<Vuelo> llegadaVuelo) {
        this.llegadaVuelo = llegadaVuelo;
    }

    public List<Vuelo> getSalidaVuelo() {
        return salidaVuelo;
    }

    public void setSalidaVuelo(List<Vuelo> salidaVuelo) {
        this.salidaVuelo = salidaVuelo;
    }

    public List<Tramo> getLlegadaTramo() {
        return llegadaTramo;
    }

    public void setLlegadaTramo(List<Tramo> llegadaTramo) {
        this.llegadaTramo = llegadaTramo;
    }

    public List<Tramo> getSalidaTramo() {
        return salidaTramo;
    }

    public void setSalidaTramo(List<Tramo> salidaTramo) {
        this.salidaTramo = salidaTramo;
    }

    public List<Avion> getAviones() {
        return aviones;
    }

    public void setAviones(List<Avion> aviones) {
        this.aviones = aviones;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString(){
        return nombre;
    }
}
