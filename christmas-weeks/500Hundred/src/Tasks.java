import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Tasks {


    private static int task6;

    public static void fileReader(String file) {
        Path path = Paths.get(file);

        List<String> penztar = new ArrayList<>();

        try {
            penztar = Files.readAllLines(path);
        } catch (IOException e) {
            System.out.println("Cant read file!");
            System.exit(1);
        }

//2. Határozza meg, hogy hányszor fizettek a pénztárnál!

        int counter = 0;

        for (int i = 0; i < penztar.size(); i++) {
            if (penztar.get(i).equals("F")) {
                counter += 1;
            }
        }

        System.out.println("Task 2: ");
        System.out.println("The costumers wanted to pay " + counter + " times.");

//3. Írja a képernyőre, hogy az első vásárlónak hány darab árucikk volt a kosarában!

        counter = 0;

        for (int i = 0; i < penztar.size(); i++) {
            if (!penztar.get(i).equals("F")) {
                counter += 1;
            } else {
                break;
            }
        }

        System.out.println("Task 3:");
        System.out.println("The first costumer wanted to buy " + counter + " item.");


//        4. Kérje be a felhasználótól egy vásárlás sorszámát, egy árucikk nevét és egy darabszámot!


        Scanner scanner = new Scanner(System.in);

        System.out.println("Please tipe in a number, then the name of the item and the value!");
        int number = scanner.nextInt();
        String name = scanner.next();
        int value = scanner.nextInt();
        task6 = value;



//5. Határozza meg, hogy a bekért árucikkből
//  a. melyik vásárláskor vettek először, és melyiknél utoljára!
//  b. összesen hány alkalommal vásároltak! ->"ide azt írtam h hányszor vásárolták meg azt a terméket"


        int firstTime = 0;
        int lastTime = 0;
        int totalTimes = 0;
        counter = 1;

        for (int i = 0; i < penztar.size(); i++) {
            if (penztar.get(i).equals("F")) {
                counter += 1;
            }
            if (penztar.get(i).equals(name) && firstTime == 0) {
                firstTime = counter - 1;
            }
            if (penztar.get(i).equals(name)) {
                totalTimes += 1;
            }
            if (i == penztar.lastIndexOf(name)) {
                lastTime = counter;
            }
        }

        System.out.println("Task 5: ");
        System.out.println("The " + firstTime + "th costumer bought it first and the " + lastTime + "th costumer bought is last. In total its occured " + totalTimes + " times.");

//7. Határozza meg, hogy a bekért sorszámú vásárláskor mely árucikkekből és milyen
//mennyiségben vásároltak! Az árucikkek nevét tetszőleges sorrendben megjelenítheti.


        counter = 1;
        Map<String, Integer> itemsAndValue = new HashMap<>();
        for (int i = 0; i < penztar.size(); i++) {

            if (counter == number) {
                if (itemsAndValue.isEmpty()) {
                    for (int j = i; j < penztar.size() - i; j++) {
                        if (penztar.get(j).equals("F")) {
                            break;
                        } else {
                            if (!itemsAndValue.containsKey(penztar.get(j))) {
                                itemsAndValue.put(penztar.get(j), 1);
                            } else {
                                itemsAndValue.compute(penztar.get(j), (key, values) -> values + 1);
                            }
                        }
                    }
                }
            }

            if (penztar.get(i).equals("F")){
                counter += 1;
            }

        }
        
        System.out.println(itemsAndValue);


    }

//6. Határozza meg, hogy a bekért darabszámot vásárolva egy termékből mennyi a fizetendő
//összeg! A feladat megoldásához készítsen függvényt ertek néven, amely a darabszámhoz
//a fizetendő összeget rendeli!

    public static void ertek() {
        int ertek = 0;
        if (task6 < 4) {
            switch (task6) {
                case 0:
                    System.out.println("Empty value");
                    break;

                case 1:
                    ertek = 500;
                    break;

                case 2:
                    ertek = 950;
                    break;

                case 3 :
                    ertek = 1350;
                    break;
            }
        } else {
            ertek = ((task6-3)*400) + 1350;
        }

        System.out.println("Needed money for the certain valu:" + ertek + "ft.");
    }






}
