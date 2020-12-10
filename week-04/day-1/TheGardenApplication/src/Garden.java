import java.util.ArrayList;
import java.util.List;

public class Garden {

    List<Plants> plantes = new ArrayList<>();

    public Garden() {}

    public void addPlants(String plante, String color) {

        if (plante == "Tree") {
            plantes.add(new Tree(color));
        }
        if (plante == "Flower") {
            plantes.add(new Flower(color));
        }
    }

    public void status() {
        for (int i = 0; i < plantes.size(); i++) {
            plantes.get(i).status(plantes.get(i));
        }
        System.out.println();

    }

    public void watering(double givedWater) {
        System.out.println("Watering with " + (int) givedWater);
        for (int i = 0; i < plantes.size(); i++) {
            plantes.get(i).watering(givedWater, plantes);
        }
    }

}
