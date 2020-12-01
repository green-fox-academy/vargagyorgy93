public class DivideByZero {
    public static void main(String[] args) {

        int number = 0;
        try {
            int divide = 10 / number;
            System.out.println(divide);
        } catch (ArithmeticException e) {
            System.out.println("fail");
        }


    }
}
