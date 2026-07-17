package com.service.citas.persistence.repository;

import com.service.citas.persistence.entidades.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CitaRepository extends JpaRepository<Cita, UUID> {
    List<Cita> findByIdPaciente(Integer ci);
    List<Cita> findByIdDoctor(Integer ci);
}
