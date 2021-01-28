package com.greenfox.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Rocket {

    private Integer caliber25 = 0;
    private Integer caliber30 = 0;
    private Integer caliber50 = 0;
    private String shipstatus = "empty";
    private Boolean ready = false;


}
