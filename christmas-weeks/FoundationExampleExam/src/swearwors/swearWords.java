package swearwors;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class swearWords {
    public static void main(String[] args) {
        swearWords swear = new swearWords();
        swear.removeSwearWordsFromFile("content.txt");
    }

    public int removeSwearWordsFromFile(String fileName) {
//        Still not good...
        int numberOfRemovedWords = 0;
        String copyOfReadFile = "";
        List<String> badWordsList = new ArrayList<>();
        String readedFile = "";
        String[] editedReadedFile;
        Path path = Paths.get(fileName);
        try {
            readedFile = Files.readString(path);
        } catch (IOException e) {
            System.out.println("Can't read file");
            e.printStackTrace();
        }
        badWordsList.add("fuck");
        badWordsList.add("fucker");
        badWordsList.add("fuckstick");
        badWordsList.add("bloody");
        badWordsList.add("cock");
        badWordsList.add("shit");
        badWordsList.add("asshole");
        badWordsList.add("dick");
        badWordsList.add("piss");
        badWordsList.add("cunt");
        int k = 0;
        int a = 0;
        while (a != badWordsList.size()) {
            for (int i = 0; i < readedFile.length() - badWordsList.get(a).length(); i++) {
                k = readedFile.length();
                if (readedFile.toLowerCase().substring(i, i + badWordsList.get(a).length()).equals(badWordsList.get(a))) {
                    numberOfRemovedWords += 1;
                    System.out.println();
                }
            }
            a += 1;
        }
//        readedFile = readedFile.toLowerCase();
        readedFile = readedFile.replaceAll(" fuck", "");
        readedFile = readedFile.replaceAll(" bloody", "");
        readedFile = readedFile.replaceAll(" cock", "");
        readedFile = readedFile.replaceAll(" shit", "");
        readedFile = readedFile.replaceAll(" fucker", "");
        readedFile = readedFile.replaceAll(" fuckstick", "");
        readedFile = readedFile.replaceAll(" asshole", "");
        readedFile = readedFile.replaceAll(" dick", "");
        readedFile = readedFile.replaceAll(" piss", "");
        readedFile = readedFile.replaceAll(" cunt", "");
//        readedFile = readedFile.replace(',', ' ');
//        splittedFile = Arrays.asList(readedFile.split(". "));
        System.out.println(readedFile + numberOfRemovedWords);

        return numberOfRemovedWords;
    }
}
