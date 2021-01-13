package com.greenfox.demo.service;

import org.springframework.stereotype.Service;

@Service
public class GreenColor implements MyColor{
    @Override
    public String printColor() {
//        System.out.println("My color is green as the grass after the rain!");
       return "My color is green as the grass after the rain!";
    }
}
