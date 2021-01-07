package caloriecounter.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import caloriecounter.demo.model.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class CalorieCounterController {
  private List<Food> foodList = new ArrayList();

  public CalorieCounterController(){
//    foodList.add(new Food("Tofu", 50));
//    foodList.add(new Food("Broccoli", -2));
//    foodList.add(new Food("Even bigger Burger", 2999));
  }

  @GetMapping("/")
  public String landing(Model model){
//    model.addAttribute("name", "Glados");
//    Food food = new Food("Burger",2000);
//    model.addAttribute("food", food);
    model.addAttribute("foods", foodList);
    int totalCalories = calculateTotalCalories();
    model.addAttribute("totalAmount", totalCalories);
    return "index";
  }

  private int calculateTotalCalories(){
   return foodList
                .stream()
                .mapToInt(f -> f.getAmount())
                .sum();
  }

  @PostMapping("/save-food")
  public String saveFood(Food newFood){
    foodList.add(newFood);
    return "redirect:/";
  }

//  @GetMapping("/edit")
//  public String edit(@RequestParam Long foodId, Model model) {
//    Optional<Food> optionalFood = findFood(foodId);
//    if(optionalFood.isPresent()) {
//      Food food = optionalFood.get();
//      model.addAttribute("food", food);
//      return "editFood";
//    }
//    return "redirect:/";
//  }
//
//  @GetMapping("/edit/food/{foodId}")
//  public String editWithPathVariable(@PathVariable Long foodId, Model model){
//    Optional<Food> optionalFood = findFood(foodId);
//    if(optionalFood.isPresent()) {
//      Food food = optionalFood.get();
//      model.addAttribute("food", food);
//      return "editFood";
//    }
//    return "editFood";
//  }
//
//  @PostMapping("/update-food")
//  public String updateFood(@RequestParam Long foodId, Food food){
//    Optional<Food> optionalFood = findFood(foodId);
//    if(optionalFood.isPresent()){
//      Food updatedFood = optionalFood.get();
//      updatedFood.setName(food.getName());
//      updatedFood.setAmount(food.getAmount());
//    }
//    return "redirect:/";
//  }

  private Optional<Food> findFood(Long id){
    return foodList
            .stream()
            .filter(f -> f.getId() == id)
            .findFirst();
  }
}
