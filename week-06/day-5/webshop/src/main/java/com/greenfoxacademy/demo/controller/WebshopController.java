package com.greenfoxacademy.demo.controller;

import com.greenfoxacademy.demo.model.ShopItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class WebshopController {

    List<ShopItem> shopItems = new ArrayList<>();

    public WebshopController() {
        shopItems.add(new ShopItem("Running shoes", "Nike running shoes for every day soprt", 1000.0, 5));
        shopItems.add(new ShopItem("Printer", "Some HP printer that will print pages", 3000.0, 2));
        shopItems.add(new ShopItem("Coca cola", "0.5l standard coke", 25.0, 0));
        shopItems.add(new ShopItem("Wokin", "Chicken with fried rice and WOKIN sauce", 119.00, 100));
        shopItems.add(new ShopItem("T-shirt", "Blue with a corgi on bike", 300.00, 1));
    }

    @GetMapping("/webshop")
    public String landing(Model model) {
        model.addAttribute("itemsList", shopItems);
        return "index";
    }

    @GetMapping("/only-available")
    public String onlyAvailable(Model model) {
        List<ShopItem> avaliable = shopItems.stream()
                .filter(s -> s.getQuantityOfStock() != 0)
                .collect(Collectors.toList());
        model.addAttribute("itemsList", avaliable);
        return "index";
    }

    @GetMapping("/cheapest-first")
    public String cheapestFirst(Model model) {
        List<ShopItem> cheapestFirst = shopItems.stream()
                .sorted(Comparator.comparing(ShopItem::getPrice))
                .collect(Collectors.toList());
        model.addAttribute("itemsList", cheapestFirst);
        return "index";
    }

    @GetMapping("/contains-nike")
    public String containsNike(Model model) {
        List<ShopItem> containsNike = shopItems
                .stream()
                .filter(s -> s.getDescription()
                        .toLowerCase()
                        .contains("nike"))
                .collect(Collectors.toList());
        model.addAttribute("itemsList", containsNike);
        if (containsNike.isEmpty()) {
            model.addAttribute("noItemMessage", "No Nike found");
        } else {
            model.addAttribute("noItemMessage", "");
        }
        return "index";
    }

    @GetMapping("/most-expensive-available")
    public String mostExpensiveAvailable(Model model) {
        List<ShopItem> mostExpensiveItem = new ArrayList();
        mostExpensiveItem.add(shopItems.stream()
                .max(Comparator.comparingDouble(ShopItem::getPrice))
                .get());
        model.addAttribute("itemsList", mostExpensiveItem);
        return "index";
    }

    @GetMapping("/average-stock")
    public String averageStock(Model model) {
        Double averageStock = shopItems
                .stream()
                .mapToDouble(ShopItem::getQuantityOfStock)
                .average()
                .orElse(0);
        model.addAttribute("itemsList", averageStock);
        return "average-stock";
    }
}
