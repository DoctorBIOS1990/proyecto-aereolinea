package com.springboot.aereolinea.Model.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "avion")
public class Avion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAvion;
    private String marca;
    private String modelo;
    private Integer asientos;

    @ManyToOne
    @JoinColumn(name = "aereopuerto_id")
    private Aereopuerto aereopuerto;

    public Long getIdAvion() {
        return idAvion;
    }

    public void setIdAvion(Long idAvion) {
        this.idAvion = idAvion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAsientos() { return asientos;    }

    public void setAsientos(Integer asientos) { this.asientos = asientos; }

    public Aereopuerto getAereopuerto() {
        return aereopuerto;
    }

    public void setAereopuerto(Aereopuerto aereopuerto) {
        this.aereopuerto = aereopuerto;
    }
}
