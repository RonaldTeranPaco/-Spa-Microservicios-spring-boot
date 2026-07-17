package com.service.notificaciones.service;

import com.service.notificaciones.dto.NotificacionRequest;

import java.util.List;

public interface INotificacion {

    NotificacionRequest guardarNotificacion(NotificacionRequest request);

    List<NotificacionRequest> listar();

    NotificacionRequest buscarId(Integer id);
}
