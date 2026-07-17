package com.service.citas.controllers;


import com.service.citas.dto.CitaRequest;
import com.service.citas.dto.CitaRequestActualizar;
import com.service.citas.dto.CitaResponse;
import com.service.citas.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/citas")
public class CitaController {

    @Autowired
    private CitaService citaService;

    @PostMapping
    public ResponseEntity<?> crearCita(@RequestBody CitaRequest citaRequest){
        CitaResponse citaResponse = citaService.crearCita(citaRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(true);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarId(@PathVariable UUID id){
        CitaResponse res = citaService.getCita(id);
        return ResponseEntity.ok(res);
    }

    @PutMapping("/{id}/estado")
    public ResponseEntity<?> actualizarEstado(@PathVariable UUID id, @RequestBody CitaRequestActualizar cita){
        return ResponseEntity.ok(
          citaService.actualizarCita(id,cita.getEstado())
        );
    }

    @GetMapping
    public ResponseEntity<?> listaCitas(){
        List<CitaResponse> res = citaService.listar();
        return ResponseEntity.ok(res);
    }

    @GetMapping("/buscarCi/{ci}")
    public ResponseEntity<?> findPacienteCitaByCi(@PathVariable Integer ci){
        return ResponseEntity.ok(citaService.findPacienteById(ci));
    }

    @GetMapping("/buscarDoctorCi/{ci}")
    public ResponseEntity<?> findByDcotorCi(@PathVariable Integer ci){
        return ResponseEntity.ok(citaService.listarFechaDoctor(ci));
    }
}
