package com.service.notificaciones.service;


import com.service.notificaciones.dto.NotificacionRequest;
import com.service.notificaciones.repository.NotificacionEntidad;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapperNotificacion {
    public NotificacionEntidad convertirDAO(NotificacionRequest request){
        NotificacionEntidad notificacion = new NotificacionEntidad();
        notificacion.setNombre(request.getNombre());
        notificacion.setCorreo(request.getCorreo());
        notificacion.setEdad(request.getEdad());
        notificacion.setFecha(request.getFecha());
        notificacion.setMotivo(request.getMotivo());

        return notificacion;
    }

    public List<NotificacionRequest> convertirLista(List<NotificacionEntidad> lista){
        List<NotificacionRequest> listaRes = new ArrayList<>();
        for(NotificacionEntidad res:lista){
            NotificacionRequest request = new NotificacionRequest();
            request.setCorreo(res.getCorreo());
            request.setNombre(res.getNombre());
            request.setEdad(res.getEdad());
            request.setFecha(res.getFecha());
            listaRes.add(request);
        }

        return listaRes;
    }
}
