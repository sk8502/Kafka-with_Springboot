package com.sk.controller;

import com.sk.dto.Customer;
import com.sk.service.KafkaMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producer-app")
public class EventController {

    @Autowired
    private KafkaMessagePublisher publisher;

    @GetMapping("/public/{message}")
    public ResponseEntity <?> publicMessage(@PathVariable String message)
    {
        try {
            for (int i = 0; i < 100; i++) {
                publisher.sendMessageToTopic(message+" : "+i);
            }

            return ResponseEntity.ok("message publish sucessfuly");
        }catch (Exception e){
             e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }
    @PostMapping("/public")
    public  void sendEvent(@RequestBody Customer customer)
    {
   publisher.sendEventToTopic((customer));
    }
}
