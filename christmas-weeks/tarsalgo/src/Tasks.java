import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Tasks {

    public static List<String> doorDatas;
    public static Scanner scanner = new Scanner(System.in);

//1. Olvassa be és tárolja el az ajto.txt fájl tartalmát!

    public static List<String> fileReader(String file) {
        Path path = Paths.get(file);
        doorDatas = new ArrayList<>();
        try {
            doorDatas = Files.readAllLines(path);
        } catch (IOException e) {
            System.out.println("Cant read file!");
            System.exit(1);
        }
        return doorDatas;
    }

//2. Írja a képernyőre annak a személynek az azonosítóját, aki a vizsgált időszakon belül először
//lépett be az ajtón, és azét, aki utoljára távozott a megfigyelési időszakban!

    public static String getFirstAndLAstPerson(List<String> datas) {
        String firstPerson = "";
        String lastPerson = "";
        for (int i = 0; i < datas.size(); i++) {
            List<String> persons = Arrays.asList(datas.get(i).split(" "));
            if (persons.get(3).equals("be") && firstPerson.equals("")) {
                firstPerson = persons.get(2);
            } else if (persons.get(3).equals("ki")) {
                lastPerson = persons.get(2);
            }
        }
        return firstPerson + ", " + lastPerson;
    }

// 3. Határozza meg a fájlban szereplő személyek közül, ki hányszor haladt át a társalgó ajtaján!
//A meghatározott értékeket azonosító szerint növekvő sorrendben írja az athaladas.txt
//fájlba! Soronként egy személy azonosítója, és tőle egy szóközzel elválasztva az áthaladások
//száma szerepeljen!

    public static HashMap<String, Integer> getPersonDoorUseFrequency(List<String> datas) {
        HashMap<String, Integer> useFrequency = new HashMap<>();
        String[] persons;
        for (int i = 0; i < datas.size(); i++) {
            persons = (datas.get(i).split(" "));
            if (!useFrequency.containsKey(persons[2])) {
                useFrequency.put(persons[2], 1);
            } else {
                useFrequency.put(persons[2], useFrequency.get(persons[2]) + 1);
            }
        }

        List<Integer> order = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : useFrequency.entrySet()) {
            order.add(Integer.parseInt(entry.getKey()));
        }
        Collections.sort(order);
        for (int i = 0; i < order.size(); i++) {
            for (Map.Entry<String, Integer> entry : useFrequency.entrySet()) {
                if (order.get(i) == Integer.parseInt(entry.getKey())) {
                    System.out.println(entry.getKey() + " " + entry.getValue());
                }
            }
        }
        return useFrequency;
    }


//4. Írja a képernyőre azon személyek azonosítóját, akik a vizsgált időszak végén a társalgóban
//tartózkodtak!

    public static void getPersonStillInTheRoom(List<String> datas) {
        List<String> stillIn = new ArrayList<>();
        List<String> persons;
        for (String data : datas) {
            persons = Arrays.asList(data.split(" "));
            if (persons.get(3).equals("be")) {
                stillIn.add(persons.get(2));
            } else if (persons.get(3).equals("ki")) {
                stillIn.remove(persons.get(2));
            }
        }
        Collections.sort(stillIn);
        System.out.println(stillIn);
    }

//5. Hányan voltak legtöbben egyszerre a társalgóban? Írjon a képernyőre egy olyan időpontot
//(óra:perc), amikor a legtöbben voltak bent!


    public static void mostPersonInside(List<String> datas) {
        String time = "";
        int wentIn = 0;
        int wentOut = 0;
        int max = 0;
        List<String> persons;
        for (String data : datas) {
            persons = Arrays.asList(data.split(" "));
            if (persons.get(3).equals("be")) {
                wentIn += 1;
            }
            if (persons.get(3).equals("ki")) {
                wentOut += 1;
            } else if (wentIn - wentOut > max) {
                max = wentIn - wentOut;
                time = persons.get(0) + ":" + persons.get(1);
            }
        }
        System.out.println(time);
    }


//6. Kérje be a felhasználótól egy személy azonosítóját! A további feladatok megoldásánál ezt
//használja fel!


    public static String askForIdentifier() {
        System.out.println("Tipe in an identifier");
        return scanner.next();
    }

//7. Írja a képernyőre, hogy a beolvasott azonosítóhoz tartozó személy mettől meddig
//tartózkodott a társalgóban!


    public static String getWhenWasAPersonInTheRoom() {
        String person = askForIdentifier();
        String timeIN = "";
        String timeOut = "";
        String result = "";
        List<String> persons;
        for (String data : doorDatas) {
            persons = Arrays.asList(data.split(" "));
            if (persons.get(2).equals(person)) {
                if (persons.get(3).equals("be")) {
                    timeIN = persons.get(0) + ":" + persons.get(1);
                    result += timeIN + "-";
                }
                if (persons.get(3).equals("ki")) {
                    timeOut = persons.get(0) + ":" + persons.get(1);
                    result += timeOut + "\n";
                }
            }
        }
        return result;
    }

//8. Határozza meg, hogy a megfigyelt időszakban a beolvasott azonosítójú személy összesen
//hány percet töltött a társalgóban! Az előző feladatban példaként szereplő 22-es személy
//5 alkalommal járt bent, a megfigyelés végén még bent volt. Róla azt tudjuk, hogy 18 percet
//töltött bent a megfigyelés végéig. A 39-es személy 6 alkalommal járt bent, a vizsgált időszak
//végén nem tartózkodott a helyiségben. Róla azt tudjuk, hogy 39 percet töltött ott. Írja ki,
//hogy a beolvasott azonosítójú személy mennyi időt volt a társalgóban, és a megfigyelési
//időszak végén bent volt-e még!


    public static void getTheMinutesInside() {

        String person = askForIdentifier();
        String timeIN = "";
        String timeOut = "";
        String result = "";
        List<String> persons;
        for (String data : doorDatas) {
            persons = Arrays.asList(data.split(" "));
            if (persons.get(2).equals(person)) {
                if (persons.get(3).equals("be")) {
                    timeIN = persons.get(0) + persons.get(1);
                    result += timeIN + "-";
                }
                if (persons.get(3).equals("ki")) {
                    timeOut = persons.get(0) + persons.get(1);
                    result += timeOut + ",";
                }
            }
        }
        String times = result;
        List<String> timesInList;
        List<String> newTimesInList = new ArrayList<>();
        List<String> elements;
        int counter = 0;
        int first = 0;
        int secound = 0;
        boolean inTheRoom = false;

        timesInList = Arrays.asList(times.split(","));

        for (int i = 0; i < timesInList.size(); i++) {
            elements = Arrays.asList(timesInList.get(i).split("-"));
            newTimesInList.addAll(elements);
            if (elements.size() % 2 != 0) {
                newTimesInList.add("1500");
                inTheRoom = true;
            }
        }
        for (int i = 1; i < newTimesInList.size(); i++) {
            if (i % 2 != 0) {
                first = (Integer.parseInt(newTimesInList.get(i).substring(0, 2)) * 60) + Integer.parseInt(newTimesInList.get(i).substring(2));
                secound = (Integer.parseInt(newTimesInList.get(i - 1).substring(0, 2)) * 60) + Integer.parseInt(newTimesInList.get(i - 1).substring(2));
                counter += first - secound;
            }
        }
        if (!inTheRoom) {
            System.out.println("The person spend " + counter + " minutes is the room");
        } else {
            System.out.println("The person spend " + counter + " minutes is the room. At the end of the measuring he/ she was still in the room.");

        }
    }


}
