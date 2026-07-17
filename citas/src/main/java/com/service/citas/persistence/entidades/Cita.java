package com.service.citas.persistence.entidades;


import jakarta.persistence.*;

import java.time.Instant;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "citas")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_cita")
    private UUID idCita;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "correo", nullable = false)
    private String correo;

    @Column(name = "ci_doctor", nullable = false)
    private Integer idDoctor;

    @Column(name = "ci_paciente", nullable = false)
    private Integer idPaciente;

    @Column(columnDefinition = "text")
    private String estado;

    @Column(name = "fecha_hora", nullable = false)
    private LocalDateTime fechaHora;

    @Column(columnDefinition = "text")
    private String motivo;

    @Column(name = "created_At", updatable = false)
    private Instant createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = Instant.now();

    }

    public UUID getIdCita() {
        return idCita;
    }

    public void setIdCita(UUID idCita) {
        this.idCita = idCita;
    }

    public Integer getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(Integer idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setIdPaciente(Integer ci){
        this.idPaciente = ci;
    }

    public Integer getIdPaciente(){
        return idPaciente;
    }

}
