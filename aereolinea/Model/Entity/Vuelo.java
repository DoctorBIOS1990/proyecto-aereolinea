package com.springboot.aereolinea.Model.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "vuelo")
public class Vuelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVuelo;
    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date Fecha;

    @ManyToOne
    @JoinColumn(name = "aereopuerto_salida")
    private Aereopuerto llegada;

    @ManyToOne
    @JoinColumn(name = "aereopuerto_llegada")
    private Aereopuerto salida;

    @JsonIgnore
    @OneToMany(mappedBy = "vuelo",  fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Reserva> reservas;

    @JsonIgnore
    @OneToMany(mappedBy = "vuelo",  fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Tramo> tramos;

    public List<Tramo> getTramos() {
        return tramos;
    }

    public void setTramos(List<Tramo> tramos) {
        this.tramos = tramos;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public Long getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(Long idVuelo) {
        this.idVuelo = idVuelo;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date fecha) {
        Fecha = fecha;
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
}

