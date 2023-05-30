package com.simba.rabbitmq.consumer;

import com.simba.rabbitmq.dto.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMQJSONConsumer {

    @RabbitListener(queues = {"${rabbitmq.jsonQueue.name}"})
    public void consumer(final UserVO userVO) {
        log.info(String.format("Message received by JSON consumer ::: %s", userVO));
    }
}
