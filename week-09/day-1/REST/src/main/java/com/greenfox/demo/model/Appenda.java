package com.greenfox.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Appenda {
    public String appended;

    public Appenda(String appendable) {
        this.appended = appendable + "a";
    }
}
