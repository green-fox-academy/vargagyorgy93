import java.util.List;

public class Flower extends Plants {


    public Flower(String color) {
        super(color);
    }

    public void watering(double givedWater, List plante) {
        if (currentWater < 5) {
            double water = givedWater / plante.size();
            currentWater += water * 0.75;
        }
    }

    public void status(Plants plante) {
        if (currentWater < 5) {
            System.out.println("The " + color + " " + getClass().getTypeName() + " needs water!");
        } else {
            System.out.println("The " + color + " " + getClass().getTypeName() + " dosent need water!");
        }
    }


}
