package com.historial.service;


import com.historial.dto.HorarioRequest;
import com.historial.dto.HorarioResponse;

import com.historial.dto.HorariosResponse;
import com.historial.persistence.entidades.DoctorEntidad;
import com.historial.persistence.entidades.HorarioEntidad;
import com.historial.persistence.repository.DoctorRepository;
import com.historial.persistence.repository.HorarioRepository;
import com.historial.service.interfaces.HorarioService;
import com.historial.service.mapper.MapperHorario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class HorarioServiceImp implements HorarioService {

    @Autowired
    private HorarioRepository horarioRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private MapperHorario mapperHorario;

    @Override
    public HorarioResponse crearHorario(HorarioRequest horario, Integer id) {
        DoctorEntidad doctor = doctorRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("doctor no encontrado"));

        HorarioEntidad horarioEntidad = mapperHorario.toEntity(horario,doctor);
        return mapperHorario.toResponse(horarioRepository.save(horarioEntidad));
    }

    @Override
    public void crearHorarios(List<HorarioRequest> horarios, Integer id){
        DoctorEntidad doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("doctor no encontrado"));
        HorarioEntidad horarioEntidad;
        for(HorarioRequest horario: horarios){
            horarioEntidad = mapperHorario.toEntity(horario,doctor);
            horarioRepository.save(horarioEntidad);
        }


    }

    @Override
    public List<HorarioResponse> buscarIdDoctor(Integer id) {

        List<HorarioResponse> res =mapperHorario.toResponse(horarioRepository.findByDoctor_Ci(id));
        return res;
    }

    @Override
    public List<HorariosResponse> buscarIdDoctorHorarios(Integer id) {
        List<HorarioEntidad> horarios = horarioRepository.findByDoctor_Ci(id);
        List<HorariosResponse> res = new ArrayList<>();
        for(HorarioEntidad h: horarios){
            HorariosResponse horariosResponse = new HorariosResponse();
            horariosResponse.setDia(h.getDiaSemana());
            horariosResponse.setHorarios(crearIntervalosHrs(h.getHoraIni(),h.getHoraFin()));
            horariosResponse.setCi(h.getDoctor().getCI());
            res.add(horariosResponse);
        }

        return res;
    }

    private List<LocalTime> crearIntervalosHrs(LocalTime ini,LocalTime fin){
        List<LocalTime> intervalos = new ArrayList<>();
        LocalTime hrActual = ini;
        while(hrActual.isBefore(fin)){
            intervalos.add(hrActual);
            hrActual = hrActual.plusMinutes(30);
        }
        return intervalos;
    }
}
