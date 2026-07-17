package com.historial.service.interfaces;

import com.historial.dto.PacienteHistorialConsultaResponse;
import com.historial.dto.PacienteHistorialResponse;
import com.historial.dto.PacienteRequest;
import com.historial.dto.PacienteResponse;

import java.util.List;

public interface PacienteService {

    List<PacienteResponse> getPacientes();

    PacienteResponse savePaciente(PacienteRequest paciente);

    PacienteResponse findById(Integer id);

    void delete(Integer id);

    List<PacienteHistorialResponse> obtenerPacienteConHistorialSinHistorial();

    PacienteHistorialConsultaResponse buscarPacienteConHistorialYConsltaPorCi(Integer ci);
}
