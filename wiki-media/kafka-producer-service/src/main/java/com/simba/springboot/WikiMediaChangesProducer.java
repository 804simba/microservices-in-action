package com.simba.springboot;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;


@Service
@RequiredArgsConstructor
public class WikiMediaChangesProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(WikiMediaChangesProducer.class);
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage() throws InterruptedException {
        String topic = "wikimedia_recentChange";

        // The fundamental idea about event sourcing is that every change to the state of an
        // application is captured in an event object.

        // to read real time streams of data from wikimedia, we have to use an event source
        EventHandler eventHandler = new WikiMediaChangesHandler(kafkaTemplate, topic);
        final String sourceURL = "https://stream.wikimedia.org/v2/stream/recentchange";
        final URI uri = URI.create(sourceURL);

        EventSource.Builder builder = new EventSource.Builder(eventHandler, uri);
        EventSource eventSource = builder.build();
        eventSource.start();

        TimeUnit.MINUTES.sleep(10);
    }
}
