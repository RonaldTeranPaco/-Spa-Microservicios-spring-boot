package com.historial.dto;

import java.time.LocalDateTime;
import java.util.UUID;


public class ConsultaRequest {
    private UUID idHistorial;
    private Integer idDoctor;
    private LocalDateTime fechaHora;
    private String diagnostico;
    private String tratamiento;
    private String notas;
    private String factoresExternos;
    private String estadoGeneral;
    private String duracionLesionCutanea;
    private String tipoLesion;
    private String coloracionPielLesion;
    private String palpacionLesion;
    private String disposicionLesion;
    private String distribucionLesion;

    public ConsultaRequest() {
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

    public void setDuracionLesionCutanea(String estadoPiel) {
        this.duracionLesionCutanea = estadoPiel;
    }

    public String getTipoLesion() {
        return tipoLesion;
    }

    public void setTipoLesion(String tipoLesion) {
        this.tipoLesion = tipoLesion;
    }

    public String getColoracionPielLesion() {
        return coloracionPielLesion;
    }

    public void setColoracionPielLesion(String coloracionPielLesion) {
        this.coloracionPielLesion = coloracionPielLesion;
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

    public UUID getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(UUID idHistorial) {
        this.idHistorial = idHistorial;
    }

    public Integer getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(Integer idDoctor) {
        this.idDoctor = idDoctor;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
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

