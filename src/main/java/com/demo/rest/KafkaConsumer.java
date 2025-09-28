package com.demo.rest;

import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
	
	@Bean
    public Consumer<Sample> consumerAP0() {
        return msg -> System.out.println("Consumer AP0 received: " + msg.getName());
    }
	
	@Bean
    public Consumer<Sample> consumerAP1() {
        return msg -> System.out.println("Consumer AP1 received: " + msg.getName());
    }

    @Bean
    public Consumer<Sample> consumerB() {
        return msg -> System.out.println("Consumer B received: " + msg.getName());
    }
    
    
    @Bean
    public Consumer<Sample> consumerC() {
        return msg -> System.out.println("Consumer C received: " + msg.getName());
    }

}
