package com.historial.service.mapper;

import com.historial.dto.DoctorRequest;

import com.historial.dto.DoctorResponse;
import com.historial.persistence.entidades.DoctorEntidad;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapperDoctor {
    public DoctorResponse convertirDTO(DoctorEntidad p){

        DoctorResponse responseDTO = new DoctorResponse();

        responseDTO.setNombre(p.getNombre());
        responseDTO.setApellido(p.getApellido());
        responseDTO.setCI(p.getCI());
        responseDTO.setCorreo(p.getCorreo());
        responseDTO.setImage(p.getImage());
        responseDTO.setTelefono(p.getTelefono());
        responseDTO.setEspecialidad(p.getEspecialidad());
        responseDTO.setFechaCreacion(p.getFechaCreacion());
        return  responseDTO;
    }

    public DoctorEntidad convertirDAO(DoctorRequest p){

        DoctorEntidad responseDAO = new DoctorEntidad();
        responseDAO.setNombre(p.getNombre());
        responseDAO.setApellido(p.getApellido());
        responseDAO.setCI(p.getCI());
        responseDAO.setImage(p.getImage());
        responseDAO.setCorreo(p.getCorreo());
        responseDAO.setTelefono(p.getTelefono());
        responseDAO.setEspecialidad(p.getEspecialidad());
        return  responseDAO;
    }

    public List<DoctorResponse> convertirListaDTO(List<DoctorEntidad> doctorE){
        List<DoctorResponse> doctorResponse = new ArrayList<>();
        for (DoctorEntidad doctorEntidad : doctorE){
            DoctorResponse responseDTO = new DoctorResponse();
            responseDTO.setNombre(doctorEntidad.getNombre());
            responseDTO.setApellido(doctorEntidad.getApellido());
            responseDTO.setCI(doctorEntidad.getCI());
            responseDTO.setTieneHorarios(doctorEntidad.getHorarioEntidads().equals(null)? true : false);
            responseDTO.setImage(doctorEntidad.getImage());
            responseDTO.setCorreo(doctorEntidad.getCorreo());
            responseDTO.setTelefono(doctorEntidad.getTelefono());
            responseDTO.setEspecialidad(doctorEntidad.getEspecialidad());
            responseDTO.setFechaCreacion(doctorEntidad.getFechaCreacion());
            doctorResponse.add(responseDTO);
        }
        return doctorResponse;
    }
}
