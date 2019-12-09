package com.nathan.config;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.common.serialization.Serializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nathan.domain.SampleMessage;
import com.nathan.serializer.JsonSerializer;

import java.util.Properties;

@Configuration
public class ProducerConfig {

    @Bean
    public KafkaProducer<String, SampleMessage> sampleMessageProducer(KafkaProducerProperties kafkaProducerProperties) {
        Properties kafkaProps = new Properties();
        kafkaProps.put("bootstrap.servers", kafkaProducerProperties.getBootstrap());

//        kafkaProps.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//        kafkaProps.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, SampleMessage> producer = new KafkaProducer<>(kafkaProps, stringKeySerializer(), sampleMessageJsonSerializer());
        return producer;
    }

    @Bean
    public Serializer stringKeySerializer() {
        return new StringSerializer();
    }

    @Bean
    public Serializer sampleMessageJsonSerializer() {
        return new JsonSerializer();
    }
}
