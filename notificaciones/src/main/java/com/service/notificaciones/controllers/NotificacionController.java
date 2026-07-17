package com.service.notificaciones.controllers;


import com.service.notificaciones.dto.NotificacionRequest;
import com.service.notificaciones.service.NotificacionServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notificaciones")
public class NotificacionController {
    @Autowired
    private NotificacionServiceImp notificacionService;

    @PostMapping
    public ResponseEntity<?> guardarNotificacion(@RequestBody NotificacionRequest req){
        NotificacionRequest res = notificacionService.guardarNotificacion(req);
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

}
