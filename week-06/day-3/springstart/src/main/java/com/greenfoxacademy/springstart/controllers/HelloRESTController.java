package com.greenfoxacademy.springstart.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloRESTController  {
    AtomicLong atom = new AtomicLong();

    //    @RequestMapping(value = "/greeting")
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam String name) {
        Greeting greeting = new Greeting( 1 + atom.getAndIncrement(), "Hello, " + name);
        return greeting;
    }

}
