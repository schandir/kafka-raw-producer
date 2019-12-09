package com.nathan.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nathan.domain.SampleMessage;
import com.nathan.service.SampleMessageService;

@RestController
public class SampleKafkaMessageController {

    @Autowired
    private SampleMessageService sampleMessageService;

    @GetMapping("/sampleMessage")
    public boolean sendMessage(SampleMessage sampleMessage) {
        return sampleMessageService.publish(sampleMessage);
    }
}
