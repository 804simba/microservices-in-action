package com.simba.rabbitmq.controller;

import com.simba.rabbitmq.dto.UserVO;
import com.simba.rabbitmq.producer.RabbitMQJSONProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MessageJSONController {
    private final RabbitMQJSONProducer rabbitMQJSONProducer;

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody UserVO user) {
        rabbitMQJSONProducer.sendJSONMessage(user);
        return ResponseEntity.ok("Json message sent successfully");
    }
}
