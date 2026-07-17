package com.historial.service.mapper;

import com.historial.dto.ConsultaResponse;
import com.historial.persistence.entidades.ConsultaMedica;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapperConsulta {
    public ConsultaResponse response(ConsultaMedica c) {
        ConsultaResponse resp = new ConsultaResponse();
        resp.setIdConsulta(c.getIdConsulta());
        resp.setDoctor(c.getDoctor().getNombre() + " " + c.getDoctor().getApellido());
        resp.setFechaHora(c.getFechaHora().toLocalDate());
        resp.setDiagnostico(c.getDiagnostico());
        resp.setTratamiento(c.getTratamiento());
        resp.setNotas(c.getNotas());
        resp.setFactoresExternos(c.getFactoresExternos());
        resp.setEstadoGeneral(c.getEstadoGeneral());
        resp.setDuracionLesionCutanea(c.getDuracionLesionCutanea());
        resp.setTipoLesion(c.getTipoLesion());
        resp.setColoracionPielyLesion(c.getColoracionPielyLesion());
        resp.setPalpacionLesion(c.getPalpacionLesion());
        resp.setDisposicionLesion(c.getDisposicionLesion());
        resp.setDistribucionLesion(c.getDistribucionLesion());
        return resp;
    }

    public List<ConsultaResponse> response(List<ConsultaMedica> consultas){
        List<ConsultaResponse> consultaResponses = new ArrayList<>();

        for(ConsultaMedica c:consultas){
            ConsultaResponse resp = new ConsultaResponse();
            resp.setIdConsulta(c.getIdConsulta());
            resp.setDoctor(c.getDoctor().getNombre() + " " + c.getDoctor().getApellido());
            resp.setFechaHora(c.getFechaHora().toLocalDate());
            resp.setDiagnostico(c.getDiagnostico());
            resp.setTratamiento(c.getTratamiento());
            resp.setNotas(c.getNotas());
            resp.setFactoresExternos(c.getFactoresExternos());
            resp.setEstadoGeneral(c.getEstadoGeneral());
            resp.setDuracionLesionCutanea(c.getDuracionLesionCutanea());
            resp.setTipoLesion(c.getTipoLesion());
            resp.setColoracionPielyLesion(c.getColoracionPielyLesion());
            resp.setPalpacionLesion(c.getPalpacionLesion());
            resp.setDisposicionLesion(c.getDisposicionLesion());
            resp.setDistribucionLesion(c.getDistribucionLesion());
            consultaResponses.add(resp);
        }

        return consultaResponses;
    }
}
