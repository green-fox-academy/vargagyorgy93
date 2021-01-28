package com.greenfox.demo.service;

import com.greenfox.demo.model.MissingArgumentException;
import com.greenfox.demo.model.Yondu;
import org.springframework.stereotype.Service;

@Service
public class YonduService {

    public Yondu countSpeed(Double distance, Double time) throws MissingArgumentException {
        if (distance == null || time == null){
            throw new MissingArgumentException();
        }
        return new Yondu(distance, time);
    }
}
