import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.*;

public class cegesauto {

    public static List<String> autoDatas;
    public static List<String> splittedDatas;
    public static Scanner scanner = new Scanner(System.in);
    public static HashMap<String, Integer> cars;


    public static void main(String[] args) {
        readFile("autok.txt");
//        getLastTookedCar();
//        getMovedCarsForGivenDay();
//        getCarsStillOut();
//        howMuchEachCarTraveled();
//        getWhoDroveTheCarTheFarest("CEG301");
//        createWaybill();
    }
//1. Olvassa be és tárolja el az autok.txt fájl tartalmát!

    public static List<String> readFile(String fileName) {
        autoDatas = new ArrayList<>();
        Path path = Paths.get(fileName);
        try {
            autoDatas = Files.readAllLines(path);
        } catch (IOException e) {
            System.out.println("Can't read file");
            e.printStackTrace();
        }
        return autoDatas;

    }
//2. Adja meg, hogy melyik autót vitték el utoljára a parkolóból! Az eredményt a mintának
//megfelelően írja a képernyőre!


    public static void getLastTookedCar() {
        splittedDatas = new ArrayList<>();
        String lastCar = "";
        for (int i = 0; i < autoDatas.size(); i++) {
            splittedDatas = Arrays.asList(autoDatas.get(i).split(" "));
            if (splittedDatas.get(5).equals("0")) {
                lastCar = splittedDatas.get(2);
            }
        }
        System.out.println("Task 2.");
        System.out.println(splittedDatas.get(0) + "th day palte numbar: " + lastCar);
    }
//3. Kérjen be egy napot és írja ki a képernyőre a minta szerint, hogy mely autókat vitték ki és
//hozták vissza az adott napon!


    public static void getMovedCarsForGivenDay() {
        System.out.println("Please tipe in the day you want to chack");
        String givenDay = scanner.next();
        System.out.println("Task 3.");
        System.out.println("Day : " + givenDay);
        System.out.println("Trafick at day " + givenDay);
        for (int i = 0; i < autoDatas.size(); i++) {
            splittedDatas = Arrays.asList(autoDatas.get(i).split(" "));
            if (splittedDatas.get(0).equals(givenDay)) {
                if (splittedDatas.get(5).equals("0")) {
                    System.out.println(splittedDatas.get(1) + " " + splittedDatas.get(2) + " " + splittedDatas.get(3) + " ki");
                } else {
                    System.out.println(splittedDatas.get(1) + " " + splittedDatas.get(2) + " " + splittedDatas.get(3) + " be");
                }
            }
        }
    }
//4. Adja meg, hogy hány autó nem volt bent a hónap végén a parkolóban!

    public static int getCarsStillOut() {
        int out = 0;
        for (int i = 0; i < autoDatas.size(); i++) {
            splittedDatas = Arrays.asList(autoDatas.get(i).split(" "));
            if (splittedDatas.get(5).equals("0")) {
                out += 1;
            } else {
                out -= 1;
            }
        }
        System.out.println("At the end of the mounth " + out + " cars was outside.");
        return out;
    }

//5. Készítsen statisztikát, és írja ki a képernyőre mind a 10 autó esetén az ebben a hónapban
//megtett távolságot kilométerben! A hónap végén még kint lévő autók esetén az utolsó
//rögzített kilométerállással számoljon! A kiírásban az autók sorrendje tetszőleges lehet.

