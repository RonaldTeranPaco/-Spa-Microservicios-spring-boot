package com.service.notificaciones.service;

import com.service.notificaciones.dto.NotificacionMessage;
import com.service.notificaciones.dto.NotificacionRequest;
import com.service.notificaciones.repository.NotificacionEntidad;
import com.service.notificaciones.repository.NotificacionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Slf4j
@Service
public class NotificacionServiceImp implements INotificacion{

    @Autowired
    private NotificacionRepository notificacionRepository;
    @Autowired
    private MapperNotificacion mapper;
    @Autowired
    private EmailServiceImpl emailService;

    public void procesarMensaje(NotificacionMessage message){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime fecha = LocalDateTime.parse(message.getFechaHora(),formatter);
        NotificacionRequest notificacion = new NotificacionRequest();
        notificacion.setFecha(fecha);
        notificacion.setEdad(message.getEdad());
        notificacion.setNombre(message.getNombre());
        notificacion.setCorreo(message.getCorreo());
        notificacion.setMotivo(message.getMotivo());
        guardarNotificacion(notificacion);
    }

    public void enviarCorreoNotificacion(NotificacionMessage message){
        String mensaje= "Hola te hacemos recuerdo que tienes una reserva para la \n" +
                "Fecha:"+message.getFechaHora()+"\n"+
                "Nombre:"+message.getNombre();
        emailService.sendEmail(message.getCorreo(),"Cita",mensaje);
    }



    @Override
    public NotificacionRequest guardarNotificacion(NotificacionRequest request) {
        NotificacionEntidad req = mapper.convertirDAO(request);
        System.out.println(req.getFecha());
        notificacionRepository.save(req);
        return request;
    }

    @Override
    public List<NotificacionRequest> listar() {
        return mapper.convertirLista(notificacionRepository.findAll());
    }

    @Override
    public NotificacionRequest buscarId(Integer id) {
        return null;
    }
}
