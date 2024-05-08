package com.sk.consumer;

import com.sk.dto.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListener {


    Logger logger= LoggerFactory.getLogger(KafkaMessageListener.class);
//
//    @KafkaListener(topics = "kafkalearn-Partiaion",groupId = "ShashiNew1")
//    public  void consume(  Customer customer){
//        logger.info("Consumer--1 consume the events {}",customer.toString());
//    }
    @KafkaListener(topics = "kafkalearn-Partiaion1",topicPartitions = {@TopicPartition(topic ="kafkalearn-Partiaion1",partitions = {"3"})}, groupId = "ShashiNew1")
    public  void consume(  String customer){
        logger.info("Consumer--1 consume the events {}",customer.toString());
    }

//    @KafkaListener(topics = "SK100000",groupId = "ShashiNew")
//    public  void consume2(String message){
//        logger.info("Consumer--2 consume the message {}",message);
//    }
//    @KafkaListener(topics = "SK100000",groupId = "ShashiNew")
//    public  void consume3(String message){
//        logger.info("Consumer--3 consume the message {}",message);
//    }
//    @KafkaListener(topics = "SK100000",groupId = "ShashiNew")
//    public  void consume4(String message){
//        logger.info("Consumer--4 consume the message {}",message);
//    }

}
