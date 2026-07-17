package com.service.citas.service;

import com.service.citas.dto.CitaResponse;
import com.service.citas.dto.CitaResponseDoctor;
import com.service.citas.persistence.entidades.Cita;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapperCitas {
    public CitaResponse mapToResponse(Cita cita){
        CitaResponse citaResponse = new CitaResponse();
        citaResponse.setIdCita(cita.getIdCita());
        citaResponse.setNombre(cita.getNombre());
        citaResponse.setCorreo(cita.getCorreo());
        citaResponse.setIdPaciente(cita.getIdPaciente());
        citaResponse.setIdDoctor(cita.getIdDoctor());
        citaResponse.setEstado(cita.getEstado());
        citaResponse.setMotivo(cita.getMotivo());
        citaResponse.setFechaHora(cita.getFechaHora());
        citaResponse.setCreatedAt(cita.getCreatedAt());

        return citaResponse;
    }

    public List<CitaResponse> maptoResponse(List<Cita> lista){
        List<CitaResponse> res = new ArrayList<>();
        for(Cita cita: lista){
            CitaResponse citaRes = new CitaResponse();
            citaRes.setCorreo(cita.getCorreo());
            citaRes.setNombre(cita.getNombre());
            citaRes.setFechaHora(cita.getFechaHora());
            citaRes.setCreatedAt(cita.getCreatedAt());
            citaRes.setEstado(cita.getEstado());
            citaRes.setMotivo(cita.getMotivo());
            citaRes.setIdPaciente(cita.getIdPaciente());
            citaRes.setIdDoctor(cita.getIdDoctor());
            citaRes.setIdCita(cita.getIdCita());
            res.add(citaRes);
        }
        return  res;
    }

    public List<CitaResponseDoctor> mapToResponse(List<Cita> lista){
        List<CitaResponseDoctor> res = new ArrayList<>();
        for(Cita c: lista){
            CitaResponseDoctor cita = new CitaResponseDoctor();
            cita.setFecha(c.getFechaHora());
            res.add(cita);
        }
        return res;
    }
}
