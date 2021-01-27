package com.greenfox.demo.service;

import com.greenfox.demo.model.Groot;
import com.greenfox.demo.model.MissingArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GrootService {

    public Groot translate(String message) throws MissingArgumentException {
        if (message == null){
            throw new MissingArgumentException();
        }
        return new Groot(message);
    }
}
