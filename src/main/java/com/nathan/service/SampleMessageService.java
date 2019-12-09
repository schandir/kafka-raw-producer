package com.nathan.service;


import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nathan.config.KafkaProducerProperties;
import com.nathan.domain.SampleMessage;

@Service
public class SampleMessageService {

    @Autowired
    private KafkaProducer<String, SampleMessage> sampleMessageProducer;

    @Autowired
    private KafkaProducerProperties kafkaProducerProperties;

    private static final Logger LOGGER = LoggerFactory.getLogger(SampleMessageService.class);

    public boolean publish(SampleMessage sampleMessage) {
        ProducerRecord<String, SampleMessage> record =
                new ProducerRecord<>(kafkaProducerProperties.getTopic(), sampleMessage.getId(),
                        sampleMessage);
        try {
            RecordMetadata recordMetadata = sampleMessageProducer.send(record).get();
            LOGGER.info("topic = {}, partition = {}, offset = {}, sampleMessage = {}",
                    recordMetadata.topic(), recordMetadata.partition(), recordMetadata.offset(), sampleMessage);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
