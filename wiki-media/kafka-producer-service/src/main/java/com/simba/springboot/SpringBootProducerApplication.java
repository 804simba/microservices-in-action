package com.simba.springboot;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RequiredArgsConstructor
@SpringBootApplication
public class SpringBootProducerApplication implements CommandLineRunner {
    private final WikiMediaChangesProducer wikiMediaChangesProducer;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootProducerApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {
        wikiMediaChangesProducer.sendMessage();
    }
}
