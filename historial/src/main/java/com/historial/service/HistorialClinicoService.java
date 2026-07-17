package com.historial.service;

import com.historial.dto.HistorialRequest;
import com.historial.dto.HistorialResponse;
import com.historial.persistence.entidades.PacienteEntidad;
import com.historial.persistence.repository.PacienteRepository;
import com.historial.service.interfaces.HistorialService;
import com.historial.service.mapper.MapperHistorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.historial.persistence.repository.HistorialClinicoRepository;
import com.historial.persistence.entidades.HistorialClinico;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class HistorialClinicoService implements HistorialService {

    @Autowired
    private HistorialClinicoRepository historialRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private MapperHistorial mapperHistorial;

    public HistorialResponse save(HistorialRequest request) {
        PacienteEntidad paciente = pacienteRepository.findById(request.getIdPaciente())
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));

        HistorialClinico historial = new HistorialClinico();
        historial.setPacienteEntidad(paciente);
        //historial.setFechaHora(LocalDateTime.now());
        historial.setAlergias(request.getAlergias());
        historial.setEdad(request.getEdad());
        historial.setAntecedentesFamiliales(request.getAntecedentesFamiliares());
        historial.setAntecedentesPersonales(request.getAntecedentesPersonales());
        historial.setSexo(request.getSexo());
        historial = historialRepository.save(historial);

        return mapperHistorial.response(historial);
    }

    @Override
    public HistorialResponse obtenerPorPaciente(Integer idPaciente) {

        HistorialClinico historialClinico = historialRepository.findBypacienteEntidad_ci(idPaciente);
        System.out.println("serivice"+historialClinico.getAlergias());
        return mapperHistorial.response(historialClinico);
    }

    @Override
    public List<HistorialResponse> listar() {
        List<HistorialClinico> historialClinicos = historialRepository.findAll();
        System.out.println(historialClinicos.get(0).getPacienteEntidad().getNombre());
        return mapperHistorial.response(historialClinicos);
    }
}