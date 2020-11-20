//public class OddEven {
//    public static void main(String[] args) {
//        // Write a program that reads a number from the standard input,
//        // Then prints "Odd" if the number is odd, or "Even" if it is even.
//    }
//}
import java.util.Scanner;

public class OddEven {
    public static void main(String[] args) {
        System.out.println("Write in a number you want to test!");

        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();
        int even = userInput % 2;

        if (even < 1){
            System.out.println("The number is even!");
        } else {
            System.out.println("The number is odd!");
        }

    }
}
