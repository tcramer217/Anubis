package com.tcramer.anubis.home;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EntityScan({"com.tcramer.anubis.core.entity"})
@EnableJpaRepositories({"com.tcramer.anubis.core.dao"})
public class AnubisHomeAutomationApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnubisHomeAutomationApplication.class, args);
    }
}
