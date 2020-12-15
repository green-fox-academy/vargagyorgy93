import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Pirate {
    int drunkness = 0;
    int drinkSomeRumCounter = 0;
    String passOut = "awake";
    String dead = "alive";

    public void drinkSomeRum() {
        if (dead == "dead") {
            System.out.println("He is dead");
        } else {
            Random random = new Random();
            this.drunkness += random.nextInt(10);
            this.drinkSomeRumCounter += 1;
        }


    }

    public void howsItGoningMate() {
        if (this.dead == "dead") {
            System.out.println("He is dead");
        } else {
            passOut = "awake";
            if (this.drinkSomeRumCounter < 5) {
                System.out.println("Pour me anudder!");
            } else {
                System.out.println("Arghh, I'ma Pirate. How d'ya d'ink its goin?");
                this.passOut = "passed out";
                this.drunkness = 0;
            }

        }

    }

    public void die() {
        this.dead = "dead";
    }

    public void brawl(Pirate other) {
        if (this.dead.equals("alive") && other.dead.equals("alive")) {
            Random rand = new Random();
            int result = rand.nextInt(2);
            switch (result) {
                case 0:
                    System.out.println("Our pirate won.");
                    this.dead = "dead";
                    break;
                case 1:
                    System.out.println("Other pirate won.");
                    other.dead = "dead";
                    break;
                case 2:
                    System.out.println("Bouth of theme died.");
                    this.passOut = "passed out";
                    other.passOut = "passed out";
                    break;
            }
        } else {
            System.out.println("One of them is already dead!");
        }
    }






//    public Pirate(String name){
//        Scanner scanner = new Scanner(System.in);
//        name = scanner.next();
//        this.name = name;
//
//    }
//    public Pirate(){
//
//    }
//
//
//    public void drinkSomeRum() {
//        if (alive = true) {
//            drunkness++;
//        } else {
//            System.out.println("He is dead");
//        }
//    }
//
//    public void howItGoingMate() {
//        if (alive = true) {
//            if (drunkness < 5) {
//                System.out.println("Pour me anudder!");
//            } else {
//                System.out.println("Arghh, I'ma Pirate. How d'ya d'ink its goin?");
////                passOut = true;
//                drunkness = 0;
//            }
//        } else {
//            System.out.println("He is dead");
//        }
//    }
//
//    public void die() {
//        alive = false;
//    }
//
//    public void drawl(Pirate enemy, Pirate pirate){
//        Random random = new Random();
//        int a = random.nextInt(3);
//        if (enemy.alive = true){
//            if (a == 1){
//                enemy.die();
//            }else if (a == 2){
//                pirate.die();
//            } else {
//                enemy.passOut = true;
//                pirate.passOut = true;
//            }
//        }
//    }

//
//
//    public void drinkSomeRum(int witchPirate) {
//        if (pirates.get(witchPirate).alive = true) {
//            pirates.get(witchPirate).drunkness++;
//        } else {
//            System.out.println("He is dead");
//        }
//    }
//
//    public void howItGoingMate(int witchPirate) {
//        if (pirates.get(witchPirate).alive = true) {
//            if (pirates.get(witchPirate).drunkness > 5) {
//                System.out.println("Pour me anudder!");
//            } else {
//                System.out.println("Arghh, I'ma Pirate. How d'ya d'ink its goin?");
//                pirates.get(witchPirate).drunkness = 0;
//            }
//        } else {
//            System.out.println("He is dead");
//        }
//    }
//
//    public void die(int witchPirate) {
//        pirates.get(witchPirate).alive = false;
//    }


}
