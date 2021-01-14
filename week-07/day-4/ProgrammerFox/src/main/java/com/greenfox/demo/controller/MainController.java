package com.greenfox.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    public static Fox fox = new Fox();
    public static List<String> tricksOptions = new ArrayList<>();

    @GetMapping("/")
    public String landing(Model model) {
//        if (fox.getTricks().size() != 0) {
//            fox.getTricks().clear();
//        }
        model.addAttribute("foxName", fox.getName());
        model.addAttribute("foxFood", fox.getFood());
        model.addAttribute("foxDrink", fox.getDrink());
        model.addAttribute("numberOfTricks", fox.getTricks().size());
        model.addAttribute("Tricks", fox.getTricks());
        if (fox.getTricks().size() == 0) {
            model.addAttribute("empty", "You know no tricks, yet. Go and learn some.");
        }
        return "index";
    }

    @GetMapping("/login")
    public String getLogin(@RequestParam(required = false) String name) {
        return "login";
    }

    @PostMapping("/login")
    public String postLogin(Model model, String name) {
        fox.setName(name);
        model.addAttribute("foxName", fox.getName());
        return "redirect:/";
    }

    @GetMapping("/nutrition-store")
    public String getNutritionStore(@RequestParam(required = false) String food) {
        return "nutritionStore";
    }

    @PostMapping("/nutrition-store")
    public String postNutritionStore(Model model, String food, String drink) {
        fox.setFood(food);
        fox.setDrink(drink);
        model.addAttribute("foxFood", fox.getFood());
        model.addAttribute("foxDrink", fox.getDrink());
        return "redirect:/";
    }

    @GetMapping("/trick-center")
    public String getTrickCenter(Model model, @RequestParam(required = false) String trick) {

        tricksOptions.add("write HTML");
        tricksOptions.add("code in Java");
        tricksOptions.add("break dance");
        tricksOptions.add("shoot with gun");
        model.addAttribute("trick1", tricksOptions.get(0));
        model.addAttribute("trick2", tricksOptions.get(1));
        model.addAttribute("trick3", tricksOptions.get(2));
        model.addAttribute("trick4", tricksOptions.get(3));
        return "trickCenter";
    }

    @PostMapping("/trick-center")
    public String postTrickCenter(Model model, String trick) {
        fox.addTricks(trick);
        model.addAttribute("Tricks", fox.getTricks());
        return "redirect:/";
    }

}
