package com.greenfox.demo.service;

import com.greenfox.demo.model.Dountil;
import com.greenfox.demo.model.MissingArgumentException;
import org.springframework.stereotype.Service;

@Service
public class DountilService {

    public Dountil dountil(String action, Integer until) throws MissingArgumentException{
        if (until == null){
            throw new MissingArgumentException();
        }
        return new Dountil(action, until);
    }
}
