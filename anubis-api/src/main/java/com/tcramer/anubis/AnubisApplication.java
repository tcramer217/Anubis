package com.tcramer.anubis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AnubisApplication {
    public static void main(String[] args) {
        SpringApplication.run(AnubisApplication.class, args);
    }
}
