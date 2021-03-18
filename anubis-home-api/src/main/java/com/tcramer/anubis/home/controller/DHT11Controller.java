package com.tcramer.anubis.home.controller;

import com.anubis.core.entity.sensor.DHT11Data;
import com.tcramer.anubis.home.service.DHT11Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/dht11")
public class DHT11Controller {

    private DHT11Service dht11Service;

    @RequestMapping(value = "/dht1", method = RequestMethod.GET)
    public DHT11Data readTemperature() {
        return new DHT11Data();
    }

    @RequestMapping(value = "/dht", method = RequestMethod.GET)
    public List<DHT11Data> getAll() {
        return getDht11Service().getAll();
    }

    @RequestMapping(value = "/dht/test", method = RequestMethod.GET)
    public DHT11Data makeNewDht11() {
        return getDht11Service().createTest();
    }

    @Autowired
    public DHT11Service getDht11Service() {
        return dht11Service;
    }

    public void setDht11Service(DHT11Service dht11Service) {
        this.dht11Service = dht11Service;
    }
}
