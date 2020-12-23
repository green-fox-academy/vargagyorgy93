import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class metjelentes {

    public static List<String> datas;
    public static List<String> specifiedCityDatas = new ArrayList<>();
    public static List<String> splittedDatas = new ArrayList<>();
    public static HashMap<String, Integer> avarageTemperature;
    public static List<List<String>> cityWithAllData = new ArrayList<>();

    public static void main(String[] args) {

        readFileToStringList("tavirathu13.txt");
        cityToTxt();
    }

//1. Olvassa be és tárolja el a tavirathu13.txt állomány adatait!

    public static List<String> readFileToStringList(String file) {
        Path path = Paths.get(file);
        datas = new ArrayList<>();
        try {
            datas = Files.readAllLines(path);
        } catch (IOException e) {
            System.out.println("Cant read file!");
            System.exit(1);
        }
        return datas;
    }

//2. Kérje be a felhasználótól egy város kódját! Adja meg, hogy az adott városból mikor érkezett
//az utolsó mérési adat! A kiírásban az időpontot óó:pp formátumban jelenítse meg!


    public static String getLastMeasurmentTime() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please tipe in the city code!");
        String cityCode = scanner.next();
        for (String citys : datas) {
            splittedDatas = Arrays.asList(citys.split(" "));
            if (splittedDatas.contains(cityCode)) {
                specifiedCityDatas = splittedDatas;
            }
            splittedDatas.isEmpty();
        }
        int time = Integer.parseInt(specifiedCityDatas.get(1));
        System.out.println("The last measurment arrived at " + time / 100 + ":" + time % 100);
        String result = time / 100 + ":" + time % 100;
        return result;
    }

//3. Határozza meg, hogy a nap során mikor mérték a legalacsonyabb és a legmagasabb
//hőmérsékletet! Jelenítse meg a méréshez kapcsolódó település nevét, az időpontot és
//a hőmérsékletet! Amennyiben több legnagyobb vagy legkisebb érték van, akkor elég
//az egyiket kiírnia.


    public static String getHihgestAndLowestTemperature() {
        int hottest = 0;
        int coldest = 100;
        int temperature = 0;
        String resultHottest = "";
        String resultColdest = "";
        for (int i = 0; i < datas.size(); i++) {
            splittedDatas = Arrays.asList(datas.get(i).split(" "));
            temperature = Integer.parseInt(splittedDatas.get(3));
            if (temperature > hottest) {
                hottest = temperature;
                resultHottest = splittedDatas.get(0) + ", " + Integer.parseInt(splittedDatas.get(1)) / 100 + ":" + Integer.parseInt(splittedDatas.get(1)) % 100 + ", " + splittedDatas.get(3);
            } else if (temperature < coldest) {
                coldest = temperature;
                resultColdest = splittedDatas.get(0) + ", " + Integer.parseInt(splittedDatas.get(1)) / 100 + ":" + Integer.parseInt(splittedDatas.get(1)) % 100 + ", " + splittedDatas.get(3);
            }
            splittedDatas.isEmpty();
        }
        String result = resultHottest + "\n" + resultColdest;
        return result;
    }


//4. Határozza meg, azokat a településeket és időpontokat, ahol és amikor a mérések idején
//szélcsend volt! (A szélcsendet a táviratban 00000 kóddal jelölik.) Ha nem volt ilyen, akkor
//a „Nem volt szélcsend a mérések idején.” szöveget írja ki! A kiírásnál a település kódját és
//az időpontot jelenítse meg.


    public static String getWindLessPlaceAndTime() {


        for (int i = 13; i < datas.size(); i++) {
            splittedDatas = Arrays.asList(datas.get(i).split(" "));
            if (splittedDatas.get(2).equals("00000")) {
                specifiedCityDatas.add("\n" + splittedDatas.get(0) + ", " + Integer.parseInt(splittedDatas.get(1)) / 100 + ":" + Integer.parseInt(splittedDatas.get(1)) % 100);

            }
            splittedDatas.isEmpty();
        }

        if (specifiedCityDatas.size() == 0) {
            return "Nem volt szélcsend a mérések idején";
        } else {
            return specifiedCityDatas.toString();
        }
    }


//5. Határozza meg a települések napi középhőmérsékleti adatát és a hőmérséklet-ingadozását!
//A kiírásnál a település kódja szerepeljen a sor elején a minta szerint! A kiírásnál csak
//a megoldott feladatrészre vonatkozó szöveget és értékeket írja ki!

//a. A középhőmérséklet azon hőmérsékleti adatok átlaga, amikor a méréshez tartozó óra
//értéke 1., 7., 13., 19. Ha egy településen a felsorolt órák valamelyikén nem volt mérés,
//akkor a kiírásnál az „NA” szót jelenítse meg! Az adott órákhoz tartozó összes adat
//átlagaként határozza meg a középhőmérsékletet, azaz minden értéket azonos súllyal
//vegyen figyelembe! A középhőmérsékletet egészre kerekítve jelenítse meg!

