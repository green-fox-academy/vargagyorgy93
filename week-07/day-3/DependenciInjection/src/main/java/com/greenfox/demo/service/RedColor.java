package com.greenfox.demo.service;

import org.springframework.stereotype.Service;

//@Service
public class RedColor implements MyColor{
    @Override
    public String printColor() {
        return "I am red as the sky before the darkness came!";
//        System.out.println("I am red as the sky before the darkness came!");
    }
}
