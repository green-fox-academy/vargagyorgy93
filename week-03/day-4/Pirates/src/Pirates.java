import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pirates {

    int drunkness = 0;
    boolean alive = true;
    boolean passOut = false;

    //    List<Pirates> pirates = new ArrayList<>();
//
    public static void main(String[] args) {
//        blabl

    }

    public void pirate(){
        int drunkness = 0;
        boolean alive = true;
        boolean passOut = false;
    }


    public void drinkSomeRum() {
        if (alive = true) {
            drunkness++;
        } else {
            System.out.println("He is dead");
        }
    }

    public void howItGoingMate() {
        if (alive = true) {
            if (drunkness > 5) {
                System.out.println("Pour me anudder!");
            } else {
                System.out.println("Arghh, I'ma Pirate. How d'ya d'ink its goin?");
                drunkness = 0;
            }
        } else {
            System.out.println("He is dead");
        }
    }

    public void die() {
        alive = false;
    }

    public void drawl(Pirates enemy, Pirates pirate){
        Random random = new Random();
        int a = random.nextInt(3);
        if (enemy.alive = true){
            if (a == 1){
                enemy.die();
            }else if (a == 2){
                pirate.die();
            } else {
                enemy.passOut = true;
                pirate.passOut = true;
            }
        }
    }

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
