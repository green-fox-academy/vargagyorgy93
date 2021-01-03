import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class avaragetemperature {
    public static void main(String[] args) {
        System.out.println(getColdestAndHottestYears("temps.txt"));
    }

    public static String getColdestAndHottestYears(String fileName) {
        int highestTemperature = 0;
        int lowestTemperature = 100;
        String France = "";
        String Sweden = "";
        String Germany = "";
        List<String> readedFile = new ArrayList<>();
        List<List<String>> splittedData = new ArrayList<>();
        Path path = Paths.get(fileName);
        try {
            readedFile = Files.readAllLines(path);
        } catch (IOException e) {
            System.out.println("Can't read file");
            System.exit(1);
        }
        for (int i = 0; i < readedFile.size(); i++) {
            splittedData.add(Arrays.asList(readedFile.get(i).split(" ")));
        }
        France = splittedData.get(0).get(0) + " => " +
                getHighestAndLowest(splittedData, highestTemperature, lowestTemperature, 0).get(0) + ", " +
                getHighestAndLowest(splittedData, highestTemperature, lowestTemperature,0).get(1);
        Sweden = splittedData.get(0).get(1) + " => " +
                getHighestAndLowest(splittedData, highestTemperature, lowestTemperature,1).get(0) + ", " +
                getHighestAndLowest(splittedData, highestTemperature, lowestTemperature,1).get(1);
        Germany = splittedData.get(0).get(2) + " => " +
                getHighestAndLowest(splittedData, highestTemperature, lowestTemperature,2).get(0) + ", " +
                getHighestAndLowest(splittedData, highestTemperature, lowestTemperature,2).get(1);

        return France + "\n" + Sweden + "\n" + Germany + "\n";
    }

    public static List<Integer> getHighestAndLowest(List<List<String>> splittedData, int highest, int lowest, int cityIndex) {
        int yearMax = 0;
        int yearMin = 0;
        List<Integer> highestAndLowest = new ArrayList<>();
        for (int i = 1; i < splittedData.size(); i++) {
            if (highest < Integer.parseInt(splittedData.get(i).get(cityIndex))) {
                highest = Integer.parseInt(splittedData.get(i).get(cityIndex));
                yearMax = Integer.parseInt(splittedData.get(i).get(3));
            }
            if (lowest > Integer.parseInt(splittedData.get(i).get(cityIndex))) {
                lowest = Integer.parseInt(splittedData.get(i).get(cityIndex));
                yearMin = Integer.parseInt(splittedData.get(i).get(3));
            }
        }
        highestAndLowest.add(yearMin);
        highestAndLowest.add(yearMax);
        return highestAndLowest;
    }
}
