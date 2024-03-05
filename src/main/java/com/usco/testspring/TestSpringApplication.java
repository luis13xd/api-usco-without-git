package com.usco.testspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class TestSpringApplication {

/*    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(TestSpringApplication.class);
    }*/

    public static void main(String[] args) {
        SpringApplication.run(TestSpringApplication.class, args);
    }

}
