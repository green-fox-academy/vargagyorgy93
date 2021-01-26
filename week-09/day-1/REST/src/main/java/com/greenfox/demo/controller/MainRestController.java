package com.greenfox.demo.controller;

import com.greenfox.demo.repositroy.LogRepository;
import com.greenfox.demo.service.*;
import com.greenfox.demo.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@RestController
public class MainRestController {

    DoublingService doublingService;
    GreeterService greeterService;
    AppendaService appendaService;
    DountilService dountilService;
    ArrayService arrayService;
    LogRepository logRepository;
    LogService logService;

    public MainRestController(DoublingService doublingService, GreeterService greeterService,
                              AppendaService appendaService, DountilService dountilService,
                              ArrayService arrayService, LogRepository logRepositroy,
                              LogService logService) {
        this.doublingService = doublingService;
        this.greeterService = greeterService;
        this.appendaService = appendaService;
        this.dountilService = dountilService;
        this.arrayService = arrayService;
        this.logRepository = logRepositroy;
        this.logService = logService;
    }

    @GetMapping("/doubling")
    public ResponseEntity<?> Doubling(@RequestParam(required = false) Integer input) {
        if (input != null) {
            logRepository.save(logService.log("/doubling", input.toString()));
        }
        try {
            return ResponseEntity.ok(doublingService.doubling(input));
        } catch (DoublingNotFoundException e) {
            return ResponseEntity.ok(new DoublingError());
        }
    }

    @GetMapping("/greeter")
    public ResponseEntity<?> Greeter(@RequestParam(required = false) String name,
                                     @RequestParam(required = false) String title) {
        if (title != null && name != null){
            logRepository.save(logService.log( "/greeter", name+ " " + title));
        }
        try {
            return ResponseEntity.ok(greeterService.greeter(name, title));
        } catch (MissingArgumentException e) {
            if (name == null && title == null) {
                GreeterError error = new GreeterError("Please provide a name and a title!");
                return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
            }
            if (name == null) {
                GreeterError error = new GreeterError("Please provide a name!");
                return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
            }
            if (title == null) {
                GreeterError error = new GreeterError("Please provide a title!");
                return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
            }
        }
        return null;
    }

    @GetMapping("/appenda/{appendable}")
    public ResponseEntity<?> Appenda(@PathVariable(required = false) String appendable) {
        logRepository.save(logService.log( "/appenda/{appendable}", appendable));
        try {
            return ResponseEntity.ok(appendaService.appenda(appendable));
        } catch (MissingArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/dountil/{action}")
    public ResponseEntity<?> Dountil(@PathVariable String action,
                                     @RequestBody(required = false) Until until) {
        logRepository.save(logService.log( "/dountil/{action}", until.until.toString()));
        try {
            return ResponseEntity.ok(dountilService.dountil(action, until.getUntil()));
        } catch (MissingArgumentException e) {
            return ResponseEntity.ok(new DountilError());

        }
    }

    @PostMapping("/arrays")
    public ResponseEntity<?> Arrays(@RequestBody ArrayNumber what) {
        logRepository.save(logService.log( "/arrays", what.what + " " + Arrays.toString(what.numbers)));
        try {
            return ResponseEntity.ok(arrayService.array(what.what, what.numbers));
        } catch (MissingArgumentException e) {
            return ResponseEntity.ok(new ArrayError());
        }
    }

    @GetMapping("/log")
    public Entries Log() {
        Entries entries = new Entries((List<Log>) logRepository.findAll());
        return entries;
    }
}
