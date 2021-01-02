package animalprotection;

import java.util.Random;

public class dog extends animal{
    Random random = new Random();
//    public dog(String ownerName, boolean isHealthy, int healCost) {
//        super(ownerName, isHealthy, healCost);
//
//        healCost = random.nextInt(8-1) + 1;
//    }

    public dog(){
        healCost = random.nextInt(8-1) + 1;
    }
}
