package com.anubis.homepage.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping(value = "/hello")
    public String greetingMessage(Model model) {
        String helloMstch = "Hello Mustache!";
        model.addAttribute("message", helloMstch);
        return "hello";
    }
}
