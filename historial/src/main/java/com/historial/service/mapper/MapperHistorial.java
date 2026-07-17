package com.historial.service.mapper;

import com.historial.dto.HistorialResponse;
import com.historial.persistence.entidades.HistorialClinico;
import com.historial.service.DoctorServiceImp;
import com.historial.service.PacienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapperHistorial {

    @Autowired
    private PacienteServiceImpl pacienteService;
    @Autowired
    private DoctorServiceImp doctorService;

   public HistorialResponse response(HistorialClinico historialRequest){
       System.out.println("mapper response"+ historialRequest.getIdHistorial());
        HistorialResponse historialEntidad = new HistorialResponse();
        historialEntidad.setIdHistorial(historialRequest.getIdHistorial());
        historialEntidad.setPacienteNombre(historialRequest.getPacienteEntidad().getNombre());
        historialEntidad.setFechaCreacion(historialRequest.getFechaHora());
        historialEntidad.setAlergias(historialRequest.getAlergias());
        historialEntidad.setAntecedentesFamiliares(historialRequest.getAntecedentesFamiliales());
        historialEntidad.setAntecedentesPersonales(historialRequest.getAntecedentesPersonales());
        historialEntidad.setEdad(historialRequest.getEdad());
        historialEntidad.setSexo(historialRequest.getSexo());
        historialEntidad.setCi(historialRequest.getPacienteEntidad().getCI());
        return historialEntidad;
    }

    public List<HistorialResponse> response(List<HistorialClinico> historiales){
       List<HistorialResponse> historialResponses = new ArrayList<>();
       for (HistorialClinico res: historiales){
            HistorialResponse historialResponse = new HistorialResponse();
            historialResponse.setIdHistorial(res.getIdHistorial());
            historialResponse.setFechaCreacion(res.getFechaHora());
            historialResponse.setPacienteNombre(res.getPacienteEntidad().getNombre());
            historialResponse.setSexo(res.getSexo());
            historialResponse.setCi(res.getPacienteEntidad().getCI());
            historialResponse.setEdad(res.getEdad());
            historialResponse.setAlergias(res.getAlergias());
            historialResponse.setAntecedentesPersonales(res.getAntecedentesPersonales());
            historialResponse.setAntecedentesFamiliares(res.getAntecedentesFamiliales());
            historialResponses.add(historialResponse);
        }

        return historialResponses;
    }
}
