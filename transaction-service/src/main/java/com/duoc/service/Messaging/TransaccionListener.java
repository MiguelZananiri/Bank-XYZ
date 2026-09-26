package com.duoc.service.Messaging;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.duoc.events.TopicNames;
import com.duoc.events.TransaccionRealizadaEvent;

import com.duoc.service.Saga.ProcessedEventStore;

@Component
public class TransaccionListener {

    private final ProcessedEventStore processedEventStore;

    public TransaccionListener(ProcessedEventStore processedEventStore) {
        this.processedEventStore = processedEventStore;
    }

    @KafkaListener(
        topics = TopicNames.TRANSACCION_REALIZADA,
        groupId = "transaccion-service"
    )
    public void recibir(TransaccionRealizadaEvent  event) {
        if (processedEventStore.isFirstTime(event.eventId())) {
            System.out.println("Evento duplicado ignorado " + event);

            return;
        }
        
        System.out.println("Transaccion recibida: " + event);
    }

}
