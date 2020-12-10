import java.util.List;

public class Tree extends Plants {


    public Tree(String color) {
        super(color);
    }

    public void watering(double givedWater, List plante) {
        if (currentWater < 10) {
            double water = givedWater / plante.size();
            currentWater += water * 0.4;
        }
    }

    public void status(Plants plante) {
        if (currentWater < 10) {
            System.out.println("The " + color + " " + getClass().getTypeName() + " needs water!");
        } else {
            System.out.println("The " + color + " " + getClass().getTypeName() + " dosent need water!");
        }
    }

}
