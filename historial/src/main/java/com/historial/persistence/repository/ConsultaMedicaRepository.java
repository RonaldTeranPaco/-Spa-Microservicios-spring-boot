package com.historial.persistence.repository;

import com.historial.persistence.entidades.ConsultaMedica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ConsultaMedicaRepository extends JpaRepository<ConsultaMedica,UUID> {
    List<ConsultaMedica> findByhistorial_IdHistorial(UUID idHistorial);
}
