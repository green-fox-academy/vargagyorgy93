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
        int numberOfRemovedWords = 0;
//        List<String> readedFile = new ArrayList<>();
        String readedFile = "";
        String[] editedReadedFile;
        Path path = Paths.get(fileName);
        try {
            readedFile = Files.readString(path);
        } catch (IOException e) {
            System.out.println("Can't read file");
            e.printStackTrace();
        }

        readedFile = readedFile.toLowerCase();
        readedFile = readedFile.replace('.', ' ');
        readedFile = readedFile.replace(',', ' ');

        System.out.println(readedFile);

        return numberOfRemovedWords;
    }
}
