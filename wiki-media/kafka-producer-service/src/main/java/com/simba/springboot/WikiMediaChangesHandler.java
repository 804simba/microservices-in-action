package com.simba.springboot;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

// https://github.com/launchdarkly/okhttp-eventsource/releases

@RequiredArgsConstructor
public class WikiMediaChangesHandler implements EventHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(WikiMediaChangesHandler.class);
    private final KafkaTemplate<String, String> kafkaTemplate;
    // KafkaTemplate wraps a producer instance and provides convenient methods for sending messages
    // to Kafka topics.
    private final String topic;
    @Override
    public void onOpen() throws Exception {

    }

    @Override
    public void onClosed() throws Exception {

    }
    // onMessage is triggered when there is a message from the stream source (wikimedia), then it reads that event.
    @Override
    public void onMessage(String s, MessageEvent messageEvent) throws Exception {
        LOGGER.info(String.format("Event message ->> %s", messageEvent.getData()));

        kafkaTemplate.send(topic, messageEvent.getData());
    }

    @Override
    public void onComment(String s) throws Exception {

    }

    @Override
    public void onError(Throwable throwable) {

    }
}
