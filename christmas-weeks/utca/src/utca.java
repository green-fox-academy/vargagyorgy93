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

public class utca {

    public static List<String> streetData;
    public static List<String> splittedDatas = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        readFileToStringList("kerites.txt");

//        getAmountOfSolfd();
//        getSideAndHouseNumber();
//        getSameColordeHouseNumber();
//        getStatus();
        drawIntoTxt();
    }

//1. Olvassa be és tárolja el a kerites.txt fájl tartalmát!


    public static List<String> readFileToStringList(String file) {
        Path path = Paths.get(file);
        streetData = new ArrayList<>();
        try {
            streetData = Files.readAllLines(path);
        } catch (IOException e) {
            System.out.println("Cant read file!");
            System.exit(1);
        }
        return streetData;
    }

//2. Írja a képernyőre, hogy hány telket adtak el az utcában!

    public static int getAmountOfSold() {
        System.out.println("Task 2.");
        System.out.println("Number of sold lands is " + streetData.size());
        System.out.println();
        return streetData.size();

    }


//3. Jelenítse meg a képernyőn, hogy az utolsó eladott telek
//a. melyik (páros / páratlan) oldalon talált gazdára!
//b. milyen házszámot kapott!


    public static void getSideAndHouseNumber() {
        int counter = 0;
        for (int i = 0; i < streetData.size(); i++) {
            splittedDatas = Arrays.asList(streetData.get(i).split(" "));
            if (splittedDatas.get(0).equals("0")) {
                counter += 1;
            }
        }
        System.out.println("Task 3.");
        System.out.println("Last land was sold on the even side");
        System.out.println("The addres number of the last land is " + counter * 2);
        System.out.println();
    }

//4. Írjon a képernyőre egy házszámot a páratlan oldalról, amely melletti telken ugyanolyan
//színű a kerítés! (A hiányzó és a festetlen kerítésnek nincs színe.) Feltételezheti, hogy van
//ilyen telek, a több ilyen közül elég az egyik ház számát megjeleníteni.


    public static int getSameColordeHouseNumber() {
        int houseNumber = 0;
        String fenceColor = "";
        int counter = 0;
        for (int i = 0; i < streetData.size(); i++) {
            splittedDatas = Arrays.asList(streetData.get(i).split(" "));
            if (splittedDatas.get(0).equals("1")) {
                if (splittedDatas.get(2).equals(fenceColor)) {
                    System.out.println("Task 4.");
                    System.out.println("The addres of the needed house is " + houseNumber);
                    System.out.println();
                    return houseNumber;
                }
                counter += 1;
                houseNumber = (counter * 2) - 1;
                fenceColor = splittedDatas.get(2);
            }
        }
        return 0;

    }

//5. Kérje be a felhasználótól egy eladott telek házszámát, majd azt felhasználva oldja meg a
//következő feladatokat!
//      a. Írja ki a házszámhoz tartozó kerítés színét, ha már elkészült és befestették,
//egyébként az állapotát a „#” vagy „:” karakter jelöli!
//      b. A házszámhoz tartozó kerítést szeretné tulajdonosa be- vagy átfesteni. Olyan
//színt akar választani, amely különbözik a mellette lévő szomszéd(ok)tól és a
//jelenlegi színtől is. Adjon meg egy lehetséges színt! A színt a teljes palettából
//(A–Z) szabadon választhatja meg


    public static void getStatus() {
        System.out.println("Please tipe in a house number");
        int wantedHouseNumber = scanner.nextInt();
        int counter = 0;
        int houseNumber;
        int indexOfHouse = 0;
        String side = "0";
        char fenceColor = ' ';
        if (wantedHouseNumber % 2 != 0) {
            side = "1";
        }
        for (int i = 0; i < streetData.size(); i++) {
            splittedDatas = Arrays.asList(streetData.get(i).split(" "));
            if (splittedDatas.get(0).equals(side)) {
                counter += 1;
                if (side.equals("1")) {
                    houseNumber = (counter * 2) - 1;
                } else {
                    houseNumber = counter * 2;
                }
                if (houseNumber == wantedHouseNumber) {
                    indexOfHouse = i;
                    switch (splittedDatas.get(2)) {
                        case ":":
                            System.out.println("Task 5.");
                            System.out.println("Color of the fence: " + ":");
                            break;
                        case "#":
                            System.out.println("Task 5.");
                            System.out.println("Color of the fence: " + "#");
                            break;
                        default:
                            fenceColor = splittedDatas.get(2).charAt(0);
                            System.out.println("Task 5.");
                            System.out.println("Color of the fence: " + splittedDatas.get(2));
                            break;
                    }
                }
            }
        }
        String nextDoorColor = "";
        String nextDoorColor2 = "";
        for (int i = 0; i < streetData.size(); i++) {
            if (indexOfHouse == i) {
                nextDoorColor = splittedDatas.get(2);
            }
            if (i < indexOfHouse) {
                splittedDatas = Arrays.asList(streetData.get(i).split(" "));
            }
            if (i > indexOfHouse && nextDoorColor2.isEmpty()) {
                splittedDatas = Arrays.asList(streetData.get(i).split(" "));
                if (splittedDatas.get(0).equals(side)) {
                    nextDoorColor2 = splittedDatas.get(2);
                }
            }
        }
        char newColor = ' ';
        for (char i = 'A'; i < 'Z'; i++) {
            if (i != nextDoorColor.charAt(0) && i != nextDoorColor2.charAt(0) && i != fenceColor) {
                newColor = i;
                break;
            }
        }
        System.out.println("New color can be " + newColor);
        System.out.println();
    }

