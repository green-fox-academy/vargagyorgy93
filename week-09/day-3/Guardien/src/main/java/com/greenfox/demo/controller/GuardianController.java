package com.greenfox.demo.controller;

import com.greenfox.demo.model.Groot;
import com.greenfox.demo.model.GrootError;
import com.greenfox.demo.model.MissingArgumentException;
import com.greenfox.demo.service.DraxService;
import com.greenfox.demo.service.GrootService;
import com.greenfox.demo.service.RocketService;
import com.greenfox.demo.service.YonduService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GuardianController {

    GrootService grootService;
    YonduService yonduService;
    RocketService rocketService;
    DraxService draxService;

    @Autowired
    public GuardianController(GrootService grootService, YonduService yonduService,
                              RocketService rocketService, DraxService draxService){
        this.grootService = grootService;
        this.yonduService = yonduService;
        this.rocketService = rocketService;
        this.draxService = draxService;
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

    @GetMapping("/yondu")
    public ResponseEntity<?> yondu(@RequestParam(required = false) Double distance,
                                   @RequestParam(required = false) Double time){
        try {
            return ResponseEntity.ok(yonduService.countSpeed(distance,time));
        } catch (MissingArgumentException e) {
            GrootError error = new GrootError();
            return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/rocket")
    public ResponseEntity<?> rocket(){
        return ResponseEntity.ok(rocketService.getCargo());
    }

    @GetMapping("/rocket/fill")
    public ResponseEntity<?> fillRocket(@RequestParam(required = false) String caliber,
                                        @RequestParam(required = false) Integer amount) {
       try {
           return ResponseEntity.ok(rocketService.getCargoStatus(caliber, amount));
       } catch (MissingArgumentException e) {
           GrootError error = new GrootError();
           return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
       }
    }

    @GetMapping("/drax")
    public ResponseEntity<?> drax(){
        return ResponseEntity.ok(draxService.getDraxFoodList());
    }

    @GetMapping("/drax/addNewFood")
    public ResponseEntity<?> draxAddNewFodd(@RequestParam String name,
                                            @RequestParam Integer amount,
                                            @RequestParam Integer calorie){
        return ResponseEntity.ok(draxService.addNewFoodToList(name, amount, calorie));
    }

    @GetMapping("/drax/deleteFood")
    public ResponseEntity<?> draxDeleteFoodFromList(@RequestParam String name){
        return ResponseEntity.ok(draxService.deleteFoodFromList(name));
    }

    @GetMapping("/drax/changeAmountOfFood")
    public ResponseEntity<?> draxChangeAmountOfCertainFood(@RequestParam String name, @RequestParam Integer newAmount){
        return ResponseEntity.ok(draxService.changeAmountOfFood(name, newAmount));
    }

}
