package com.anubis.family;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AnubisFamilyApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnubisFamilyApplication.class, args);
    }
}
