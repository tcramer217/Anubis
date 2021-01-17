package com.tcramer.anubis.controller;

import com.tcramer.anubis.service.DHT11ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class DHT11Controller {

    @Autowired
    private DHT11ServiceImpl dht11Service;

    @RequestMapping("/dht")
    public List<Double> getTemperature() throws IOException, URISyntaxException {
        return dht11Service.getTemperature();
    }
}
