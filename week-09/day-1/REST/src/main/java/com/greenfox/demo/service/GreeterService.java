package com.greenfox.demo.service;

import com.greenfox.demo.model.Greeter;
import com.greenfox.demo.model.MissingArgumentException;
import org.springframework.stereotype.Service;

@Service
public class GreeterService {

    public Greeter greeter(String name, String title) throws MissingArgumentException {
        if (name == null && title == null){
            throw new MissingArgumentException();
        }
        if (name == null){
            throw new MissingArgumentException();
        }
        if (title == null){
            throw new MissingArgumentException();
        }
        return new Greeter(name, title);
    }
}
