package com.greenfox.demo.service;

import com.greenfox.demo.model.Appenda;
import com.greenfox.demo.model.MissingArgumentException;
import org.springframework.stereotype.Service;

@Service
public class AppendaService {

    public Appenda appenda(String appendable) throws MissingArgumentException {
        if (appendable == null){
            throw new MissingArgumentException();
        }
        return new Appenda(appendable);
    }
}
