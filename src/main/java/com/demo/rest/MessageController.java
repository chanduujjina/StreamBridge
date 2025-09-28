package com.demo.rest;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class MessageController {
	
	 private final StreamBridge streamBridge;

	    public MessageController(StreamBridge streamBridge) {
	        this.streamBridge = streamBridge;
	    }

	    @PostMapping("/test1")
	    public String sendMessage(@RequestBody  Sample sample) {
	        streamBridge.send("producer-out-0", sample);
	        return "Message sent to Kafka topic!";
	    }
	    
	    @PostMapping("/test2")
	    public String sendMessage1(@RequestBody  Sample sample, @RequestParam int partitionKey) {
	    	 streamBridge.send("producer-out-1",
	                 MessageBuilder.withPayload(sample)
	                         .setHeader("partitionKey", partitionKey)
	                         .build());
	        return "Message sent to Kafka topic!";
	    }

}
