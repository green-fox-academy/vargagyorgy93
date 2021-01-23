package com.greenfox.demo.controller;

import com.greenfox.demo.model.Todo;
import com.greenfox.demo.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TodoController {

    private Repository repository;

    @Autowired
    public TodoController(Repository repository) {
        this.repository = repository;
    }

    @GetMapping(value = {"/","/list"})
    public String index(){
        return "index";
    }

    @GetMapping("/todo")
    public String todoController(Model model){
        model.addAttribute("todos", repository.findAll());
        return "todolist";
    }

    @GetMapping("/list")
    public String list(){
        return "todolist";
    }
}
