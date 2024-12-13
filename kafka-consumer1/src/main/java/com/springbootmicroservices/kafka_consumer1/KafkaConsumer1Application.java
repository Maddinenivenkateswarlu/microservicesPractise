package com.springbootmicroservices.kafka_consumer1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class KafkaConsumer1Application {

	@KafkaListener(topics = "1Oct2024" ,groupId = "a")
	public void messageFromKafka(String message) {
		System.out.println(message + "i got message from producer this is consumer 1");
	}

	public static void main(String[] args) {
		SpringApplication.run(KafkaConsumer1Application.class, args);
	}

}
