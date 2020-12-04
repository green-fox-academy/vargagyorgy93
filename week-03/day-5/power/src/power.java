public class power {
// Given base and n that are both 1 or more, compute recursively (no loops) the
// value of base to the n power, so powerN(3, 2) is 9 (3 squared).


    public static int powerN(int base, int n) {

        if (n == 1) {
            return base;
        }

        return powerN(base, n - 1) * base;
    }


    public static void main(String[] args) {


        int k = powerN(3, 2);
        System.out.println(k);
    }

}
