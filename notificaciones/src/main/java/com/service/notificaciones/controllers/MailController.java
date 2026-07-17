package com.service.notificaciones.controllers;


import com.service.notificaciones.dto.NotificacionRequest;
import com.service.notificaciones.service.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
public class MailController {
    //eliminar esta por que es una clase de prueba del mail sender
    @Autowired
    private EmailServiceImpl emailService;

    @PostMapping
    public ResponseEntity<?> crearEmail(@RequestBody NotificacionRequest notificacion){
        emailService.sendEmail(notificacion.getCorreo(),"cita","mensaje de prueba");

        return ResponseEntity.ok("mensaje enviado");
    }
}
