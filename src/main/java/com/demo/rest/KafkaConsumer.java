package com.demo.rest;

import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
	
	@Bean
    public Consumer<String> consumerA() {
        return msg -> System.out.println("Consumer A received: " + msg);
    }

    @Bean
    public Consumer<String> consumerB() {
        return msg -> System.out.println("Consumer B received: " + msg);
    }

}
