package com.sk.producer;

import com.sk.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class KafkaAvroProducer {


    @Value("${topic.name}")
    private String topicname;

    @Autowired
    private KafkaTemplate<String, Employee> kafkaTemplate;


    public void send (Employee employee){
       CompletableFuture<SendResult<String,Employee>> completableFuture= kafkaTemplate.send(topicname, UUID.randomUUID().toString(),employee);
        completableFuture.whenComplete((result,ex)->

        {
            if (ex==null) {
                System.out.println("Send message=[" + employee.toString() + "]with offset=[" + result.getRecordMetadata().offset() + "]");
            }
            else {
                System.out.println("unable to send  message=[" + employee.toString() + "] Due to [" + ex.getMessage()+ "]");
            }
        });
    }



}
