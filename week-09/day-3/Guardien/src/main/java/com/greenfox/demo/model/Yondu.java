package com.greenfox.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
@NoArgsConstructor
public class Yondu {
    private Double distance;
    private Double time;
    private Double speed;

    @Autowired
    public Yondu(Double distance, Double time) {
        this.distance = distance;
        this.time = time;
        this.speed = distance/time;
    }
}
