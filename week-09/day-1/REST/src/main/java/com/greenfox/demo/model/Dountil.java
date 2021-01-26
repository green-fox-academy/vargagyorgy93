package com.greenfox.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.stream.IntStream;

@Getter
@Setter
@NoArgsConstructor
public class Dountil {

    public Integer result = 0;

    public Dountil(String action, Integer until) {
        if (action.equals("sum")){
            IntStream.rangeClosed(0, until)
                    .forEachOrdered(i -> this.result += i);
        }
        if (action.equals("factor")){
            this.result += 1;
            IntStream.rangeClosed(1, until)
                    .forEachOrdered(i -> this.result *= i);
        }
    }


}
