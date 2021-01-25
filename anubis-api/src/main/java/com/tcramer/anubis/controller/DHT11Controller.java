package com.tcramer.anubis.controller;

import com.tcramer.anubis.core.model.DHT11Data;
import com.tcramer.anubis.service.DHT11Service;
import com.tcramer.anubis.service.DHT11ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DHT11Controller {

    @Autowired
    private DHT11Service dht11Service;

//    @RequestMapping(value = "/dht", method = RequestMethod.GET)
//    public DHT11Data readTemperature() throws IOException, URISyntaxException {
//        return dht11Service.getTemperature();
//    }

    @RequestMapping(value = "/dht", method = RequestMethod.GET)
    public List<DHT11Data> getAll() {
        return dht11Service.getAll();
    }

}
