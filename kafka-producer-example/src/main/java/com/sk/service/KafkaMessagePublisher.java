package com.sk.service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.sk.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisher {

    @Autowired
    private KafkaTemplate<String ,Object> template;

    public void sendMessageToTopic(String message){
//      CompletableFuture<SendResult<String ,Object>> future= template.send("kafkalearn-Partiaion",3,null,message);
//      future.whenComplete((result,ex)->
//
//      {
//          if (ex==null) {
//              System.out.println("Send message=[" + message + "]with offset=[" + result.getRecordMetadata().offset() + "]");
//          }
//          else {
//              System.out.println("unable to send  message=[" + message + "] Due to [" + ex.getMessage()+ "]");
//      }
//      });
        template.send("kafkalearn-Partiaion1",3,null,"hi");
        template.send("kafkalearn-Partiaion1",1,null,"hi");
        template.send("kafkalearn-Partiaion1",2,null,"nhk");
        template.send("kafkalearn-Partiaion1",2,null,"nhk");
        template.send("kafkalearn-Partiaion1",2,null,"nhk");
        template.send("kafkalearn-Partiaion1",0,null,"hi");



    }



    public void sendEventToTopic(Customer customer){
        try {
            CompletableFuture<SendResult<String ,Object>> future= template.send("kafkalearn-Partiaion",customer);
            future.whenComplete((result,ex)->

            {
                if (ex==null) {
                    System.out.println("Send message=[" + customer.toString() + "]with offset=[" + result.getRecordMetadata().offset() + "]");
                }
                else {
                    System.out.println("unable to send  message=[" + customer.toString() + "] Due to [" + ex.getMessage()+ "]");
                }
            });
        }catch (Exception e){
            System.out.println("ERROR  --  "+e.getMessage());
        }

    }


}
