import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

    int a = 0;
    int b = 1;
    int number = a + b;
    int d = 0;

    public int fibonacciIndex(int index){
         if (d < index - 3) {
             a = number - a;
             b= number;
             number = a + b;
             d++;
             return fibonacciIndex(index);
         }

       return number;

    }

    public static void main(String[] args) {
        Fibonacci fibo = new Fibonacci();

        System.out.println(fibo.fibonacciIndex(8));
    }
}
