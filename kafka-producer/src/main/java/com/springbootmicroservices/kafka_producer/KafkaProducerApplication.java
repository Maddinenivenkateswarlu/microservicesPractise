package com.springbootmicroservices.kafka_producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class KafkaProducerApplication {

	@Autowired
	private KafkaTemplate<String , String> kafkaTemplate;
	@GetMapping("/{message}")
	public    String sendMessageToConsumer(@PathVariable String message) {
		String key = "key-" + message;
		kafkaTemplate.send("1Oct2024" ,key , message );
		return message;
	}

	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerApplication.class, args);
	}

}