//6. Jelenítse meg az utcakep.txt fájlban a páratlan oldal utcaképét az alábbi mintának
//megfelelően!
//KKKKKKKK::::::::::SSSSSSSSSBBBBBBBBFFFFFFFFFKKKKKKKKKKIIIIIIII
//1       3         5        7       9        11        13
//Az első sorban a páratlan oldal jelenjen meg, a megfelelő méternyi szakasz kerítésszínét
//(vagy állapotát) jelző karakterrel! A második sorban a telek első karaktere alatt kezdődően
//a házszám álljon!


    public static void drawIntoTxt() {

        String fileName = "utcakep.txt";
        File file = new File(fileName);
        FileWriter fr = null;
        int counter = 0;
        for (int i = 0; i < streetData.size(); i++) {
            splittedDatas = Arrays.asList(streetData.get(i).split(" "));
            if (splittedDatas.get(0).equals("1")) {
                counter += 1;
                for (int j = 0; j < Integer.parseInt(splittedDatas.get(1)); j++) {
                }
            }
        }
        try {
            fr = new FileWriter(file, true);
        } catch (IOException e) {
            System.out.println("Problem at cretaing file writer");
            e.printStackTrace();
        }
        for (int i = 0; i < streetData.size(); i++) {
            splittedDatas = Arrays.asList(streetData.get(i).split(" "));
            if (splittedDatas.get(0).equals("1")) {
                counter += 1;
                for (int j = 0; j < Integer.parseInt(splittedDatas.get(1)); j++) {
                    try {
                        fr.write(splittedDatas.get(2));
                    } catch (IOException e) {
                        System.out.println("Problem at writting in");
                        e.printStackTrace();
                    }
                }

            }
        }

        try {
            fr.write("\n");
        } catch (IOException e) {
            System.out.println("Problem at writting in");
            e.printStackTrace();
        }
        counter = 0;
        int houseNum = 0;
        for (int i = 0; i < streetData.size(); i++) {
            splittedDatas = Arrays.asList(streetData.get(i).split(" "));
            if (splittedDatas.get(0).equals("1")) {
                counter += 1;
                houseNum = ((counter * 2) - 1);
                for (int j = 0; j < Integer.parseInt(splittedDatas.get(1)); j++) {
                    if (j == 0) {
                        try {
                            fr.write(Integer.toString(houseNum));
                        } catch (IOException e) {
                            System.out.println("Problem at writting in");
                            e.printStackTrace();
                        }
                    } else {
                        if (houseNum > 9 && j == Integer.parseInt(splittedDatas.get(1)) - 1) {

                        }
                         else if (houseNum > 99 && j == Integer.parseInt(splittedDatas.get(1)) - 2) {

                        } else {
                            try {
                                fr.write(" ");
                            } catch (IOException e) {
                                System.out.println("Problem at writting in");
                                e.printStackTrace();
                            }
                        }
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
