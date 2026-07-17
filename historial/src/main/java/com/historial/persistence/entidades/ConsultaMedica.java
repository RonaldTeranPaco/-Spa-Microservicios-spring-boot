package com.historial.persistence.entidades;


import jakarta.persistence.*;


import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "consultas_medicas")
public class ConsultaMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idConsulta;
    @ManyToOne
    @JoinColumn(name = "id_historial", nullable = false)
    private HistorialClinico historial;
    @ManyToOne
    @JoinColumn(name = "ci", nullable = false)
    private DoctorEntidad doctor;
    private LocalDateTime fechaHora;
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

    public UUID getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(UUID idConsulta) {
        this.idConsulta = idConsulta;
    }

    public HistorialClinico getHistorial() {
        return historial;
    }

    public void setHistorial(HistorialClinico historial) {
        this.historial = historial;
    }

    public DoctorEntidad getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorEntidad doctor) {
        this.doctor = doctor;
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
}
