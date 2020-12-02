import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CopyFile {
    public static void main(String[] args) {

        System.out.println(copy("CopyFromThis.txt", "ToThis.txt"));

    }

    public static boolean copy(String fileFrom, String fileTo) {

        List<String> copiedContent;

        try {
            copiedContent = Files.readAllLines(Paths.get(fileFrom), StandardCharsets.UTF_8);
        } catch (IOException ex) {
            return false;
        }
          
        Path path = Paths.get(fileTo);
        try {
            Files.write(path, copiedContent);
            return true;
        } catch (IOException e) {
            return false;
        }


    }


}
