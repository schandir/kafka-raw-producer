package com.nathan.kafka.config;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.nathan.kafka.model.SampleMessage;

import java.util.Properties;

@Configuration
public class KafkaProducerConfig {

    @Bean
    public KafkaProducer<String, SampleMessage> sampleMessageProducer(KafkaProducerProperties kafkaProducerProperties) {
        Properties kafkaProps = new Properties();
        kafkaProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProducerProperties.getBootstrap());
        KafkaProducer<String, SampleMessage> producer = new KafkaProducer<String, SampleMessage>(kafkaProps, new StringSerializer(), new JsonSerializer<SampleMessage>());
        return producer;
    }

}
