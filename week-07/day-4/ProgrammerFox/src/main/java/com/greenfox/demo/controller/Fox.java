package com.greenfox.demo.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Fox {
   private String name= "Fox";
   private String food = "mochi";
   private String drink = "banana juice";
   private String trick;
   private List<String> tricks = new ArrayList<>();

    public Fox(String name, String food, String drink, String trick) {
        this.name = name;
        this.food = food;
        this.drink = drink;
        this.trick = trick;
    }

    public Fox() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public String getTrick() {
        return trick;
    }

    public void setTrick(String trick) {
        this.trick = trick;
    }

    public List<String> getTricks() {
        return tricks;
    }

    public void setTricks(List<String> tricks) {
        this.tricks = tricks;
    }

    public void addTricks(String trick) {
        this.tricks.add(trick);
    }
}
