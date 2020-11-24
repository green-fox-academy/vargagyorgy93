import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.*;

import com.sun.nio.sctp.AbstractNotificationHandler;


public class MapIntroduction1 {
    public static void main(String[] args) {
        Map<Integer, Character> map = new HashMap<>();

        if (map.isEmpty()) {
            System.out.println("Empty");
        } else {
            System.out.println("Not Empty");
        }
        map.put(97, 'a');
        map.put(98, 'b');
        map.put(99, 'c');
        map.put(65, 'A');
        map.put(66, 'B');
        map.put(67, 'C');

        for (Integer number : map.keySet()) {
//            int score = map.get(number);

            System.out.println(number);
        }

        for (Character values : map.values()) {

            System.out.println(values);
        }

        map.put(68, 'D');

        System.out.println(map.size());

        System.out.println(map.get(99));

        map.remove(97);

        if (map.containsValue(100)) {
            System.out.println("It contains");
        } else {
            System.out.println("Try again");
        }

        map.clear();


    }
}
