//public class MileToKmConverter {
//    public static void main(String[] args) {
//        // Write a program that asks for a double that is a distance in miles,
//        // then it converts that value to kilometers and prints it
//    }
//}

import java.util.Scanner;

public class MileToKmConverter {
    public static void main(String[] args) {

        System.out.println("Please type in the distance you want to concert into kilometer!");

        Scanner scanner = new Scanner(System.in);

        double miles = scanner.nextDouble();

        double kilometer = miles * 1.61;

        System.out.println("Kilmoeter: " + kilometer);


    }
}
