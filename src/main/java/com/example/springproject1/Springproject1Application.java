package com.example.springproject1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Springproject1Application {

    public static void main(String[] args) {
        SpringApplication.run(Springproject1Application.class, args);
    }

}
