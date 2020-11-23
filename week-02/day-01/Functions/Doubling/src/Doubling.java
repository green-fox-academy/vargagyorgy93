//public class Doubling {
//    public static void main(String[] args) {
//// - Create an integer variable named `baseNum` and assign the value `123` to it
//// - Create a function called `doubling` that doubles it's input parameter and returns with an integer
//// - Print the result of `doubling(baseNum)`
//    }
//}

public class Doubling {
    public static void main(String[] args) {
        int baseNUm = 123;
        doubling(baseNUm);
    }

    public static void doubling(int a) {
        a *= 2;

        System.out.println(a);

    }
}

