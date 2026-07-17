package com.historial.service.mapper;


import com.historial.dto.HorarioRequest;
import com.historial.dto.HorarioResponse;
import com.historial.persistence.entidades.DoctorEntidad;
import com.historial.persistence.entidades.HorarioEntidad;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapperHorario {

    public HorarioEntidad toEntity(HorarioRequest horario, DoctorEntidad doctor){

        HorarioEntidad horarioEntidad = new HorarioEntidad();
        horarioEntidad.setDiaSemana(horario.getDiaSemana());
        horarioEntidad.setHoraIni(horario.getHoraIni());
        horarioEntidad.setHoraFin(horario.getHoraFin());
        horarioEntidad.setDoctor(doctor);

        return horarioEntidad;
    }

    public HorarioResponse toResponse(HorarioEntidad horario){
        HorarioResponse res =new HorarioResponse();
        res.setDia(horario.getDiaSemana());
        res.setCi(horario.getDoctor().getCI());
        res.setHoraIni(horario.getHoraIni());
        res.setHoraFin(horario.getHoraFin());
        return res;
    }

    public List<HorarioResponse> toResponse(List<HorarioEntidad> horario){
        List<HorarioResponse> res= new ArrayList<>();
        for (HorarioEntidad h: horario){
            HorarioResponse response = new HorarioResponse();
            response.setDia(h.getDiaSemana());
            response.setCi(h.getDoctor().getCI());
            response.setHoraIni(h.getHoraIni());
            response.setHoraFin(h.getHoraFin());
            res.add(response);
        }
        return res;
    }
}
