package com.historial.service.interfaces;

import com.historial.dto.HistorialRequest;
import com.historial.dto.HistorialResponse;

import java.util.List;

public interface HistorialService {
    HistorialResponse save(HistorialRequest request);
    HistorialResponse obtenerPorPaciente(Integer idPaciente);
    List<HistorialResponse> listar();
}
