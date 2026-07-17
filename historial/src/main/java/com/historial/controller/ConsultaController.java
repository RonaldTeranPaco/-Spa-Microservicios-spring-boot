package com.historial.controller;


import com.historial.dto.ConsultaRequest;
import com.historial.persistence.entidades.ConsultaMedica;
import com.historial.service.interfaces.ConsultaMedicaService;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/consultas")
public class ConsultaController {
    @Autowired
    private ConsultaMedicaService service;

    @PostMapping
    public ResponseEntity<?> crearConsulta(@RequestBody ConsultaRequest consultaMedica){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(consultaMedica));
    }

    @GetMapping("historial/{idHistorial}")
    public ResponseEntity<?> getConsultas(@PathVariable UUID idHistorial){

        return ResponseEntity.ok(service.listarPorHistorial(idHistorial));
    }
}
