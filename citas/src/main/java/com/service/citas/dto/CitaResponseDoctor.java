package com.service.citas.dto;

import java.time.LocalDateTime;

public class CitaResponseDoctor {
    private LocalDateTime fecha;

    public CitaResponseDoctor() {
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}
