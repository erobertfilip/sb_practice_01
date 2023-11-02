package com.app.sb_practice_01;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventConfig {

    @Bean
    CommandLineRunner commandLineRunne(EventRepository repository) {
        return args -> {

        };
    }
}
