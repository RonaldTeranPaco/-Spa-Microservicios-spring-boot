package com.historial.persistence.repository;

import com.historial.persistence.entidades.PacienteEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface PacienteRepository extends JpaRepository<PacienteEntidad, Integer> {

    @Query("SELECT p FROM PacienteEntidad p LEFT JOIN FETCH p.historialClinico")
    List<PacienteEntidad> findAllConYSinHistorial();

    @Query("SELECT p FROM PacienteEntidad p " +
            "LEFT JOIN FETCH p.historialClinico h " +
            "LEFT JOIN FETCH h.consultaMedicaList " +
            "WHERE p.ci = :ci")
    Optional<PacienteEntidad> findPacienteConHistorialAndConsultasByCi(@Param("ci") Integer ci);

}