import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WriteMultipleLines {
    public static void main(String[] args) {

        writeLines("my-file.txt", "apple", 5);

    }

    public static void writeLines(String file, String word, int number) {

        int numberOfLines = number;
        List<String> multipliedWords = new ArrayList<>();
        multipliedWords.add(word);
        Path path = Paths.get(file);
        try {
            for (int i = 0; i < numberOfLines; i++) {
                Files.write(path, multipliedWords, StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            System.out.println("Hiba");
        }


    }
}

