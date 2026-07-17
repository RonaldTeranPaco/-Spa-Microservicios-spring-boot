package com.service.citas.service;

import com.service.citas.client.HistorialClient;
import com.service.citas.dto.*;
import com.service.citas.http.response.PacienteByCitaResponse;
import com.service.citas.persistence.entidades.Cita;
import com.service.citas.persistence.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@Service
public class CitaServiceImp implements CitaService {

    @Autowired
    private CitaRepository citaRepository;
    @Autowired
    private MapperCitas mapperCitas;
    @Autowired
    private ProducerService stringProducerService;
    @Autowired
    private HistorialClient historialClient;

    @Override
    public CitaResponse crearCita(CitaRequest cita) {

        Cita citaC = new Cita();
        citaC.setIdDoctor(cita.getIdDoctor());
        citaC.setNombre(cita.getNombre());
        citaC.setIdPaciente(cita.getIdPaciente());
        citaC.setCorreo(cita.getCorreo());
        citaC.setFechaHora(cita.getFechaHora());
        citaC.setMotivo(cita.getMotivo());
        citaC.setEstado("Pendiente");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String fechaString = citaC.getFechaHora().format(formatter);

        CitaRequestCorreo citaCorreo = new CitaRequestCorreo();
        citaCorreo.setFechaHora(fechaString);
        citaCorreo.setIdPaciente(citaC.getIdPaciente());
        citaCorreo.setCorreo(citaC.getCorreo());
        citaCorreo.setMotivo(citaC.getMotivo());
        citaCorreo.setNombre(citaC.getNombre());

        stringProducerService.sendMessage(citaCorreo);


        Cita guardad = citaRepository.save(citaC);


        return mapperCitas.mapToResponse(guardad);
    }

    @Override
    public CitaResponse getCita(UUID id) {
        CitaResponse res = mapperCitas.mapToResponse(citaRepository.findById(id).orElse(null));
        return res;
    }

    @Override
    public CitaResponse actualizarCita(UUID id, String estado) {
        Cita actualizar = citaRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("no existe la cita"));
        actualizar.setEstado(estado);
        return mapperCitas.mapToResponse(actualizar);
    }

    @Override
    public List<CitaResponse> listar() {
        List<CitaResponse> listar = mapperCitas.maptoResponse(citaRepository.findAll());
        return listar;
    }

    @Override
    public PacienteByCitaResponse findPacienteById(Integer ci) {
        List<Cita> cita = citaRepository.findByIdPaciente(ci);
        PacienteResponse pacienteResponse = historialClient.finPacienteByCi(ci);
        PacienteByCitaResponse res = new PacienteByCitaResponse();
        res.setCitas(mapperCitas.maptoResponse(cita));
        res.setPaciente(pacienteResponse);
        return res;
    }

    @Override
    public List<CitaResponseDoctor> listarFechaDoctor(Integer ci) {
        List<Cita> citas = citaRepository.findByIdDoctor(ci);
        List<CitaResponseDoctor> res = mapperCitas.mapToResponse(citas);
        return res;
    }
}
