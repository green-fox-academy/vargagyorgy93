import java.util.ArrayList;
import java.util.List;

public class bunnies2 {
// We have bunnies standing in a line,
// numbered 1, 2, 3, 4, ...
// The odd bunnies (1, 3, ...) have the normal 2 ears.
// The even bunnies (2, 4, ..) we'll say have 3 ears,
// because they each have a raised foot.
// Recursively return the number of "ears" in
// the bunny line 1, 2, ... n (without loops or multiplication).


    public static void bunnie(int numberOfBunnies) {


        if (numberOfBunnies % 2 == 0) {
            System.out.println(2);
        } else {
            System.out.println(3);
        }


        numberOfBunnies = (numberOfBunnies) - 1;

        if (numberOfBunnies == 0) {

        } else {
            bunnie(numberOfBunnies);
        }
    }


    public static void main(String[] args) {

        bunnie(6);
    }

}
