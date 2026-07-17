package com.historial.service.interfaces;

import com.historial.dto.ConsultaRequest;
import com.historial.dto.ConsultaResponse;

import java.util.List;
import java.util.UUID;

public interface ConsultaMedicaService {
    ConsultaResponse crear(ConsultaRequest request);
    List<ConsultaResponse> listarPorHistorial(UUID idHistorial);
    ConsultaResponse obtener(Integer idConsulta);
    void eliminar(Integer idConsulta);
}
