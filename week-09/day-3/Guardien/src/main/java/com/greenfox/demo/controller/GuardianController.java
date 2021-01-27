package com.greenfox.demo.controller;

import com.greenfox.demo.model.Groot;
import com.greenfox.demo.model.GrootError;
import com.greenfox.demo.model.MissingArgumentException;
import com.greenfox.demo.service.GrootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GuardianController {

    GrootService grootService;

    @Autowired
    public GuardianController(GrootService grootService){
        this.grootService = grootService;
    }

    @GetMapping("/groot")
    public ResponseEntity<?> groot(@RequestParam(required = false) String message){
        try {
            return ResponseEntity.ok(grootService.translate(message));
        } catch (MissingArgumentException e) {
            GrootError error = new GrootError();
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }
}
