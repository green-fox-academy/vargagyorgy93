import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Armada {
    List<Ship> armada;

    public Armada() {
        armada = new ArrayList<>();

        Random rand = new Random();
        int numberOfShips = rand.nextInt(10) + 1;
        for (int i = 0; i < numberOfShips; i++) {
            armada.add(new Ship());
            armada.get(i).fillShip();
        }

    }

    public void twoShipFight(Armada thisArmada, Armada other) {

        Ship ourShip = thisArmada.armada.get(0);
        Ship otherShip = other.armada.get(0);

        ourShip.battle(otherShip);

        if (ourShip.battle(otherShip).equals("true")) {
            other.armada.remove(0);
        } else {
            thisArmada.armada.remove(0);
        }
    }


    public String war(Armada other) {

        for (int i = 0; i < 1000; i++) {


            if (this.armada.size() == 0) {
                return "They won";
            } else if (other.armada.size() == 0) {
                return "We won";
            }
            twoShipFight(this, other);

        }

        return null;
    }
}
