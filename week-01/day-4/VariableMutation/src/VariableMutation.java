public class VariableMutation {
    public static void main(String[] args) {
        int a = 3;
        a += 10;
        System.out.println(a);

        int b = 100;
        b -= 7;
        System.out.println(b);

        int c = 44;
        c *= 2;
        System.out.println(c);

        int d = 125;
        d /= 5;
        System.out.println(d);

        int e = 8;
        e /= 4;
        System.out.println(e);

        int f1= 123;
        int f2 = 345;
        System.out.println("f1 nagyobb, mint f2: " + (f1 > f2));

        int g1 = 350;
        int g2 = 200;
        g2 *= 2;
        System.out.println("g2 duplája nagyobb, mint g1: " + (g2 > g1));

        int h1 = 135798745;
        h1 %= 11;
        System.out.println("h1 maradék nélkül osztható 11-el: " + (h1 < 0));

        int i1 = 10;
        int i2 = 3;
        int i22 = i2 * i2;
        int i24 = i22 * i22;
        System.out.println("i1 nagyobb, mint i2 négyzete: " + (i22< i1));
        System.out.println("i1 kisebb, mint i2 a negyediken: " + (i24 > i1));

        int j = 1521;
        int five = j % 5;
        int three = j % 3;
        System.out.println("1521 osztható öttel: " + (five < 1));
        System.out.println("1521 osztható hárommal: " + (three < 1));










    }
}
