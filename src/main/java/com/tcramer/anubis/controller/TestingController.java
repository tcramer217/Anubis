package com.tcramer.anubis.controller;

import com.pi4j.io.gpio.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestingController {

    @RequestMapping(value = "/toggle-led", method = RequestMethod.GET)
    public ResponseEntity<String> toggleLed() {
        final GpioController gpio = GpioFactory.getInstance();
        GpioPinDigitalOutput led = null;
        if (gpio.getProvisionedPin(RaspiPin.GPIO_06) != null) {
            led = (GpioPinDigitalOutput) gpio.getProvisionedPin(RaspiPin.GPIO_06);
        } else {
            led = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_06, "LED", PinState.LOW);
        }
        led.toggle();
        PinState pinState = led.getState();
        ResponseEntity<String> response = new ResponseEntity<String>(pinState.getName(), HttpStatus.OK);
        return response;
    }

    @RequestMapping(value = "/{keyType}", method = RequestMethod.GET)
    public ResponseEntity<String> pressKey(@PathVariable String keyType) {
        RestTemplate restTemplate = new RestTemplate();
        String googleUrl = "http://www.google.com";
        ResponseEntity<String> response = restTemplate.getForEntity(googleUrl, String.class);
        return response;
    }
}
