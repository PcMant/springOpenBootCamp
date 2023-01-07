package com.example.ejerciciosSesiones10_11_12.controller;

import com.example.ejerciciosSesiones10_11_12.entities.Latop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LatopControllerTest {

    private TestRestTemplate testRestTemplate;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:"+port).basicAuthentication("user1", "password");
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @Test
    void findAll() {
        ResponseEntity<Latop[]> response =
                testRestTemplate.getForEntity("/api/latops",  Latop[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(200, response.getStatusCodeValue());

        List<Latop> books = Arrays.asList(response.getBody());
        System.out.println(books.size());
    }

    @Test
    void findOneById() {
        ResponseEntity<Latop> response =
                testRestTemplate.getForEntity("/api/latops/100", Latop.class);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void create() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """
                {
                    "mark": "Asus",
                    "model": "New pepine",
                    "yearr": 2023,
                    "sn": "123abc"
                }
                """;

        HttpEntity<String> request = new HttpEntity<>(json,headers);

        ResponseEntity<Latop> response = testRestTemplate.exchange("/api/latops", HttpMethod.POST, request, Latop.class);

        Latop result = response.getBody();

        assertEquals(1L, result.getId());
        assertEquals("New pepine", result.getModel());
//        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());

    }
}