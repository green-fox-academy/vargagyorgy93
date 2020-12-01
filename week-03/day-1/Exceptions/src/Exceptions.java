import java.util.Scanner;

public class Exceptions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int divisor = scanner.nextInt();


        try {
            int result = 12 / divisor; // If the input value for divisor was 0 the program breaks
            System.out.println(result); // The program doesn't reach this line if the input was 0
        } catch (ArithmeticException e) {
            System.out.println("Can't divide by zero!");
        }
    }
}