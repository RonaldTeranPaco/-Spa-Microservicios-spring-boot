package com.historial.dto;




public class PacienteHistorialResponse {

    private String nombre;
    private String apellido;
    private Integer CI;
    private String correo;
    private Integer telefono;
    private String direccion;

    private boolean tieneHistorial;

    public PacienteHistorialResponse() {
    }

    public boolean getTieneHistorial(){
        return tieneHistorial;
    }

    public void setTieneHistorial(boolean tieneHistorial){
        this.tieneHistorial = tieneHistorial;
    }

    public Integer getCI() {
        return CI;
    }

    public void setCI(Integer CI) {
        this.CI = CI;
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
}
