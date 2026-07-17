package com.historial.dto;

import java.time.LocalTime;

public class HorarioRequest {

    private String diaSemana;
    private LocalTime horaIni;
    private LocalTime horaFin;
    private Integer ci;

    public HorarioRequest() {
    }

    public Integer getCi() {
        return ci;
    }

    public void setCi(Integer ci) {
        this.ci = ci;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String dia) {
        this.diaSemana = dia;
    }

    public LocalTime getHoraIni() {
        return horaIni;
    }

    public void setHoraIni(LocalTime horaIni) {
        this.horaIni = horaIni;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }
}
