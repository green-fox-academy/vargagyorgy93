package mostcommoncharacters;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class mostCommonCharacters {
    public static void main(String[] args) {
        System.out.println(getFirstAndSecoundMostCommonCharacter("countchar.txt"));
    }

    public static String readFileToString(String fileName, String readedFile) {
        Path path = Paths.get(fileName);
        try {
            readedFile = Files.readString(path);
        } catch (IOException e) {
            System.out.println("File does not exist!");
            System.exit(1);
        }
        return readedFile;
    }

    public static String getFirstAndSecoundMostCommonCharacter(String fileName) {
        String readedFile = "";
        char mostCommon = ' ';
        char secoundMostCommon = ' ';
        int occuranceofMC = 0;
        int occuranceofSMC = 0;
        HashMap<Character, Integer> charactersAndOccurance = new HashMap<>();
        readedFile = readFileToString(fileName, readedFile);
        for (int i = 0; i < readedFile.length(); i++) {
            if (!charactersAndOccurance.containsKey(readedFile.charAt(i))) {
                charactersAndOccurance.put(readedFile.charAt(i), 1);
            } else {
                charactersAndOccurance.put(readedFile.charAt(i), charactersAndOccurance.get(readedFile.charAt(i)) + 1);
//                charactersAndOccurance.replace(readedFile.charAt(i), charactersAndOccurance.get(readedFile.charAt(i)) + 1);//ez is jó
            }
        }

        for (Map.Entry<Character, Integer> entry : charactersAndOccurance.entrySet()) {
            if (entry.getValue() > occuranceofMC) {
                occuranceofMC = entry.getValue();
                mostCommon = entry.getKey();
            }
        }
        charactersAndOccurance.remove(mostCommon, occuranceofMC);
        for (Map.Entry<Character, Integer> entry : charactersAndOccurance.entrySet()) {
            if (entry.getValue() > occuranceofSMC) {
                occuranceofSMC = entry.getValue();
                secoundMostCommon = entry.getKey();
            }
        }
        return "{ \n" + " \"" + mostCommon + "\": " + occuranceofMC + ", \n" +
                " \"" + secoundMostCommon + "\": " + occuranceofSMC + "\n }";
    }
}
