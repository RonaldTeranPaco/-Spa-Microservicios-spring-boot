package com.historial.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.historial.dto.HorarioRequest;
import com.historial.dto.HorarioResponse;
import com.historial.service.interfaces.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/horario")
public class HorarioController {

    @Autowired
    private HorarioService horarioService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/{id}")
    public ResponseEntity<?> crearHorario(@RequestBody HorarioRequest horario, @PathVariable Integer id){
        HorarioResponse response = horarioService.crearHorario(horario, id);

        try {
            System.out.println("JSON generado: " + objectMapper.writeValueAsString(response));
            System.out.println("Modulos registrados: " + objectMapper.getRegisteredModuleIds());
            System.out.println("WRITE_DATES_AS_TIMESTAMPS: " +
                    objectMapper.isEnabled(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{ci}")
    public ResponseEntity<?> getHorariosByCi(@PathVariable Integer ci){
        return ResponseEntity.ok(horarioService.buscarIdDoctorHorarios(ci));
    }

    @PostMapping("/crearHorarios/{id}")
    public ResponseEntity<?> crearHorarios(@RequestBody List<HorarioRequest> horarios,@PathVariable Integer id){
        horarioService.crearHorarios(horarios,id);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
