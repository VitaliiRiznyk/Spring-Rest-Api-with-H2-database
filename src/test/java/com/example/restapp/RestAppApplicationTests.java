package com.example.restapp;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class RestAppApplicationTests {


    @Test
    void contextLoads() {
    }

    @Test
    void returnJson() throws IOException {
        String jsonName = "application/json";
        HttpUriRequest request = new HttpGet("http://localhost:8080/1");

        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        String type = ContentType.getOrDefault(response.getEntity()).getMimeType();
        Assertions.assertEquals(jsonName, type);
    }

    @Test
    void statusCodeFound() throws IOException {

        HttpUriRequest uriRequest = new HttpGet("http://localhost:8080/1");

        HttpResponse response = HttpClientBuilder.create().build().execute(uriRequest);
        Assertions.assertEquals(response.getStatusLine().getStatusCode(), 200);
    }

}