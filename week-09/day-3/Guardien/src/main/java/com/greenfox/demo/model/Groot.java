package com.greenfox.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Groot {

    public String received = "";
    public String translated = "";

    public Groot(String message) {
        this.received = message;
        this.translated = "I am Groot!";
    }
}
