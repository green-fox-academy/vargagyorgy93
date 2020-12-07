import java.util.ArrayList;
import java.util.List;

public class Ship {
    public static void crew (Pirates pirate1, Pirates pirate2) {
        List<Pirates> crew = new ArrayList<Pirates>();

//        Pirates pirate1 = new Pirates();

        crew.add(pirate1);
        crew.add(pirate2);

        System.out.println(pirate1.drunkness);


    }


}
