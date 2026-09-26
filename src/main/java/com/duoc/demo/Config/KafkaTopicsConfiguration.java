package com.duoc.demo.Config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import com.duoc.events.TopicNames;

@Configuration
public class KafkaTopicsConfiguration {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Bean
    public KafkaAdmin kafkaAdmin() {

        Map<String, Object> configs = new HashMap<>();

        configs.put(
            AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG,
            bootstrapServers
        );

        return new KafkaAdmin(configs);
    }

    private NewTopic topic(String name) {
        System.out.println(">>> Creando bean para topic: " + name);

        return TopicBuilder.name(name)
                .partitions(3)
                .replicas(1)
                .build();
    }

    @Bean
    NewTopic transaccionRealizada() {
        return topic(TopicNames.TRANSACCION_REALIZADA);
    }

    @Bean
    NewTopic transaccionRechazada() {
        return topic(TopicNames.TRANSACCION_RECHAZADA);
    }
}
