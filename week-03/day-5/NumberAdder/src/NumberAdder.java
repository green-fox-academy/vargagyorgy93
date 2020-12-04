public class NumberAdder {
// Write a recursive function that takes one parameter: n and
// adds numbers from 1 to n.


    public static int numberAdder(int number) {
        if (number == 1) {
            return number;
        }
        return numberAdder(number - 1) + number;
    }


    public static void main(String[] args) {
        int f = numberAdder(5);
        System.out.println(f);
    }

}
