package com.sk.controller;


import com.sk.dto.Employee;
import com.sk.producer.KafkaAvroProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

    @Autowired
    private KafkaAvroProducer producer;

    @PostMapping("/events")
    public String SendMessage(@RequestBody Employee employee){
        producer.send(employee);
        return "message publish";
    }
}
