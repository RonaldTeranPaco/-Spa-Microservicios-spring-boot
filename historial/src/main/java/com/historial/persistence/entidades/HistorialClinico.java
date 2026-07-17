package com.historial.persistence.entidades;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;


@Entity
@Table(name = "historiales_clinicos")
public class HistorialClinico {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_historial")
    private UUID idHistorial;
    @OneToOne
    @JoinColumn(name = "ci")
    private PacienteEntidad pacienteEntidad;
    @Column(nullable = false)
    private LocalDateTime fechaHora =LocalDateTime.now();
    private int edad;
    private char sexo;
    private String antecedentesPersonales;
    private String antecedentesFamiliales;
    private String alergias;
    @OneToMany(mappedBy = "historial", cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
    private List<ConsultaMedica> consultaMedicaList;



    public HistorialClinico() {
    }

    public UUID getIdHistorial() {
        return idHistorial;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getAntecedentesPersonales() {
        return antecedentesPersonales;
    }

    public void setAntecedentesPersonales(String antecedentesPersonales) {
        this.antecedentesPersonales = antecedentesPersonales;
    }

    public String getAntecedentesFamiliales() {
        return antecedentesFamiliales;
    }

    public void setAntecedentesFamiliales(String antecedentesFamiliales) {
        this.antecedentesFamiliales = antecedentesFamiliales;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public void setIdHistorial(UUID idHistorial) {
        this.idHistorial = idHistorial;
    }

    public PacienteEntidad getPacienteEntidad() {
        return pacienteEntidad;
    }

    public void setPacienteEntidad(PacienteEntidad pacienteEntidad) {
        this.pacienteEntidad = pacienteEntidad;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public List<ConsultaMedica> getConsultaMedicaList() {
        return consultaMedicaList;
    }

    public void setConsultaMedicaList(List<ConsultaMedica> consultaMedicaList) {
        this.consultaMedicaList = consultaMedicaList;
    }

    @Override
    public String toString() {
        return "HistorialClinico{" +
                "idHistorial=" + idHistorial +
                ", pacienteEntidad=" + pacienteEntidad +
                ", fechaHora=" + fechaHora +
                ", edad=" + edad +
                ", sexo=" + sexo +
                ", antecedentesPersonales='" + antecedentesPersonales + '\'' +
                ", antecedentesFamiliales='" + antecedentesFamiliales + '\'' +
                ", alergias='" + alergias + '\'' +
                '}';
    }
}