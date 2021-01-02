package animalprotection;

import java.util.Random;

public class cat extends animal{
    Random random = new Random();

//    public cat(String ownerName, boolean isHealthy, int healCost) {
//        super(ownerName, isHealthy, healCost);
//
//        healCost = random.nextInt( 6);
//    }

    public cat(){
        healCost = random.nextInt( 6);
    }
}
