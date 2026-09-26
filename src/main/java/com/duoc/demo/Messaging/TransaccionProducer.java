package com.duoc.demo.Messaging;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.duoc.events.TopicNames;
import com.duoc.events.TransaccionRealizadaEvent;

@Component
public class TransaccionProducer {

    private final KafkaTemplate <String, TransaccionRealizadaEvent> kafkaTemplate;

    public TransaccionProducer(KafkaTemplate<String, TransaccionRealizadaEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publicar(TransaccionRealizadaEvent event) {
        
        kafkaTemplate.send(
            TopicNames.TRANSACCION_REALIZADA, 
            event
        );
    }
    
}
