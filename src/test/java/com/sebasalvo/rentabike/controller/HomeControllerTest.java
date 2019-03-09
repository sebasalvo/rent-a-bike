package com.sebasalvo.rentabike.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class HomeControllerTest {

    @Test
    public void testHome() {
        TestRestTemplate testRestTemplate = new TestRestTemplate();
        ResponseEntity<String> response =
                testRestTemplate.getForEntity("http://localhost:8080/", String.class);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));

    }

}
