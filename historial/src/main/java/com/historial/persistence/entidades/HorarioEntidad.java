package com.historial.persistence.entidades;

import jakarta.persistence.*;


import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "horarios")
public class HorarioEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idHorario;
    @Column(nullable = false)
    private String diaSemana;
    @Column(nullable = false)
    private LocalTime horaIni;
    @Column(nullable = false)
    private LocalTime horaFin;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ci", nullable = false)
    private DoctorEntidad doctor;

    public UUID getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(UUID idHorario) {
        this.idHorario = idHorario;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
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

    public DoctorEntidad getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorEntidad doctor) {
        this.doctor = doctor;
    }
}
