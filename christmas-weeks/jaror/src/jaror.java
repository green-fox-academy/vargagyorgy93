import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class jaror {
    public static List<String> dataFromFile = new ArrayList<>();
    public static List<List<String>> splittedData = new ArrayList<>();

    public static void main(String[] args) {
        readDataFromFileAndSplit("jarmu.txt");
//        getWorkedHours();
//        getCheckedCarAndTime();
//        getAmountOfDifferentTypes();
//        getLongestTraficlessPeriod();
//        searchForSimilarPlateNumber();
//        writeCheckedCarDataToFile();
    }
//1. Olvassa be a jarmu.txt állományban talált adatokat, s annak felhasználásával oldja meg
//a következő feladatokat!

    public static void readDataFromFileAndSplit(String fileName) {
        Path path = Paths.get(fileName);
        try {
            dataFromFile = Files.readAllLines(path);
        } catch (IOException e) {
            System.out.println("Can't read file");
            System.exit(1);
        }
        for (int i = 0; i < dataFromFile.size(); i++) {
            splittedData.add(Arrays.asList(dataFromFile.get(i).split(" ")));
        }
    }

//2. Határozza meg, hogy aznap legalább hány óra hosszat dolgoztak az ellenőrzést végzők, ha
//munkaidejük egész órakor kezdődik, és pontosan egész órakor végződik! (Minden óra 0
//perc 0 másodperckor kezdődik, és 59 perc 59 másodperccel végződik.) Az eredményt
//jelenítse meg a képernyőn!

    public static void getWorkedHours() {
        int startinHour = 0;
        int finishingHour = 0;
        startinHour = Integer.parseInt(splittedData.get(0).get(0));
        finishingHour = Integer.parseInt(splittedData.get(splittedData.size() - 1).get(0)) + 1;
        System.out.println("Task 2");
        System.out.println("The police worked " + (finishingHour - startinHour) + " hour that day.");

    }
//3. Műszaki ellenőrzésre minden órában egy járművet választanak ki. Azt, amelyik abban az
//órában először halad arra. Az ellenőrzés óráját és az ellenőrzött jármű rendszámát jelenítse
//meg a képernyőn a következő formában: 9 óra: AB-1234! Minden óra adata külön
//sorba kerüljön! Csak azon órák adatai jelenjenek meg, amikor volt ellenőrizhető jármű!

    public static void getCheckedCarAndTime() {
        int time = 0;
        System.out.println("Task 3");
        for (int i = 0; i < splittedData.size(); i++) {
            if (Integer.parseInt(splittedData.get(i).get(0)) > time) {
                time = Integer.parseInt(splittedData.get(i).get(0));
                System.out.println(time + " o'clock: " + splittedData.get(i).get(3));
            }
        }
    }

//4. A rendszám első karaktere külön jelentéssel bír. Az egyes betűk közül a „B” autóbuszt,
//a „K” kamiont, az „M” motort jelöl, a többi rendszámhoz személygépkocsi tartozik.
//Jelenítse meg a képernyőn, hogy az egyes kategóriákból hány jármű haladt el az ellenőrző
//pont előtt!

    public static void getAmountOfDifferentTypes() {
        int bus = 0;
        int camion = 0;
        int motor = 0;
        int car = 0;
        for (int i = 0; i < splittedData.size(); i++) {
            if (splittedData.get(i).get(3).charAt(0) == 'B') {
                bus += 1;
            }
            if (splittedData.get(i).get(3).charAt(0) == 'K') {
                camion += 1;
            }
            if (splittedData.get(i).get(3).charAt(0) == 'M') {
                motor += 1;
            }
            if (splittedData.get(i).get(3).charAt(0) != 'B' &&
                    splittedData.get(i).get(3).charAt(0) != 'K' &&
                    splittedData.get(i).get(3).charAt(0) != 'M') {
                car += 1;
            }
        }
        System.out.println("Task 4");
        System.out.println("The number of cars was: " + car);
        System.out.println("The number of buses was: " + bus);
        System.out.println("The number of camions was: " + camion);
        System.out.println("The number of motors was: " + motor);
    }
//5. Mettől meddig tartott a leghosszabb forgalommentes időszak? A választ jelenítse meg
//a képernyőn a következő formában: 9:9:13 - 9:15:3!

    public static void getLongestTraficlessPeriod() {
        String result = "";
        int longestTraffickersPeriod = 0;
        for (int i = 1; i < splittedData.size(); i++) {
            if ((timeFromString(i) - timeFromString(i - 1)) > longestTraffickersPeriod) {
                longestTraffickersPeriod = (timeFromString(i) - timeFromString(i - 1));
                result = splittedData.get(i - 1).get(0) + ":" + splittedData.get(i - 1).get(1) + ":" +
                        splittedData.get(i - 1).get(2) + " - " + splittedData.get(i).get(0) + ":" +
                        splittedData.get(i).get(1) + ":" +
                        splittedData.get(i).get(2) + "!";
            }
        }
        System.out.println("Task 5");
        System.out.println(result);
    }

    public static int timeFromString(int i) {
        return (Integer.parseInt(splittedData.get(i).get(0)) * 3600) +
                (Integer.parseInt(splittedData.get(i).get(1)) * 60) +
                Integer.parseInt(splittedData.get(i).get(2));
    }

//6. A rendőrök egy baleset közelében látott járművet keresnek rendszám alapján.
//A szemtanúk csak a rendszám bizonyos karaktereire emlékeztek, így a rendszám
//ismeretlen karaktereit a * karakterrel helyettesítve keresik a nyilvántartásban. Kérjen be
//a felhasználótól egy ilyen rendszámot, majd jelenítse meg a képernyőn az arra illeszthető
//rendszámokat! (K*-95*8)

    public static void searchForSimilarPlateNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please type in the plate number!");
        String plateToFind = scanner.next();
        String possibelMatch = "";
        String matching = "";
        List<String> matches = new ArrayList<>();
        for (int i = 0; i < splittedData.size(); i++) {
            possibelMatch = splittedData.get(i).get(3);
            for (int j = 0; j < plateToFind.length(); j++) {
                if (plateToFind.charAt(j) == possibelMatch.charAt(j) || plateToFind.charAt(j) == '*') {
                    matching += possibelMatch.charAt(j);
                }
            }
            if (plateToFind.length() == matching.length()) {
                matches.add(matching);
            }
            matching = "";
        }
        System.out.println(matches);
    }

