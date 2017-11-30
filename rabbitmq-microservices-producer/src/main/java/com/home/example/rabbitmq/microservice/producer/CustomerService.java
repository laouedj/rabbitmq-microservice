package com.home.example.rabbitmq.microservice.producer;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;


public class CustomerService {

	private final RabbitTemplate rabbitTemplate;

	  private final Exchange exchange;

	  public CustomerService(RabbitTemplate rabbitTemplate, Exchange exchange) {
	    this.rabbitTemplate = rabbitTemplate;
	    this.exchange = exchange;
	  }

	  @Scheduled(fixedDelay = 1000, initialDelay = 500)
	  public void createCustomer() {
	    // ... do some database stuff
	    String routingKey = "customer.created";
	    String message = "customer created";
	    rabbitTemplate.convertAndSend(exchange.getName(), routingKey, message);
	  }
}
