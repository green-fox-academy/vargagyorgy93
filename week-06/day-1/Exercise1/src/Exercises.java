import java.util.Arrays;
import java.util.List;

public class Exercises {
    public static void main(String[] args) {
        exercise4();
    }

    public static void exercise1(){
        List<Integer> numbers = Arrays.asList(1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14);
        numbers.stream().filter(n -> n % 2 == 0).forEach(System.out::println);
    }

    public static void exercise2(){
        List<Integer> numbers = Arrays.asList(1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14);
        numbers.stream().filter(n -> n > 0).forEach(n -> System.out.println(n * n));
    }

    public static void exercise3(){
        List<Integer> numbers = Arrays.asList(3, 9, 2, 8, 6, 5);
        numbers.stream().filter(n -> (n * n) > 20).forEach(System.out::println);
    }

    public static void exercise4(){
        List<Integer> numbers = Arrays.asList(1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14);
        System.out.println(numbers.stream().filter(n -> n % 2 != 0).mapToInt(Integer::intValue).sum());
    }
}
