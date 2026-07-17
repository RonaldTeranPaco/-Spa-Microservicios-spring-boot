package com.service.notificaciones.service;


import java.io.File;

public interface IEmailService {

    void sendEmail(String toUser, String asunto,String mensaje);

    void sendEmailWithFile(String toUser, String asunto, String mensaje, File archivo);

}
