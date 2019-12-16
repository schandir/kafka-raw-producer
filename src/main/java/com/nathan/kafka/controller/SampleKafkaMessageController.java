package com.nathan.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nathan.kafka.model.SampleMessage;
import com.nathan.kafka.service.SampleMessageService;

@RestController
public class SampleKafkaMessageController {

    @Autowired
    private SampleMessageService sampleMessageService;

    @GetMapping("/sampleMessage")
    public boolean sendMessage(SampleMessage sampleMessage) {
        return sampleMessageService.publish(sampleMessage);
    }
}
