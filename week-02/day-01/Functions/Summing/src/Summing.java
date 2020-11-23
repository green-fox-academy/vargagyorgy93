// Create the usual class wrapper and main method on your own.

// Write a function called `sum` that returns the sum of
// numbers from zero to the given parameter

public class Summing {
    public static void main(String[] args) {
        int a = 5;
        sum(a);
    }

    public static void sum(int a) {
        int sum = 0;

        for (int i = 0; i <= a; i++) {
            sum += i;
        }
        System.out.println("Sum is " + sum);
    }

}

