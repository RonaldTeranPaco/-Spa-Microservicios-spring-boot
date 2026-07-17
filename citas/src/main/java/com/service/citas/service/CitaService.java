package com.service.citas.service;

import com.service.citas.dto.CitaRequest;
import com.service.citas.dto.CitaResponse;
import com.service.citas.dto.CitaResponseDoctor;
import com.service.citas.http.response.PacienteByCitaResponse;

import java.util.List;
import java.util.UUID;

public interface CitaService {

     CitaResponse crearCita(CitaRequest cita);

     CitaResponse getCita(UUID id);

     CitaResponse actualizarCita(UUID id, String estado);

    List<CitaResponse> listar();

    PacienteByCitaResponse findPacienteById(Integer ci);

    List<CitaResponseDoctor> listarFechaDoctor(Integer ci);
}
