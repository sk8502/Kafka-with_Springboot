//package com.sk;
//
//import com.sk.dto.Customer;
//import com.sk.service.KafkaMessagePublisher;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.DynamicPropertyRegistry;
//import org.springframework.test.context.DynamicPropertySource;
//import org.testcontainers.containers.KafkaContainer;
//import org.testcontainers.junit.jupiter.Container;
//import org.testcontainers.junit.jupiter.Testcontainers;
//import org.testcontainers.utility.DockerImageName;
//
//import java.time.Duration;
//import java.util.concurrent.TimeUnit;
//
//
//import static org.awaitility.Awaitility.await;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
//@Testcontainers
//class KafkaProducerExampleApplicationTests {
//
//	@Container
//	static KafkaContainer kafkaContainer=new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:latest"));
//
//	@DynamicPropertySource
//	public static void initKafkaProperties(DynamicPropertyRegistry registry){
//
//		registry.add("spring.kafka.bootstrap-servers", kafkaContainer::getBootstrapServers);
//	}
//
//	@Autowired
//	private KafkaMessagePublisher kafkaMessagePublisher;
//
//
//	@Test
//	public void testSendEventToTopic() {
//
//		kafkaMessagePublisher.sendEventToTopic(new Customer(123223,"testuser","test@hmail.com","3123121312"));
//		await().pollInterval(Duration.ofSeconds(3)).
//				atMost(10,TimeUnit.SECONDS ).untilAsserted(()->{
//
//		});
//	}
//
//}
