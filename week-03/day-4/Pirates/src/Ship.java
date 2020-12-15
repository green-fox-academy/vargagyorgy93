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
        int numberOfCrew = rand.nextInt(10);

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
        int losses = rand.nextInt(10);

        for (int j = crew.size(); j > 0; j--) {
            if (losses > crew.size()) {
                losses = crew.size();
            }
            while (losses == 0) {
                crew.get(j).dead = "dead";
                losses -= 1;
            }
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

//    public void fillShip() {
//
//        Random random = new Random();
//
//        List<Pirate> crew = new ArrayList<Pirate>();
//
//        crew.add(new Captain());
//        for (int i = 0; i < random.nextInt(10); i++) {
//            crew.add(new Pirate());
//        }
//
//        personsOnShip = crew;
//
//    }
//
//    public void shipStatus(Ship ship) {
//        System.out.print("The captain is already drunked some rum " + ship.personsOnShip.get(0).drunkness + " times. ");
//        if (ship.personsOnShip.get(0).alive && !ship.personsOnShip.get(0).passOut) {
//            System.out.println("He is alive and he is conscious.");
//        } else if (ship.personsOnShip.get(0).alive && ship.personsOnShip.get(0).passOut) {
//            System.out.println("He is alive, but unconscious.");
//        } else {
//            System.out.println("Captain is dead");
//        }
//
//        for (int i = 0; i < ship.personsOnShip.size(); i++) {
//            if (ship.personsOnShip.get(i).alive) {
//                alivePirates += 1 ;
//            }
//
//        }
//        System.out.println("The number of pirates alive on the ship is: " + alivePirates);
//        alivePirates = 0;
//        System.out.println();
//
//    }
//
//    public boolean shipBattle(Ship otherShip) {
//
//
//        Random random = new Random();
//        int lossesOther = random.nextInt(otherShip.personsOnShip.size());
//        int lossesThis = random.nextInt(personsOnShip.size());
//
//
//        int score1 = (this.personsOnShip.size() - lossesThis) + this.personsOnShip.get(0).drunkness;
//        int score2 = (otherShip.personsOnShip.size() - lossesOther) + otherShip.personsOnShip.get(0).drunkness;
//
//        if (score1 > score2) {
//            System.out.println("Our ship has won");
//            System.out.println();
//            return true;
//        } else {
//            System.out.println("Other ship has won");
//            System.out.println();
//            return false;
//        }
//
//
//    }


//    public static void crew (Pirate pirate1, Pirate pirate2) {
//        List<Pirate> crew = new ArrayList<Pirate>();
//
////        Pirates pirate1 = new Pirates();
//
//        crew.add(pirate1);
//        crew.add(pirate2);
//
//        System.out.println(pirate1.drunkness);
//
//
//    }



