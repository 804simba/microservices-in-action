package com.simba.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.simba.kafka.config.KafkaConfigProps;
import com.simba.kafka.domain.UserVisitEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

import java.time.LocalDateTime;
import java.util.UUID;
// https://developer.confluent.io/quickstart/kafka-docker/
@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class KafkaDemoApplication {
	private final ObjectMapper objectMapper;

	public static void main(String[] args) {
		SpringApplication.run(KafkaDemoApplication.class, args);
	}

	@Bean
	public ApplicationRunner runner(final KafkaTemplate<String, String> kafkaTemplate, final KafkaConfigProps kafkaConfigProps) throws JsonProcessingException {
		final UserVisitEvent event = UserVisitEvent.builder()
				.customerId(String.valueOf(UUID.randomUUID()))
				.dateTime(LocalDateTime.now())
				.build();
		final String payload = objectMapper.writeValueAsString(event);
		return args -> {
			kafkaTemplate.send(kafkaConfigProps.getTopic(), payload); // the payload to its designated topic
		};
	}

	@KafkaListener(topics = "uservisit") // allows us to specify a topic for which our consumer listens to.
	public String listens(final String in) {
		log.info("Message from topic >>>> {}", in);
		return in;
	}
}
