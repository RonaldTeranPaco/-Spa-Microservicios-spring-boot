package com.service.notificaciones.listener;


import com.service.notificaciones.dto.NotificacionMessage;
import com.service.notificaciones.dto.NotificacionRequest;
import com.service.notificaciones.service.EmailServiceImpl;
import com.service.notificaciones.service.NotificacionServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Slf4j
@Component
public class ConsumerListener {

    @Autowired
    private NotificacionServiceImp notificacionServiceImp;
    @Autowired
    private EmailServiceImpl emailService;

    @KafkaListener(groupId = "group-0",
            topicPartitions = @TopicPartition(topic = "correo-topic",partitions = {"0"}),
            containerFactory = "strContainerFactory")
    public void listener1(NotificacionMessage message){
        notificacionServiceImp.procesarMensaje(message);
        log.info(message.getCorreo());
        System.out.println("Listener>>>1  recibiendo un mensaje {}"+message);
    }

    @KafkaListener(groupId = "group-1",
            topicPartitions = @TopicPartition(topic = "enviarCorreo-topic",partitions = {"0"})
            , containerFactory = "strContainerFactory")
    public void listener2(NotificacionMessage message){
        notificacionServiceImp.enviarCorreoNotificacion(message);
        System.out.println("Listener>>>2 recibiendo un mensaje {}"+message.getCorreo());
    }

}
