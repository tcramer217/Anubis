package com.tcramer.anubis.controller;

import com.tcramer.anubis.service.LcdService;
import com.tcramer.anubis.service.LcdServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LcdController {

    @Autowired
    private LcdServiceImpl lcdService;

    @RequestMapping(value = "/lcd", method = RequestMethod.GET)
    public ResponseEntity<String> lcdMessage() throws InterruptedException {
        lcdService.doLcdMessage();
        ResponseEntity<String> response = new ResponseEntity<String>("something", HttpStatus.OK);
        return response;
    }
}
