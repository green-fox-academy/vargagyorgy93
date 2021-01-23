package com.greenfox.demo.service;

import com.greenfox.demo.FoxProgrammerApplication;
import com.greenfox.demo.controller.Fox;

import java.util.ArrayList;
import java.util.List;

public class Services {
    public Fox fox = new Fox();
    List<Fox> foxList = new ArrayList<>();
    public List<String> tricksOptions = new ArrayList<>();

    public void addToTrickOptionsList(){
        tricksOptions.add("write HTML");
        tricksOptions.add("code in Java");
        tricksOptions.add("break dance");
        tricksOptions.add("shoot with gun");
    }

    public String getTrickOptionsIndex(Integer index){
       return tricksOptions.get(index);
    }

    public void addTricks(String trick) {
        fox.addTricks(trick);
    }

    public List<String> getTricks() {
       return fox.getTricks();
    }

}
