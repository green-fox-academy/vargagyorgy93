import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class otszaz {

    //    1. Olvassa be és tárolja el a penztar.txt fájl tartalmát!
    public static void main(String[] args) {

        Tasks.fileReader("penztar.txt");
        Tasks.sumIntoTxt();
    }



}
