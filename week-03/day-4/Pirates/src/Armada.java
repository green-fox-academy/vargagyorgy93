import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Armada {
    List<Ship> armada;

    public Armada() {
        armada = new ArrayList<>();

        Random rand = new Random();
        int numberOfShips = rand.nextInt(10);
        for (int i = 0; i < numberOfShips; i++) {
            armada.add(new Ship());
            armada.get(i).fillShip();
        }

    }


    public void war(Armada other){
        while(this.armada.size() == 0 || other.armada.size() == 0) {
            for (int i = 0; i < 1; i++) {
                this.armada.get(i).battle(other.armada.get(i));
                if (this.armada.get(i).battle(other.armada.get(i)).equals("true")) {
                    other.armada.remove(other.armada.size());
                } else {
                    this.armada.remove(this.armada.size());
                }
            }
        }

    }
}
