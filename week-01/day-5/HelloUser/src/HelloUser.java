//public class HelloUser {
//    public static void main(String[] args) {
//        // Modify this program to greet user instead of the World!
//        // The program should ask for the name of the user
//        System.out.println("Hello, World!");
//    }
//}
import java.util.Scanner;
public class HelloUser {
    public static void main(String[] args) {

        System.out.println("Írd be a neved légyszi!");

        Scanner scanner = new Scanner(System.in);

        String user = scanner.nextLine();

        System.out.println("Hello " + user + "!");
    }
}
