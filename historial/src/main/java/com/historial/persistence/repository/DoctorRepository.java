package com.historial.persistence.repository;

import com.historial.persistence.entidades.DoctorEntidad;
import org.springframework.data.jpa.repository.JpaRepository;



public interface DoctorRepository extends JpaRepository<DoctorEntidad, Integer> {
}