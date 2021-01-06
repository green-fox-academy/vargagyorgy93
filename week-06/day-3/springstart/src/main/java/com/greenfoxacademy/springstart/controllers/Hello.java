package com.greenfoxacademy.springstart.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class Hello {
    @RequestMapping(value = "/hello")
    @ResponseBody
    public String hello(){
        return "Hello World!";
    }
}
