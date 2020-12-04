public class Bunnies {
// We have a number of bunnies and each bunny has two big floppy ears.
// We want to compute the total number of ears
// across all the bunnies recursively (without loops or multiplication).


    public static int bunnies(int numberOfBunnies) {

        if (numberOfBunnies == 0) {
            return numberOfBunnies;
        }

        return bunnies(numberOfBunnies - numberOfBunnies) + (numberOfBunnies * 2);
    }


    public static void main(String[] args) {

        int k = bunnies(9);
        System.out.println(k);

    }
}
