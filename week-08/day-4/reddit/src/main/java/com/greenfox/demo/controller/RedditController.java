package com.greenfox.demo.controller;

import com.greenfox.demo.model.Post;
import com.greenfox.demo.service.RedditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RedditController {

    private RedditService redditService;

    @Autowired
    public RedditController(RedditService redditService) {
        this.redditService = redditService;
    }

    @RequestMapping(value = {"/", "/{pageNumber}"})
    public String landing(Model model, @PathVariable(required = false) Long pageNumber) {
        model.addAttribute("postList", redditService.getPostListInOrder(pageNumber));
        model.addAttribute("pagesList", redditService.getPagesList());
        return "index";
    }

    @GetMapping("/new-post")
    public String getNewPost() {
        return "newPost";
    }

    @PostMapping("/new-post")
    public String postNewPost(@ModelAttribute Post post) {
        redditService.addNewPost(post);
        return "redirect:/";
    }

    @GetMapping("/{id}/ratingUp")
    public String ratingUp(@PathVariable Long id) {
        redditService.ratingUp(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/ratingDown")
    public String ratingDown(@PathVariable Long id) {
        redditService.ratingDown(id);
        return "redirect:/";
    }
}
