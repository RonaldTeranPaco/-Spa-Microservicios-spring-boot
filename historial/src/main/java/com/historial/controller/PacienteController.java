package com.historial.controller;

import com.historial.dto.PacienteHistorialConsultaResponse;
import com.historial.dto.PacienteHistorialResponse;
import com.historial.dto.PacienteRequest;

import com.historial.dto.PacienteResponse;
import com.historial.service.interfaces.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/pacientes")

public class PacienteController {


    @Autowired
    private PacienteService service;

    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(service.getPacientes());
    }


    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody PacienteRequest paciente) {
        PacienteResponse pacienteResponse = service.savePaciente(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteResponse);
    }


   @GetMapping("/buscar-ci/{ci}")
    public ResponseEntity<?> buscar(@PathVariable Integer ci) {
        return ResponseEntity.ok(service.findById(ci));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/pacientesList/")
    public ResponseEntity<?> obtenerPacienteConSinHistorial(){

        return ResponseEntity.status(HttpStatus.OK).body(service.obtenerPacienteConHistorialSinHistorial());
    }

    @GetMapping("/buscar-paciente-historial-consultas/{ci}")
    public ResponseEntity<?> buscarPacienteConHistorialConsultas(@PathVariable Integer ci){
        PacienteHistorialConsultaResponse res = service.buscarPacienteConHistorialYConsltaPorCi(ci);
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

}