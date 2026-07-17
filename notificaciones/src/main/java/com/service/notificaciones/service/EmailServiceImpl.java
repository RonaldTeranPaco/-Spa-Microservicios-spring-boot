package com.service.notificaciones.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.charset.StandardCharsets;

@Service
public class EmailServiceImpl implements IEmailService{

    @Value("{email.account}")
    private String emailAccount;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendEmail(String toUser, String asunto, String mensaje) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("direccion de correo");
        message.setTo(toUser);
        message.setSubject(asunto);
        message.setText(mensaje);

        javaMailSender.send(message);
    }

    @Override
    public void sendEmailWithFile(String toUser, String asunto, String mensaje, File archivo) {

        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true, StandardCharsets.UTF_8.name());
            helper.setFrom(emailAccount);
            helper.setTo(toUser);
            helper.setSubject(asunto);
            helper.setText(mensaje);
            helper.addAttachment(archivo.getName(),archivo);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
}
