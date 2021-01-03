package Pirate;

import java.util.ArrayList;
import java.util.List;

public class Ship {
    List<Pirate> pirates = new ArrayList<>();

    public List<String> getPoorPirates() {
        List<String> poorPirates = new ArrayList<>();
        for (int i = 0; i < pirates.size(); i++) {
            if (pirates.get(i).hasWoodenLeg && pirates.get(i).amounOfGold < 15) {
                poorPirates.add(pirates.get(i).name);
            }
        }
        return poorPirates;
    }

    public int getGolds() {
        int sum = 0;
        for (int i = 0; i < pirates.size(); i++) {
            sum += pirates.get(i).amounOfGold;
        }
        return sum;
    }

    public void lastDayOnTheShip() {
        for (int i = 0; i < pirates.size(); i++) {
            pirates.get(i).party();
        }
    }

    public void prepareForBattle() {
        for (int i = 0; i < pirates.size(); i++) {
            for (int j = 0; j < 5; j++) {
                pirates.get(i).work();
            }
        }
            lastDayOnTheShip();
    }


}
