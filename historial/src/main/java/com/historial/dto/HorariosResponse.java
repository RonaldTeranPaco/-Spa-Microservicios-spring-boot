package com.historial.dto;

import java.time.LocalTime;
import java.util.List;

public class HorariosResponse {
    private String dia;
    private List<LocalTime> horarios;
    private Integer ci;

    public HorariosResponse() {
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public List<LocalTime> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<LocalTime> horarios) {
        this.horarios = horarios;
    }

    public Integer getCi() {
        return ci;
    }

    public void setCi(Integer ci) {
        this.ci = ci;
    }
}
