package com.service.notificaciones.dto;

import java.lang.String;

public class NotificacionMessage {

    private String correo;
    private String nombre;
    private Integer edad;
    private String motivo;
    private String fechaHora;

    public NotificacionMessage() {
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fecha) {
        this.fechaHora = fecha;
    }

    @Override
    public String toString() {
        return "NotificacionMessage{" +
                "correo2='" + correo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", motivo='" + motivo + '\'' +
                ", fecha='" + fechaHora + '\'' +
                '}';
    }
}
