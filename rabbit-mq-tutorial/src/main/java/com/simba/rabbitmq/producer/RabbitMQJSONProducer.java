package com.simba.rabbitmq.producer;

import com.simba.rabbitmq.dto.UserVO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitMQJSONProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJSONProducer.class);

    private final RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.jsonQueue.exchange}")
    private String exchange;

    @Value("${rabbitmq.jsonQueue.routing.key}")
    private String routingJSONKey;

    public void sendJSONMessage(UserVO userVO) {
        LOGGER.info(String.format("Sending JSON message -> %s", userVO.toString()));
        rabbitTemplate.convertAndSend(exchange, routingJSONKey, userVO);
    }
}