    public static void howMuchEachCarTraveled() {
        cars = new HashMap<>();
        String car = "";
        String carBeginingKm = "";
        String carEndingKm = "";
        for (int i = 0; i < autoDatas.size(); i++) {
            splittedDatas = Arrays.asList(autoDatas.get(i).split(" "));
            car = splittedDatas.get(2);
            if (!cars.containsKey(car)) {
                carBeginingKm = splittedDatas.get(4);
                for (int j = 0; j < autoDatas.size(); j++) {
                    splittedDatas = Arrays.asList(autoDatas.get(j).split(" "));
                    if (splittedDatas.get(2).equals(car)) {
                        carEndingKm = splittedDatas.get(4);
                    }
                }
                cars.put(car, Integer.parseInt(carEndingKm) - Integer.parseInt(carBeginingKm));
            }
        }
        System.out.println("Task 5.");
        System.out.println(cars);
    }


//6. Határozza meg, melyik személy volt az, aki az autó egy elvitele alatt a leghosszabb
//távolságot tette meg! A személy azonosítóját és a megtett kilométert a minta szerint írja a
//képernyőre! (Több legnagyobb érték esetén bármelyiket kiírhatja.)

    public static void getWhoDroveTheCarTheFarest(String car) {
        cars = new HashMap<>();
        String carBeginingKm = "";
        String carEndingKm = "";
        String driver = "";
        for (int i = 0; i < autoDatas.size(); i++) {
            splittedDatas = Arrays.asList(autoDatas.get(i).split(" "));
            driver = splittedDatas.get(3);
            if (!cars.containsKey(driver) && splittedDatas.get(2).equals(car)) {
                carBeginingKm = splittedDatas.get(4);
                for (int j = 0; j < autoDatas.size(); j++) {
                    splittedDatas = Arrays.asList(autoDatas.get(j).split(" "));
                    if (!cars.containsKey(driver) && splittedDatas.get(2).equals(car)) {
                        carEndingKm = splittedDatas.get(4);
                    }
                }
                cars.put(driver, Integer.parseInt(carEndingKm) - Integer.parseInt(carBeginingKm));
            }
        }
        int largestDistance = (Collections.max(cars.values()));
        for (Map.Entry<String, Integer> entry : cars.entrySet()) {
            if (entry.getValue() == largestDistance) {
                System.out.println("Task 6.");
                System.out.println("Largest distance: " + largestDistance + "km, person: " + entry.getKey());
            }
        }
    }
//7. Az autók esetén egy havi menetlevelet kell készíteni! Kérjen be a felhasználótól egy
//rendszámot! Készítsen egy X_menetlevel.txt állományt, amelybe elkészíti az adott
//rendszámú autó menetlevelét! (Az X helyére az autó rendszáma kerüljön!) A fájlba
//soronként tabulátorral elválasztva a személy azonosítóját, a kivitel időpontját (nap.
//óra:perc), a kilométerszámláló állását, a visszahozatal időpontját (nap. óra:perc), és
//a kilométerszámláló állását írja a minta szerint! (A tabulátor karakter ASCII-kódja: 9.)

    public static void createWaybill() {
        System.out.println("Please tipe in a plate number");
        String plateNumber = scanner.next();
        String takeOutDate = "";
        String takeOutKm = "";
        File file = new File(plateNumber + "_waybill.txt");
        FileWriter fr = null;
        try {
            fr = new FileWriter(file, true);
        } catch (IOException e) {
            System.out.println("Problem at cretaing file writer");
            e.printStackTrace();
        }
        for (int i = 0; i < autoDatas.size(); i++) {
            splittedDatas = Arrays.asList(autoDatas.get(i).split(" "));
            if (splittedDatas.get(2).equals(plateNumber) && splittedDatas.get(5).equals("0")) {
                takeOutDate = splittedDatas.get(0) + ". " + splittedDatas.get(2);
                takeOutKm = splittedDatas.get(4) + " km";
            }
            if (splittedDatas.get(2).equals(plateNumber) && splittedDatas.get(5).equals("1")) {
                try {
                    fr.write(splittedDatas.get(3) + "   " + takeOutDate + "   " + takeOutKm + "   " + splittedDatas.get(0) + ". " + splittedDatas.get(2) + "    " + splittedDatas.get(4) + " km" + "\n");
                } catch (IOException e) {
                    System.out.println("Problem with writting in");
                    e.printStackTrace();
                }
            }
        }
        try {
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Task 7.");
        System.out.println("Waybill is ready");
    }

}


