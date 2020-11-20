// Create a program that prints all
// the even numbers between 0 and 500

public class PrintEvent {
    public static void main(String[] args) {
        for (int i = 0; i < 501; i++) {
            int a = i % 2;
            if (a == 0) {
                System.out.println(i);
            }

        }
    }
}
