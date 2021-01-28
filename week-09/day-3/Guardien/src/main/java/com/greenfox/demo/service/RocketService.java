package com.greenfox.demo.service;

import com.greenfox.demo.model.FilledRocket;
import com.greenfox.demo.model.MissingArgumentException;
import com.greenfox.demo.model.Rocket;
import org.springframework.stereotype.Service;

@Service
public class RocketService {

    public Rocket getCargo(){
        return new Rocket();
    }

    public FilledRocket getCargoStatus(String caliber, Integer amount) throws MissingArgumentException {
        if (caliber == null || amount == null){
            throw new MissingArgumentException();
        }
        return new FilledRocket(caliber, amount);
    }
}
