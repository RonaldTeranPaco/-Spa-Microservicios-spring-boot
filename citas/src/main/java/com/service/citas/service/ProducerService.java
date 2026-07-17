package com.service.citas.service;

import com.service.citas.dto.CitaRequestCorreo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ProducerService {

    @Autowired
    private KafkaTemplate<String, CitaRequestCorreo> kafkaTemplate;

    public void sendMessage(CitaRequestCorreo message) {

        kafkaTemplate.send("correo-topic", message).whenComplete((result, ex) -> {
            if (ex != null) {
                System.out.println("Error, al enviar el mensaje: {}"+ ex.getMessage());
            }
            System.out.println("Mensaje enviado con éxito: {}"+ result.getProducerRecord().value());
            System.out.println("Particion {}, Offset {}"+ result.getRecordMetadata().partition()+ result.getRecordMetadata().offset());
        });

        kafkaTemplate.send("enviarCorreo-topic", message).whenComplete((result, ex) -> {
            if (ex != null) {
                System.out.println("Error, al enviar el mensaje: {}"+ ex.getMessage());
            }
            System.out.println("Mensaje enviado con éxito: {}"+ result.getProducerRecord().value());
            System.out.println("Particion {}, Offset {}"+ result.getRecordMetadata().partition()+ result.getRecordMetadata().offset());
        });

    }
}
