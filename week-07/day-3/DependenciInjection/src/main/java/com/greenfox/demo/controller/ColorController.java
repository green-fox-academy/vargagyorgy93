package com.greenfox.demo.controller;

import com.greenfox.demo.service.UtilityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.tags.Param;

@Controller
public class ColorController {
    UtilityService uty = new UtilityService();
    @GetMapping("/useful")
    public String land(){
        return "index";
    }

    @GetMapping("/useful/colored")
    public String colored(Model model){
        model.addAttribute("randomColor", uty.randomColor());
        return "index";
    }

    @GetMapping("/useful/email")
    public String email(Model model, @RequestParam String email){
        model.addAttribute("email", uty.validateEmail(email).get(0));
        model.addAttribute("color", uty.validateEmail(email).get(1));
        return "index";
    }


}
