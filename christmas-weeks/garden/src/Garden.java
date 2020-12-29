import java.util.ArrayList;
import java.util.List;

public class Garden {
    public static List<Plantes> garden = new ArrayList<>();

    public void watering(int waterAmount) {
        System.out.println("Watering with " + waterAmount);
        for (int i = 0; i < garden.size(); i++) {
            garden.get(i).drink(waterAmount / garden.size());
        }
    }

    public void add(Plantes plante) {
        garden.add(plante);
    }

    public void status() {
        for (int i = 0; i < garden.size(); i++) {
            if (garden.get(i).isNeedWater()) {
                System.out.println("The " + garden.get(i).color + " " + garden.get(i).getClass().getSimpleName() + " needs water");
            } else {
                System.out.println("The " + garden.get(i).color + " " + garden.get(i).getClass().getSimpleName() + " doesn't needs water");
            }
        }
        System.out.println();
    }
}
