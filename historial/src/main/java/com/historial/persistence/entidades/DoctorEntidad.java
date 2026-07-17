package com.historial.persistence.entidades;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "doctores")
public class DoctorEntidad {

    @Id
    private Integer ci;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String apellido;
    @Column(columnDefinition = "TEXT")
    private String image;
    @Column(nullable = false)
    private String especialidad;
    @Column(nullable = false)
    private String correo;
    @Column(nullable = false)
    private String telefono;
    private LocalDateTime fechaCreacion = LocalDateTime.now();
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HorarioEntidad> horarioEntidads;

    public Integer getCI() {
        return ci;
    }

    public void setCI(Integer idDoctor) {
        this.ci = idDoctor;
    }

    public String getNombre() {
        return nombre;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public List<HorarioEntidad> getHorarioEntidads() {
        return horarioEntidads;
    }

    public void setHorarioEntidads(List<HorarioEntidad> horarioEntidads) {
        this.horarioEntidads = horarioEntidads;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}