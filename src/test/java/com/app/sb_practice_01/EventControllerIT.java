package com.app.sb_practice_01;

import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EventControllerIT {

    @Autowired
    private TestRestTemplate template;

    @Test
    public void getHello() throws Exception {
        String message = "Greetings from Spring Boot!";
        ResponseEntity<String> response = template
                .withBasicAuth("user", "pass123!")
                .getForEntity("http://localhost:8080/api/v1/test/", String.class);
        assertThat(response.getBody()).isEqualTo(message);
    }
}
