import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class ListIntroduction2 {
    public static void main(String[] args) {
        List<String> ListA = new ArrayList<>();
        ListA.add("Apple");
        ListA.add("Avocado");
        ListA.add("Bluberries");
        ListA.add("Durian");
        ListA.add("Lychee");

        List<String> ListB = new ArrayList<>();

        ListB.addAll(ListA);

        if (ListA.contains("Durian")) {
            System.out.println("Yesss");
        } else {
            System.out.println("Nooooooo");
        }

        ListB.remove("Durian");

        ListA.add(4, "Kiwifurit");

        if (ListA.size() > ListB.size()) {
            System.out.println("A nagyobb");
        } else {
            System.out.println("B nagyobb");
        }

        System.out.println(ListA.indexOf("Avocado"));

        System.out.println(ListB.indexOf("Durain"));

        ListB.addAll(Arrays.asList("Passion Fruit", "Pomelo"));

        System.out.println(ListB);
        System.out.println(ListA.get(2));


    }
}
