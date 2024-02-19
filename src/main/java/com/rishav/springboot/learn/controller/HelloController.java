package com.rishav.springboot.learn.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// yaml file is more readable, and it reduces the duplicate values over here
// most of the technologies are using yaml configuration itself

@RestController
public class HelloController {

    @Value("Welcome.Message")
    private String welcomeMessage;
//    @RequestMapping(value = "/", method = RequestMethod.GET)

    @GetMapping("/")
    public String helloWorld() {
        return welcomeMessage;
    }
}
