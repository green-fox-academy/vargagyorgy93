package com.greenfox.demo.service;

import com.greenfox.demo.model.Array;
import com.greenfox.demo.model.MissingArgumentException;
import org.springframework.stereotype.Service;

@Service
public class ArrayService {

    public Array array(String what, Integer[] numbers) throws MissingArgumentException {
        if (what == null || numbers == null){
            throw new MissingArgumentException();
        }
        return new Array(what, numbers);
    }
}
