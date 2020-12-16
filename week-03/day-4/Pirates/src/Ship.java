import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Ship {
    List<Pirate> crew;
    Pirate captain;

    public Ship() {

    }

    public void fillShip() {
        crew = new ArrayList<Pirate>();
        captain = new Pirate();
        crew.add(captain);

        Random rand = new Random();
        int numberOfCrew = rand.nextInt(10)+1;

        for (int i = 0; i < numberOfCrew; i++) {
            crew.add(new Pirate());
        }
    }

    public int aliveOnShip() {
        int alive = 0;
        for (Pirate pirate : crew) {
            if (pirate.dead.equals("alive")) {
                alive += 1;
            }
        }
        return alive;
    }

    public void losses() {

        Random rand = new Random();
        int losses = rand.nextInt(10)+1;
        if (losses > crew.size()) {
            losses = crew.size();
        }

        for (int j = losses; j > 0; j--) {
                crew.get(crew.size() - j).dead = "dead";
        }
    }


    public void party() {
        Random rand = new Random();
        int rum = rand.nextInt(crew.size());

        for (Pirate pirate : crew) {
            if (pirate.dead.equals("alive")) {
                pirate.drunkness += rum;
            }
        }

    }


    public String battle(Ship other) {

        this.losses();
        other.losses();

        int scoreOur = this.aliveOnShip() - this.captain.drinkSomeRumCounter;
        int scoreOther = other.aliveOnShip() - other.captain.drinkSomeRumCounter;

        if (scoreOur > scoreOther) {
            this.party();
            return "true";
        } else {
            other.party();
            return "false";
        }

    }


}