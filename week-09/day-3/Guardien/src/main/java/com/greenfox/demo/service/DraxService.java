package com.greenfox.demo.service;

import com.greenfox.demo.model.Food;
import com.greenfox.demo.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DraxService {

    FoodRepository foodRepository;

    @Autowired
    public DraxService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public List<Food> getDraxFoodList(){
        List<Food> draxFoodList = (List<Food>) foodRepository.findAll();
        return draxFoodList;
    }

    public List<Food> addNewFoodToList(String name, Integer amount, Integer calorie){
        Food food = new Food(name, amount, calorie);
        foodRepository.save(food);
        List<Food> draxFoodList = (List<Food>) foodRepository.findAll();
        return draxFoodList;
    }

    public List<Food> deleteFoodFromList(String name){
        List<Food> draxFoodList = (List<Food>) foodRepository.findAll();
        Long id = 0L;
        for (int i = 0; i < draxFoodList.size(); i++) {
            if (getDraxFoodList().get(i).getName().equals(name)) {
                id = getDraxFoodList().get(i).getId();
            }
        }
        foodRepository.deleteById(id);
        System.out.println(id);
        return (List<Food>) foodRepository.findAll();
    }

    public List<Food> changeAmountOfFood(String name, Integer newAmount){
        List<Food> draxFoodList = (List<Food>) foodRepository.findAll();
        Long id = 0L;
        for (int i = 0; i < draxFoodList.size(); i++) {
            if (getDraxFoodList().get(i).getName().equals(name)) {
                id = getDraxFoodList().get(i).getId();
            }
        }
        if (foodRepository.findById(id).isPresent()) {
            foodRepository.findById(id).get().setAmount(newAmount);
        }
        System.out.println(id);
        return (List<Food>) foodRepository.findAll();
    }
}
