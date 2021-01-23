package com.greenfox.demo.controller;

import com.greenfox.demo.model.Assignee;
import com.greenfox.demo.model.Todo;
import com.greenfox.demo.repository.AssigneeRepository;
import com.greenfox.demo.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class TodoController {

    private Repository repository;
    private AssigneeRepository assigneeRepository;

    @Autowired
    public TodoController(Repository repository, AssigneeRepository assigneeRepository) {
        this.assigneeRepository = assigneeRepository;
        this.repository = repository;
    }

    @GetMapping(value = "/")
    public String index(){
        return "index";
    }

//    @GetMapping("/todo")
//    public String todoController(Model model){
//        model.addAttribute("todos", repository.findAll());
//        return "todolist";
//    }

    @GetMapping("/list")
    public String list(Model model, @RequestParam (required = false) Boolean isDone){
        if (isDone == null){
            List<Todo> whatisDone = (List<Todo>) repository.findAll();
            model.addAttribute("todos", whatisDone);
        } else {
            List<Todo> whatisDone = (List<Todo>) repository.findAll();
            whatisDone = whatisDone.stream().filter(r -> r.done == isDone)
                    .collect(Collectors.toList());
            model.addAttribute("todos", whatisDone);
        }
        return "todolist";
    }

    @PostMapping("/list")
    public String postList(Model model, @RequestParam String findTodo){
        List<Todo> findedTodoes = (List<Todo>) repository.findAll();
        findedTodoes = findedTodoes.stream().filter(w -> w.title.contains(findTodo))
                .collect(Collectors.toList());
        model.addAttribute("todos", findedTodoes);
        return "todolist";
    }

    @GetMapping("/list/addNew")
    public String getAddNewTodo(@RequestParam(required = false) String newTodo){
        return "addNewTodo";
    }

    @PostMapping("/list/addNew")
    public String postAddNewTodo(@RequestParam String newTodo){
        repository.save(new Todo(newTodo));
        return "redirect:/list";
    }

    @GetMapping("/listOfAssignees")
    public String listOfAssignees(Model model){
        List<Assignee> listOfAssignees = (List<Assignee>) assigneeRepository.findAll();
//        listOfAssignees.add(new Assignees("Mari", "marika@greenfox.com"));
        model.addAttribute("listOfAssignees", listOfAssignees);
        return "listOfAssignees";
    }

}
