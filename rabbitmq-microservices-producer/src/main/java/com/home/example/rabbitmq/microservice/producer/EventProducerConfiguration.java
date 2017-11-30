package com.home.example.rabbitmq.microservice.producer;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;


@Configuration
@SpringBootApplication
@EnableScheduling
public class EventProducerConfiguration {

	@Bean
	 public Exchange eventExchange() {
	   return new TopicExchange("eventExchange");
	 }

	 @Bean
	 public CustomerService customerService(RabbitTemplate rabbitTemplate, Exchange eventExchange) {
	   return new CustomerService(rabbitTemplate, eventExchange);
	 }
	 
	 public static void main(String[] args) {
			SpringApplication.run(EventProducerConfiguration.class, args);
	}
}
