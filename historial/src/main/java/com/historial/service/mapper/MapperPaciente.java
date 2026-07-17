package com.historial.service.mapper;

import com.historial.dto.ConsultaResponse;
import com.historial.dto.PacienteHistorialConsultaResponse;
import com.historial.dto.PacienteRequest;
import com.historial.dto.PacienteResponse;
import com.historial.persistence.entidades.ConsultaMedica;
import com.historial.persistence.entidades.PacienteEntidad;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapperPaciente {
    public PacienteResponse convertirDTO(PacienteEntidad p){

        PacienteResponse responseDTO = new PacienteResponse();
        responseDTO.setNombre(p.getNombre());
        responseDTO.setApellido(p.getApellido());
        responseDTO.setCI(p.getCI());
        responseDTO.setCorreo(p.getCorreo());
        responseDTO.setTelefono(p.getTelefono());
        responseDTO.setDireccion(p.getDireccion());
        responseDTO.setFechaCreacion(p.getFechaCreacion());
        return  responseDTO;
    }

    public PacienteEntidad convertirDAO(PacienteRequest p){

        PacienteEntidad responseDAO = new PacienteEntidad();
        responseDAO.setNombre(p.getNombre());
        responseDAO.setApellido(p.getApellido());
        responseDAO.setCI(p.getCI());
        responseDAO.setCorreo(p.getCorreo());
        responseDAO.setTelefono(p.getCelular());
        responseDAO.setDireccion(p.getDireccion());
        return  responseDAO;
    }

    public List<PacienteResponse> convertirListaDTO(List<PacienteEntidad> pacienteE){
        List<PacienteResponse> pacientesResponse = new ArrayList<>();
        for (PacienteEntidad pacienteEntidad : pacienteE){
            PacienteResponse responseDTO = new PacienteResponse();
            responseDTO.setNombre(pacienteEntidad.getNombre());
            responseDTO.setApellido(pacienteEntidad.getApellido());
            responseDTO.setCI(pacienteEntidad.getCI());
            responseDTO.setCorreo(pacienteEntidad.getCorreo());
            responseDTO.setTelefono(pacienteEntidad.getTelefono());
            responseDTO.setDireccion(pacienteEntidad.getDireccion());
            responseDTO.setFechaCreacion(pacienteEntidad.getFechaCreacion());
            pacientesResponse.add(responseDTO);
        }
        return pacientesResponse;
    }

    public PacienteHistorialConsultaResponse convertirConsultaResponse(PacienteEntidad resConsulta){
        PacienteHistorialConsultaResponse response=new PacienteHistorialConsultaResponse();
        response.setNombre(resConsulta.getNombre());
        response.setApellido(resConsulta.getApellido());
        response.setCi(resConsulta.getCI());
        response.setIdHistorial(resConsulta.getHistorialClinico().getIdHistorial());
        response.setCorreo(resConsulta.getCorreo());
        response.setTelefono(resConsulta.getTelefono());
        response.setDireccion(resConsulta.getDireccion());
        response.setFechaCreacion(resConsulta.getFechaCreacion());
        response.setSexo(resConsulta.getHistorialClinico().getSexo());
        response.setEdad(resConsulta.getHistorialClinico().getEdad());
        response.setAntecedentesPersonales(resConsulta.getHistorialClinico().getAntecedentesPersonales());
        response.setAntecedentesFamiliares(resConsulta.getHistorialClinico().getAntecedentesFamiliales());
        response.setAlergias(resConsulta.getHistorialClinico().getAlergias());
        response.setConsultas(mappearConsultas(resConsulta.getHistorialClinico().getConsultaMedicaList()));
        return response;
    }

    private List<ConsultaResponse> mappearConsultas(List<ConsultaMedica> consultas){
        List<ConsultaResponse> res = new ArrayList<>();
        for(ConsultaMedica consulta:consultas){
            ConsultaResponse consultaRes = new ConsultaResponse();
            consultaRes.setIdConsulta(consulta.getIdConsulta());
            consultaRes.setDoctor(consulta.getDoctor().getNombre()+" "+ consulta.getDoctor().getApellido());
            consultaRes.setFechaHora(consulta.getFechaHora().toLocalDate());
            consultaRes.setDiagnostico(consulta.getDiagnostico());
            consultaRes.setTratamiento(consulta.getTratamiento());
            consultaRes.setNotas(consulta.getNotas());
            consultaRes.setTratamiento(consulta.getTratamiento());
            consultaRes.setFactoresExternos(consulta.getFactoresExternos());
            consultaRes.setEstadoGeneral(consulta.getEstadoGeneral());
            consultaRes.setDuracionLesionCutanea(consulta.getDuracionLesionCutanea());
            consultaRes.setTipoLesion(consulta.getTipoLesion());
            consultaRes.setColoracionPielyLesion(consulta.getColoracionPielyLesion());
            consultaRes.setPalpacionLesion(consulta.getPalpacionLesion());
            consultaRes.setDisposicionLesion(consulta.getDisposicionLesion());
            consultaRes.setDistribucionLesion(consulta.getDistribucionLesion());
            res.add(consultaRes);
        }
        return res;
    }
}
