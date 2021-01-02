package animalprotection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class animalShelter {
    int budget = 50;
    List<animal> animals = new ArrayList<>();
    List<String> adoptersName = new ArrayList<>();

    public int rescue(animal rescuedAnimal){
        animals.add(rescuedAnimal);
        return animals.size();
    }

    public int heal(){
        int healedAnimal = 0;
        for (int i = 0; i < animals.size(); i++) {
            if (!animals.get(i).isHealthy && healedAnimal > 0){
                animals.get(i).heal();
                healedAnimal += 1;
                budget -= animals.get(i).healCost;
            }
        }
        return healedAnimal;
    }

    public void addAdopter(String name){
        adoptersName.add(name);
    }

    public void findNewOwner(){
        Random random = new Random();
        List<Integer> helathyAnimalsIndex = new ArrayList<>();
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).isHealthy){
                helathyAnimalsIndex.add(i);
            }
        }
        if (helathyAnimalsIndex.size() != 0){
            adoptersName = Collections.singletonList(adoptersName.remove(random.nextInt(adoptersName.size())));
            int indexOfRemovabel = helathyAnimalsIndex.get(random.nextInt(helathyAnimalsIndex.size()));
            animals = Collections.singletonList(animals.remove(indexOfRemovabel));
        }

    }

    public int earnDonation(int amountOfDonation){
        budget += amountOfDonation;
        return budget;
    }


    public String toString( ){
     String result = "";
     result = "Budget: " + budget + "€" + "\n" +
             "There are " + animals.size() + " animal (s) and " +
             adoptersName.size() + " potential adopter" + "\n";

        System.out.println(result);
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).isHealthy){
                System.out.println(animals.get(i).getClass().getSimpleName() +
                        " is not healthy ( healing would cost: " + animals.get(i).healCost +
                        " and not adoptable");
            } else {
                System.out.println(animals.get(i).getClass().getSimpleName() +
                        " is healthy and adoptable");
            }
        }

        return result;
    }
}
