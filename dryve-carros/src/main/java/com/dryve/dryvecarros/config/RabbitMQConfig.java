package com.dryve.dryvecarros.config;


import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {

	public static String EXCHANGE_NAME = "Veiculos";

	
	  @Bean
	    public Exchange declareExchange() {
	        return ExchangeBuilder.directExchange(EXCHANGE_NAME)
	                .durable(true)
	                .build();
	    }


}
