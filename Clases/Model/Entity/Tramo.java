package com.springboot.aereolinea.Model.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tramo")
public class Tramo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTramo;
    private String Distancia;
    private String Duracion;
    private String horaSalida;
    private String horaLlegada;

    @ManyToOne
    @JoinColumn(name = "id_vuelo")
    private Vuelo vuelo;

    @ManyToOne
    @JoinColumn(name = "aereopuerto_llegada")
    private Aereopuerto llegada;

    @ManyToOne
    @JoinColumn(name = "aereopuerto_salida")
    private Aereopuerto salida;

    @JsonIgnore
    @OneToMany(mappedBy = "tramo",  fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Reserva> reservas;


    public Long getIdTramo() {
        return idTramo;
    }

    public void setIdTramo(Long idTramo) {
        this.idTramo = idTramo;
    }

    public String getDistancia() {
        return Distancia;
    }

    public void setDistancia(String distancia) {
        Distancia = distancia;
    }

    public String getDuracion() {
        return Duracion;
    }

    public void setDuracion(String duracion) {
        Duracion = duracion;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public Aereopuerto getLlegada() {
        return llegada;
    }

    public void setLlegada(Aereopuerto llegada) {
        this.llegada = llegada;
    }

    public Aereopuerto getSalida() {
        return salida;
    }

    public void setSalida(Aereopuerto salida) {
        this.salida = salida;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Aereopuerto de salida: ").append(salida.toString()).append("\n");
        sb.append("Aereopuerto de llegada: ").append(llegada.toString()).append("\n");
        return sb.toString();
    }
}
