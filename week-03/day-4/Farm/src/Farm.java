import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Farm {

    int currentHunger = 50;
    int leastHungry = 0;
    List<Animal> animals = new ArrayList<>();

    Random random = new Random();
    int slots = random.nextInt(10);

    public void breed() {
        if (slots > 0) {
            animals.add(new Animal());
        }

    }

    public void slaughter() {

        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).hunger < currentHunger) {
                currentHunger = animals.get(i).hunger;
                leastHungry = i;
            }
        }
        animals.remove(leastHungry);

    }


}