//7. Egy közúti ellenőrzés pontosan 5 percig tart. Amíg az ellenőrzés folyik, a járművek
//szabadon elhaladhatnak, a következő megállítására csak az ellenőrzés befejezése után
//kerül sor. Ha a rendőrök a legelső járművet ellenőrizték, akkor mely járműveket tudták
//ellenőrizni a szolgálat végéig? Írja az ellenőrzött járművek áthaladási idejét és rendszámát
//a vizsgalt.txt állományba az áthaladás sorrendjében, a bemenettel egyező formában!
//Ügyeljen arra, hogy az időadatokhoz tartozó számok a bevezető nullákat tartalmazzák!

    public static void writeCheckedCarDataToFile() {
        File file = new File("vizsgalt.txt");
        FileWriter fr = null;
        int seconds = 0;
        int step = 0;
        try {
            fr = new FileWriter(file, true);
        } catch (IOException e) {
            System.out.println("Problem at creating file writer");
            System.exit(2);
        }
        for (int i = 0; i < dataFromFile.size(); i++) {
            if (timeFromString(dataFromFile.size() - 1) - timeFromString(i) > 300) {
                try {
                    fr.write(dataFromFile.get(i) + "\n");
                } catch (IOException e) {
                    System.out.println("Problem with writting in");
                    System.exit(3);
                }
                while (seconds <= 300) {
                    step += 1;
                    seconds = timeFromString(i + step) - timeFromString(i);
                }
                seconds = 0;
                if (step > 1) {
                    step -= 1;
                    i += step;
                }
                step = 0;
            }
        }
        try {
            fr.close();
        } catch (IOException e) {
            System.exit(4);
        }
    }

}
