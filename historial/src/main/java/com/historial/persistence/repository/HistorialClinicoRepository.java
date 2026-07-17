package com.historial.persistence.repository;

import com.historial.persistence.entidades.HistorialClinico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;


public interface HistorialClinicoRepository extends JpaRepository<HistorialClinico, UUID> {
    HistorialClinico findBypacienteEntidad_ci(Integer idPaciente);
}