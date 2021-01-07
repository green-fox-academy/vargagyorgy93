package calorieapp.demo.controller;

import calorieapp.demo.model.Food;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class CalorieCounterController {

  private List<Food> foodList = new ArrayList<>();

  public CalorieCounterController() {
    foodList.add(new Food("Tofu", 50));
    foodList.add(new Food("Gulyásleves", 800));
    foodList.add(new Food("Brokkoli", -9000));
  }

  //@RequestMapping(method = RequestMethod.GET, value = "")
  @GetMapping("")
  public String landing(@RequestParam(required = false, defaultValue = "World!") String greeting, Model model) {
    model.addAttribute("name", greeting);
    Food food = new Food("Burger!",2000);
    model.addAttribute("foodName", food.getName());
    model.addAttribute("amount", food.getAmount());
    model.addAttribute("foodList", foodList);
    int caloriesEaten = calculateCaloriesEaten();
    model.addAttribute("caloriesEaten", caloriesEaten);
    return "index";
  }

  private int calculateCaloriesEaten(){
    return foodList
            .stream()
            .mapToInt(f -> f.getAmount())
            .sum();
  }

  @PostMapping("/save-food")
  public String saveFood(Food food){
    foodList.add(food);
    return "redirect:/";
  }

  @GetMapping("/edit")
  public String edit(@RequestParam Long foodId){
    Optional<Food> optionalFood = getFoodById(foodId);

    if (optionalFood.isPresent()){
      return "editFood";
    }
    return "redirect:/";
  }

  @PostMapping("/updateFood")
  public String update(@RequestParam Long foodId, Food food){
    Optional<Food> optionalFood = getFoodById(foodId);
    if(optionalFood.isPresent()){
      Food storedFood = optionalFood.get();
      storedFood.setName(food.getName());
      storedFood.setAmount(food.getAmount());
    }
    return "redirect:/";
  }

  private Optional<Food> getFoodById(Long id){
    return foodList
            .stream()
            .filter(f -> f.getId() == id)
            .findFirst();
  }
}
