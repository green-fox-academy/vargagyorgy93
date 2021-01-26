package com.greenfox.demo.service;

import com.greenfox.demo.model.Doubling;
import com.greenfox.demo.model.DoublingNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DoublingService {

    public Doubling doubling(Integer input) throws DoublingNotFoundException {
        if (input == null){
            throw new DoublingNotFoundException();
        }
        return new Doubling(input);
    }
}
