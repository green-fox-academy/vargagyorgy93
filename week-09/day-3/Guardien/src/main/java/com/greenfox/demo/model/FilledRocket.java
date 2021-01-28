package com.greenfox.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FilledRocket {

    private String received;
    private  Integer amount = 0;
    private String shipstatus;
    private Boolean ready = false;

    public FilledRocket(String caliber, Integer amount) {
         this.received = caliber;
         this.amount = amount;
        if (amount.equals(0)) {
            this.shipstatus = "empty";
        }
        if (!amount.equals(0)) {
            int status = amount / (12500 / 100);
            this.shipstatus = status + "%";
        }
        if (amount.equals(12500)){
            this.shipstatus = "full";
            this.ready = true;
        }
        if (amount > 12500){
            this.shipstatus = "overloaded";
        }
    }
}
