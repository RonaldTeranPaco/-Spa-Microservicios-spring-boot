package com.historial.persistence.repository;

import com.historial.persistence.entidades.HorarioEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface HorarioRepository extends JpaRepository<HorarioEntidad, UUID> {
    List<HorarioEntidad> findByDoctor_Ci(Integer ci);
}
