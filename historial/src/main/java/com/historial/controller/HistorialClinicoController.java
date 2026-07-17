package com.historial.controller;



import com.historial.dto.HistorialRequest;
import com.historial.dto.HistorialResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.historial.service.HistorialClinicoService;


@RestController
@RequestMapping("/api/historiales")

public class HistorialClinicoController {

    @Autowired
    private HistorialClinicoService service;


    @PostMapping
    public ResponseEntity<?> createHistorial(@RequestBody HistorialRequest historial) {

        System.out.println(historial);
        try {
            HistorialResponse nuevoHistorial = service.save(historial);
            return new ResponseEntity<>(nuevoHistorial, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getHistorialByIdPaciente(@PathVariable Integer id){

        return ResponseEntity.ok(service.obtenerPorPaciente(id));
    }

    @GetMapping
    public ResponseEntity<?> getHistoriales(){
        return ResponseEntity.ok(service.listar());
    }
}
