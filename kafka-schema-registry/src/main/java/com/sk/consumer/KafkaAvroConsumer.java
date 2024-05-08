package com.sk.consumer;

import com.sk.dto.Employee;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaAvroConsumer {


    @KafkaListener(topics = "${topic.name}")
    public void readMsg(ConsumerRecord<String, Employee>consumer) {

    String key=consumer.key();
    Employee value=consumer.value();

    log.info("Avro messge recived for key : --  "+key+"   value :===   "+value);
    }
}
