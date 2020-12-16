import java.util.List;

public class Carrier {
    List<Aircraft> aircrafts;
    int storedAmmo = 0;
    int healthPoint = 0;

    public Carrier(int storedAmmo, int healthPoint) {
        this.storedAmmo = storedAmmo;
        this.healthPoint = healthPoint;
    }

    public void add() {
        aircrafts.add(new Aircraft());
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
}
