package com.greenfox.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Array {

    public Integer[] result;

    public Array(String what, Integer[] numbers) {
        int count = 0;
        if (what.equals("sum")){
            for (int i = 0; i < numbers.length; i++) {
                count += numbers[i];
            }
            result = new Integer[1];
            this.result[0] = count;
        }
        if (what.equals("multiply")){
            count = 1;
            for (int i = 0; i < numbers.length; i++) {
                count *= numbers[i];
            }
            result = new Integer[1];
            this.result[0] = count ;
        }
        if (what.equals("double")){
            result = new Integer[4];
            for (int i = 0; i < numbers.length; i++) {
            this.result[i] = numbers[i]*2 ;
            }
        }
    }
}
