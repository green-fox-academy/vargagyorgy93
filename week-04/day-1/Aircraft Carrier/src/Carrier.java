import java.util.ArrayList;
import java.util.List;

public class Carrier {
    List<Aircraft> aircrafts;
    int storedAmmo = 0;
    int healthPoint = 0;
    int totalDamage =0;


    public Carrier(int storedAmmo, int healthPoint) {
        aircrafts = new ArrayList<>();
        this.storedAmmo = storedAmmo;
        this.healthPoint = healthPoint;
    }

    public void add(int baseDamage, int maxAmmo, String type) {
//        Aircraft aircraft1 = new Aircraft(aircraft);
        aircrafts.add(new Aircraft(baseDamage, maxAmmo, type));
    }

    public int neededAmmo(Carrier carrier) {
        int neddedAmmo = 0;
        for (int i = 0; i < carrier.aircrafts.size(); i++) {
            neddedAmmo += carrier.aircrafts.get(i).getMaxAmmo();
        }
        return neddedAmmo;
    }

    public void fill() {

        for (int i = 0; i < aircrafts.size(); i++) {
            if (storedAmmo > this.neededAmmo(this)) {
                if (aircrafts.get(i).getAmmunition() != aircrafts.get(i).getMaxAmmo()) {
                    aircrafts.get(i).refill(storedAmmo);
                    storedAmmo -= aircrafts.get(i).getMaxAmmo();
                }
            } else {
                if (aircrafts.get(i).isPriority() && aircrafts.get(i).getAmmunition() != aircrafts.get(i).getMaxAmmo()) {
                    aircrafts.get(i).refill(storedAmmo);
                    storedAmmo -= aircrafts.get(i).getMaxAmmo();
                } else if (!aircrafts.get(i).isPriority() && aircrafts.get(i).getAmmunition() != aircrafts.get(i).getMaxAmmo()) {


                    for (int j = 0; j < aircrafts.size(); j++) {
                        if (aircrafts.get(j).isPriority() && aircrafts.get(i).getAmmunition() != aircrafts.get(i).getMaxAmmo()) {
                            aircrafts.get(i).refill(storedAmmo);
                            storedAmmo -= aircrafts.get(i).getMaxAmmo();
                        }
                    }

                    aircrafts.get(i).refill(storedAmmo);
                    storedAmmo -= aircrafts.get(i).getMaxAmmo();
                }
            }
        }

    }


    public void figth(Carrier other){
        for (int i = 0; i < aircrafts.size(); i++) {
            aircrafts.get(i).figt();
            totalDamage += aircrafts.get(i).getAllDamage();
        }
        other.healthPoint -= totalDamage;
    }
    

    public void getStatus(){

//        totalDamage =0;

        if (this.healthPoint == 0){
            System.out.println("It's dead Jim :(");
        } else {
            System.out.println("HP: " + healthPoint + ", " + "Aircraft count: "
                    + aircrafts.size() + ", " + "Ammo Storage:" + storedAmmo + ", " + "Total damage: "
                    + totalDamage);
            System.out.println("Aircrafts:");
            for (int i = 0; i < aircrafts.size(); i++) {
                System.out.println(aircrafts.get(i).getStatus());
//                aircrafts.get(i).getStatus();
                totalDamage += aircrafts.get(i).getAllDamage();
            }
            System.out.println();

        }

    }


}
