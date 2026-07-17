package com.historial.controller;



import com.historial.dto.DoctorRequest;

import com.historial.dto.DoctorResponse;
import com.historial.service.DoctorServiceImp;
import lombok.experimental.PackagePrivate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/doctores")
public class DoctorController {

    @Autowired
    private DoctorServiceImp service;

    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(service.getDoctores());
    }


    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody DoctorRequest d) {
        DoctorResponse res = service.saveDoctor(d);
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscarFechasDoctor/{ci}")
    public ResponseEntity<?> buscarCitasFechas(@PathVariable Integer ci){
        return ResponseEntity.ok(service.citasFechasDoctor(ci));
    }
}
