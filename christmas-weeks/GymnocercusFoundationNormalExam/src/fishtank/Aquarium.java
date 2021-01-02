package fishtank;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    List<Fish> fishes = new ArrayList<>();

    public void addFish(Fish fish) {
        fishes.add(fish);
    }

    public void feed() {
        for (int i = 0; i < fishes.size(); i++) {
            fishes.get(i).feed();
        }
    }

    public void removeFish() {
        List<Fish> checkFishes = fishes;
        for (int i = 0; i < checkFishes.size(); i++) {
            if (checkFishes.get(i).weight >= 11) {
                fishes.remove(fishes.get(i));
            }
        }
    }

    public void getStatus() {
        for (int i = 0; i < fishes.size(); i++) {
            fishes.get(i).status();
        }
    }
}
