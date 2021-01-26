package com.greenfox.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Doubling {

    public Integer received = 0;
    public Integer result;

    public Doubling(Integer received) {
        this.received = received;
        this.result = received*2;
    }
}
