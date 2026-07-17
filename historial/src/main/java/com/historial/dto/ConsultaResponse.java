package com.historial.dto;

import java.time.LocalDate;

import java.util.UUID;

public class ConsultaResponse {
    private UUID idConsulta;
    private String doctor;
    private LocalDate fechaHora;
    private String diagnostico;
    private String tratamiento;
    private String notas;
    private String factoresExternos;
    private String estadoGeneral;
    private String duracionLesionCutanea;
    private String tipoLesion;
    private String coloracionPielyLesion;
    private String palpacionLesion;
    private String disposicionLesion;
    private String distribucionLesion;

    public ConsultaResponse() {
    }

    public String getFactoresExternos() {
        return factoresExternos;
    }

    public void setFactoresExternos(String factoresExternos) {
        this.factoresExternos = factoresExternos;
    }

    public String getEstadoGeneral() {
        return estadoGeneral;
    }

    public void setEstadoGeneral(String estadoGeneral) {
        this.estadoGeneral = estadoGeneral;
    }

    public String getDuracionLesionCutanea() {
        return duracionLesionCutanea;
    }

    public void setDuracionLesionCutanea(String duracionLesionCutanea) {
        this.duracionLesionCutanea = duracionLesionCutanea;
    }

    public String getTipoLesion() {
        return tipoLesion;
    }

    public void setTipoLesion(String tipoLesion) {
        this.tipoLesion = tipoLesion;
    }

    public String getColoracionPielyLesion() {
        return coloracionPielyLesion;
    }

    public void setColoracionPielyLesion(String coloracionPielyLesion) {
        this.coloracionPielyLesion = coloracionPielyLesion;
    }

    public String getPalpacionLesion() {
        return palpacionLesion;
    }

    public void setPalpacionLesion(String palpacionLesion) {
        this.palpacionLesion = palpacionLesion;
    }

    public String getDisposicionLesion() {
        return disposicionLesion;
    }

    public void setDisposicionLesion(String disposicionLesion) {
        this.disposicionLesion = disposicionLesion;
    }

    public String getDistribucionLesion() {
        return distribucionLesion;
    }

    public void setDistribucionLesion(String distribucionLesion) {
        this.distribucionLesion = distribucionLesion;
    }

    public UUID getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(UUID idConsulta) {
        this.idConsulta = idConsulta;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public LocalDate getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDate fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }
}