//b. A hőmérséklet-ingadozás számításhoz az adott településen a napi legmagasabb és
//legalacsonyabb hőmérséklet különbségét kell kiszámítania! (Feltételezheti, hogy
//minden település esetén volt legalább két mérési adat.)

    public static List<String> averageTemperatureAndFluctuation() {

        int differenceOfLowsetAndHigheste = 0;

        avarageTemperature = new HashMap<>();
        List<String> citys = new ArrayList<>();
        List<String> result = new ArrayList<>();
        List<String> otherSplittedDatas = new ArrayList<>();
        int avTemp = 0;
        String avTempNA = "NA";

        for (int i = 0; i < datas.size(); i++) {
            splittedDatas = Arrays.asList(datas.get(i).split(" "));
            for (int j = 0; j < datas.size(); j++) {
                otherSplittedDatas = Arrays.asList(datas.get(j).split(" "));
                if (splittedDatas.get(0).equals(otherSplittedDatas.get(0)) && !citys.contains(splittedDatas.get(0))) {
                    cityWithAllData.add(otherSplittedDatas);
                }
            }
            if (!citys.contains(splittedDatas.get(0))) {
                differenceOfLowsetAndHigheste = getHighestTemperatur(cityWithAllData) - getLowestTemperatur(cityWithAllData);
                if (isCorrectlyMeasured(cityWithAllData)) {
                    avTemp = getAvarageTemperature(cityWithAllData);
                    result.add(splittedDatas.get(0) + " Középhőmérséklet: " + avTemp + "; Hőmérséklet-ingadozás: " + differenceOfLowsetAndHigheste);
                } else {
                    result.add(splittedDatas.get(0) + " " + avTempNA + "; Hőmérséklet-ingadozás: " + differenceOfLowsetAndHigheste);
                }
            }
            citys.add(splittedDatas.get(0));
            cityWithAllData.clear();
        }
        System.out.println(result);
        return result;
    }

    public static int getHighestTemperatur(List<List<String>> lists) {
        int hottest = 0;
        for (int i = 0; i < lists.size(); i++) {
            if (hottest < Integer.parseInt(lists.get(i).get(3)))
                hottest = Integer.parseInt(lists.get(i).get(3));
        }
        return hottest;
    }

    public static int getLowestTemperatur(List<List<String>> lists) {
        int coldest = 100;
        for (int i = 0; i < lists.size(); i++) {
            if (coldest > Integer.parseInt(lists.get(i).get(3)))
                coldest = Integer.parseInt(lists.get(i).get(3));
        }
        return coldest;
    }

    public static boolean isCorrectlyMeasured(List<List<String>> lists) {
        int counter = 0;
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i).get(1).equals("0100") || lists.get(i).get(1).equals("0700") || lists.get(i).get(1).equals("1300") || lists.get(i).get(1).equals("1900")) {
                counter += 1;
            }
        }
        if (counter == 4) {
            return true;
        } else {
            return false;
        }
    }

    public static int getAvarageTemperature(List<List<String>> lists) {
        int counter = 0;
        int temperature = 0;
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i).get(1).equals("0100") || lists.get(i).get(1).equals("0700") || lists.get(i).get(1).equals("1300") || lists.get(i).get(1).equals("1900")) {
                counter += 1;
                temperature += Integer.parseInt(lists.get(i).get(3));
            }
        }
        return (temperature / counter);
    }


//6. Hozzon létre településenként egy szöveges állományt, amely első sorában a település kódját
//tartalmazza! A további sorokban a mérési időpontok és a hozzá tartozó szélerősségek
//jelenjenek meg! A szélerősséget a minta szerint a számértéknek megfelelő számú
//kettőskereszttel (#) adja meg! A fájlban az időpontokat és a szélerősséget megjelenítő
//kettőskereszteket szóközzel válassza el egymástól! A fájl neve X.txt legyen, ahol
//az X helyére a település kódja kerüljön!

    public static void cityToTxt() {
        avarageTemperature = new HashMap<>();
        List<String> citys = new ArrayList<>();
        List<String> otherSplittedDatas = new ArrayList<>();
        for (int i = 0; i < datas.size(); i++) {
            splittedDatas = Arrays.asList(datas.get(i).split(" "));
            for (int j = 0; j < datas.size(); j++) {
                otherSplittedDatas = Arrays.asList(datas.get(j).split(" "));
                if (splittedDatas.get(0).equals(otherSplittedDatas.get(0)) && !citys.contains(splittedDatas.get(0))) {
                    cityWithAllData.add(otherSplittedDatas);
                }
            }
            if (!citys.contains(splittedDatas.get(0))) {
                String fileName = cityWithAllData.get(0).get(0) + ".txt";
                File file = new File(fileName);
                FileWriter fr = null;
                try {
                    fr = new FileWriter(file, true);
                } catch (IOException e) {
                    System.out.println("Problem at cretaing file writer");
                    e.printStackTrace();
                }
                try {
                    fr.write(fillStringWithData(cityWithAllData));
                } catch (IOException e) {
                    System.out.println("Problem at writting in");
                    e.printStackTrace();
                }
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            citys.add(splittedDatas.get(0));
            cityWithAllData.clear();
            System.out.println();
        }
    }

    public static String fillStringWithData(List<List<String>> lists) {
        String result = lists.get(0).get(0) + "\n";
        for (int i = 0; i < lists.size(); i++) {
            String wind = "";
            String strenght = lists.get(i).get(2).substring(4, 5);
            for (int j = 0; j < (Integer.parseInt(strenght)); j++) {
                wind += "#";
            }
            result += (Integer.parseInt(lists.get(i).get(1))) / 100 + ":" + (Integer.parseInt(lists.get(i).get(1))) % 100 + " " + wind + "\n";
        }
        return result;
    }


}
