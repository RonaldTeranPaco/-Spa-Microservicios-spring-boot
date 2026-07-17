package com.historial.persistence.entidades;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "pacientes")
public class PacienteEntidad {


    @Id
    @Column(nullable = false,unique = true)
    private Integer ci;
    private String nombre;
    private String apellido;
    private String correo;
    private Integer telefono;
    @OneToOne(mappedBy = "pacienteEntidad", cascade = CascadeType.ALL)
    private HistorialClinico historialClinico;
    private String direccion;
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    public HistorialClinico getHistorialClinico() {
        return historialClinico;
    }

    public void setHistorialClinico(HistorialClinico historialClinico) {
        this.historialClinico = historialClinico;
    }

    public Integer getCI() {
        return ci;
    }

    public void setCI(Integer CI) {
        this.ci = CI;
    }

    public String getNombre() {
        return nombre;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }


    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
