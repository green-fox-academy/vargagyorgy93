package com.greenfox.demo.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.greenfox.demo.model.Log;
import com.greenfox.demo.repositroy.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class LogService {

    LogRepository logRepository;

    @Autowired
    public LogService(LogRepository logRepository){
        this.logRepository = logRepository;
    }

    public Log log( String endpoint, String data){
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss", Locale.US)
                .format(new Date());
        return  new Log(timeStamp, endpoint, data);
    }

    public List<Log> entries(){
        List<Log> entries = (List<Log>) logRepository.findAll();
        return entries;
    }

    @JsonProperty(value = "entry_count")
    public Integer entryCount(){
        List<Log> entries = (List<Log>) logRepository.findAll();
        return entries.size();
    }
}
