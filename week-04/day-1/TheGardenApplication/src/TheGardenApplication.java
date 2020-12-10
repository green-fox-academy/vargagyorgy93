import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class TheGardenApplication {
    public static void main(String[] args) {


        Garden garden = new Garden();
        garden.addPlants("Flower", "yellow");
        garden.addPlants("Flower", "blue");
        garden.addPlants("Tree", "purple");
        garden.addPlants("Tree", "orange");

        garden.status();
        garden.watering(40);
        garden.status();

        garden.watering(70);
        garden.status();

    }


}
