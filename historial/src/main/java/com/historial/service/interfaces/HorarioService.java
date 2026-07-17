package com.historial.service.interfaces;

import com.historial.dto.HorarioRequest;
import com.historial.dto.HorarioResponse;
import com.historial.dto.HorariosResponse;

import java.util.List;

public interface HorarioService {

    HorarioResponse crearHorario(HorarioRequest horario,Integer id);

    List<HorarioResponse> buscarIdDoctor(Integer id);

    List<HorariosResponse> buscarIdDoctorHorarios(Integer id);

    void crearHorarios(List<HorarioRequest> horarios,Integer id);
}
