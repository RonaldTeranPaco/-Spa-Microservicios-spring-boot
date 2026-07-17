package com.historial.service;


import com.historial.dto.PacienteHistorialConsultaResponse;
import com.historial.dto.PacienteHistorialResponse;
import com.historial.dto.PacienteRequest;
import com.historial.dto.PacienteResponse;
import com.historial.service.interfaces.PacienteService;
import com.historial.service.mapper.MapperPaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.historial.persistence.entidades.PacienteEntidad;
import com.historial.persistence.repository.PacienteRepository;


@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository repository;
    @Autowired(required = true)
    private MapperPaciente mapperPaciente;

    @Override
    public List<PacienteResponse> getPacientes() {

        List<PacienteResponse> pacientes = mapperPaciente.convertirListaDTO(repository.findAll());

        return pacientes;
    }

    @Override
    public PacienteResponse savePaciente(PacienteRequest p) {

        PacienteEntidad pacienteEntidad = mapperPaciente.convertirDAO(p);
        repository.save(pacienteEntidad);

        PacienteResponse pacienteResponse = mapperPaciente.convertirDTO(pacienteEntidad);

        return pacienteResponse;
    }

    @Override
    public PacienteResponse findById(Integer id) {
        PacienteResponse pacienteResponse = mapperPaciente.convertirDTO(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("paciente no encontrado")));
        return pacienteResponse;
    }

    public PacienteEntidad findByIdEntidad(Integer id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) { repository.deleteById(id); }

    @Override
    public List<PacienteHistorialResponse> obtenerPacienteConHistorialSinHistorial() {
        List<PacienteEntidad> lista = repository.findAllConYSinHistorial();
        List<PacienteHistorialResponse> res= new ArrayList<>();
        boolean tieneHistorial;
        for (PacienteEntidad p : lista){
            PacienteHistorialResponse pacienteHistorial = new PacienteHistorialResponse();
            pacienteHistorial.setNombre(p.getNombre());
            pacienteHistorial.setApellido(p.getApellido());
            pacienteHistorial.setCI(p.getCI());
            pacienteHistorial.setTelefono(p.getTelefono());
            pacienteHistorial.setCorreo(p.getCorreo());
            pacienteHistorial.setDireccion(p.getDireccion());
            tieneHistorial = p.getHistorialClinico() == null? false : true;
            pacienteHistorial.setTieneHistorial(tieneHistorial);
            res.add(pacienteHistorial);
        }

        return res;
    }

    @Override
    public PacienteHistorialConsultaResponse buscarPacienteConHistorialYConsltaPorCi(Integer ci) {
        PacienteEntidad resConsulta=repository.findPacienteConHistorialAndConsultasByCi(ci)
                .orElseThrow(()-> new RuntimeException("paciente no encontrado"));
        PacienteHistorialConsultaResponse response = mapperPaciente.convertirConsultaResponse(resConsulta);
        return response;
    }
}