package com.greenfox.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Until {

    public Integer until;

    public Until(Integer until) {
        this.until = until;
    }
}
