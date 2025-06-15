package com.demo.rest;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.GetMapping;
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

	    @GetMapping
	    public String sendMessage(@RequestParam String data) {
	        streamBridge.send("producer-out-0", data);
	        return "Message sent to Kafka topic!";
	    }

}
