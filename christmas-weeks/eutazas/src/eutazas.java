import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class eutazas {

    public static List<String> travelersData;
    public static List<String> splittedData;

    public static void main(String[] args) {
        readFile("utasadat.txt");
//        getNumberOfPassangers();
//        getNumberOfRejectedPassengers();
//        getMostCrowdedStop();
//        getNumberOfDiscountTickets();
//        createWarning();
    }

    //1. Olvassa be és tárolja el az utasadat.txt fájl tartalmát!
    public static List<String> readFile(String fileName) {
        travelersData = new ArrayList<>();
        Path path = Paths.get(fileName);
        try {
            travelersData = Files.readAllLines(path);
        } catch (IOException e) {
            System.out.println("Can't read file");
            e.printStackTrace();
        }
        return travelersData;
    }

//2. Adja meg, hogy hány utas szeretett volna felszállni a buszra!

    public static int getNumberOfPassangers() {
        System.out.println("Task 2.");
        System.out.println(travelersData.size() + " person wanted to travel on the bus");
        return travelersData.size();
    }

//3. A közlekedési társaság szeretné, ha a járművőn csak az érvényes jeggyel vagy bérlettel
//rendelkezők utaznának. Ezért a jegyeket és bérleteket a buszvezető a felszálláskor ellenőrzi.
//(A bérlet még érvényes a lejárat napján.) Adja meg, hogy hány esetben kellett
//a buszvezetőnek elutasítania az utas felszállását, mert lejárt a bérlete vagy már nem volt
//jegye!

    public static int getNumberOfRejectedPassengers() {
        splittedData = new ArrayList<>();
        int counter = 0;
        for (int i = 0; i < travelersData.size(); i++) {
            splittedData = Arrays.asList(travelersData.get(i).split(" "));
            if (Integer.parseInt(splittedData.get(1).substring(0, 8)) > Integer.parseInt(splittedData.get(4)) && Integer.parseInt(splittedData.get(4)) > 10) {
                counter += 1;
            }
            if (Integer.parseInt(splittedData.get(4)) == 0) {
                counter += 1;
            }
        }
        System.out.println("Task 3");
        System.out.println(counter + " person were rejected.");
        return counter;
    }
//4. Adja meg, hogy melyik megállóban próbált meg felszállni a legtöbb utas! (Több azonos
//érték esetén a legkisebb sorszámút adja meg!)

    public static String getMostCrowdedStop() {
        List<String> otherSplittedData;
        String result = "";
        int counter = 0;
        int mostCrowded = 0;
        String busStop = "";
        for (int i = travelersData.size() - 1; i > 0; i--) {
            splittedData = Arrays.asList(travelersData.get(i).split(" "));
            busStop = splittedData.get(0);
            for (int j = 0; j < travelersData.size(); j++) {
                otherSplittedData = Arrays.asList(travelersData.get(j).split(" "));
                if (otherSplittedData.get(0).equals(busStop)) {
                    counter += 1;
                }
            }
            if (counter >= mostCrowded) {
                mostCrowded = counter;
                result = busStop;
            }
            counter = 0;
        }
        System.out.println("Task 4.");
        System.out.println("The most crowded bust stop wast the " + result + "th bus stop.");
        return result;
    }
//5. A közlekedési társaságnak kimutatást kell készítenie, hogy hányszor utaztak valamilyen
//kedvezménnyel a járművön. Határozza meg, hogy hány kedvezményes és hány ingyenes
//utazó szállt fel a buszra! (Csak az érvényes bérlettel rendelkező szállhatott fel a buszra!)

    public static void getNumberOfDiscountTickets() {
        List<String> otherSplittedData;
        int discount = 0;
        int freeTicket = 0;
        for (int i = 0; i < travelersData.size(); i++) {
            splittedData = Arrays.asList(travelersData.get(i).split(" "));
            if (!splittedData.get(3).equals("FEB") && !splittedData.get(3).equals("JGY") && Integer.parseInt(splittedData.get(1).substring(0, 8)) <= Integer.parseInt(splittedData.get(4))) {
                if (splittedData.get(3).equals("TAB") || splittedData.get(3).equals("NYB")) {
                    discount += 1;
                } else {
                    freeTicket += 1;
                }
            }
        }
        System.out.println("Task 5.");
        System.out.println(freeTicket + " person were traveling with free ticket");
        System.out.println(discount + " person were traveling with discount");
    }
//6. Készítsen függvényt napokszama néven az alábbi algoritmus alapján. Az algoritmus
//a paraméterként megadott két dátumhoz (év, hónap, nap) megadja a közöttük eltelt napok
//számát! (A MOD a maradékos osztást, a DIV az egészrészes osztást jelöli.) Az algoritmust
//a fuggveny.txt fájlban is megtalálja. A függvényt a következő feladat megoldásához
//felhasználhatja.

    public static int numberOfDays(int firstDate, int secoundDate) {
        return firstDate - secoundDate; //A MOD meg DIV részt nem értettem...
    }
//7. A közlekedési társaság azoknak az utasoknak, akiknek még érvényes, de 3 napon belül lejár
//a bérlete, figyelmeztetést szeretne küldeni e-mailben. (Például, ha a felszállás időpontja
//2019. február 5., és a bérlet érvényessége 2019. február 8., akkor már kap az utas levelet,
//ha 2019. február 9. az érvényessége, akkor még nem kap levelet.) Válogassa ki és írja a
//figyelmeztetes.txt állományba ezen utasok kártyaazonosítóját és a bérlet
//érvényességi idejét (éééé-hh-nn formátumban) szóközzel elválasztva!

    public static void createWarning() {
        int endingPeriod = 0;
        int today = 0;
        File file = new File("warning.txt");
        FileWriter fr = null;
        try {
            fr = new FileWriter(file, true);
        } catch (IOException e) {
            System.out.println("Problem at cretaing file writer");
            e.printStackTrace();
        }
        for (int i = 0; i < travelersData.size(); i++) {
            splittedData = Arrays.asList(travelersData.get(i).split(" "));
            endingPeriod = Integer.parseInt(splittedData.get(4));
            today = Integer.parseInt(splittedData.get(1).substring(0, 8));
            if (today <= endingPeriod) {
                if (numberOfDays(endingPeriod, today) <= 3) {
                    try {
                        fr.write(splittedData.get(2) + " " + splittedData.get(4).substring(0, 4) + "-" + splittedData.get(4).substring(4, 6) + "-" + splittedData.get(4).substring(6) + "\n");
                    } catch (IOException e) {
                        System.out.println("Problem with writting in");
                        e.printStackTrace();
                    }
                }
            }
        }
        try {
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
