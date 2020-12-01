import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CountLines {
    public static void main(String[] args) {


        System.out.println(lineCounter("my-file.txt"));
    }

    public static int lineCounter(String fileName) {

        int linesCounter = 0;

        Path path = Paths.get(fileName);
        try {
            List<String> content = Files.readAllLines(path);
            for (String line : content) {
                linesCounter++;
            }
        } catch (IOException e) {
            return 0;
        }

//        System.out.println(lines);
        return linesCounter;
    }
}
