package com.historial.dto;


import java.util.Objects;

public class PacienteRequest {

    private String nombre;
    private String apellido;
    private Integer ci;
    private String correo;
    private Integer celular;
    private String direccion;
   // private LocalDateTime fechaCreacion = LocalDateTime.now();


    public PacienteRequest() {
    }

    public Integer getCI() {
        return ci;
    }

    public void setCI(Integer ci){
        this.ci=ci;
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

    public Integer getCelular() {
        return celular;
    }

    public void setCelular(Integer telefono) {
        this.celular = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PacienteRequest that = (PacienteRequest) o;
        return Objects.equals(nombre, that.nombre) && Objects.equals(apellido, that.apellido) && Objects.equals(correo, that.correo) && Objects.equals(celular, that.celular) && Objects.equals(direccion, that.direccion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido, correo, celular, direccion);
    }
}
