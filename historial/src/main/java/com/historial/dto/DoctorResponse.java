package com.historial.dto;


import java.time.LocalDateTime;
import java.util.Objects;

public class DoctorResponse {


    private String nombre;
    private String apellido;
    private String especialidad;
    private Integer ci;
    private String image;
    private String correo;
    private String telefono;
    private LocalDateTime fechaCreacion;
    private boolean tieneHorarios;

    public DoctorResponse(){

    }

    public Integer getCI() {
        return ci;
    }

    public void setCI(Integer CI) {
        this.ci = CI;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoctorResponse that = (DoctorResponse) o;
        return Objects.equals(nombre, that.nombre) && Objects.equals(apellido, that.apellido) && Objects.equals(especialidad, that.especialidad) && Objects.equals(correo, that.correo) && Objects.equals(telefono, that.telefono) && Objects.equals(fechaCreacion, that.fechaCreacion);
    }

    public boolean isTieneHorarios() {
        return tieneHorarios;
    }

    public void setTieneHorarios(boolean tieneHorarios) {
        this.tieneHorarios = tieneHorarios;
    }

    @Override
    public int hashCode() {
        return Objects.hash( nombre, apellido, especialidad, correo, telefono, fechaCreacion);
    }
}
