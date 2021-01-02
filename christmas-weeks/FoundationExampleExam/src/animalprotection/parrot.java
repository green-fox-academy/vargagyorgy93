package animalprotection;

import java.util.Random;

public class parrot extends animal {
//    public parrot(String ownerName, boolean isHealthy, int healCost) {
//        super(ownerName, isHealthy, healCost);
//    }

    Random random = new Random();

    public parrot() {
        healCost = random.nextInt(10 - 4) + 4;
    }

}
