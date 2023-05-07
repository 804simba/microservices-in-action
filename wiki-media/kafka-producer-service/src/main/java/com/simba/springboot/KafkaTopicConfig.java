package com.simba.springboot;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

// https://wikitech.wikimedia.org/wiki/Event_Platform/EventStreams

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name("wikimedia_recentChange")
                .build();
    }
}
