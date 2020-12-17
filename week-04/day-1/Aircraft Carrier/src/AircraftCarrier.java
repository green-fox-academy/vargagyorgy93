import java.util.ArrayList;
import java.util.List;

public class AircraftCarrier {

    public static void main(String[] args) {





        List<String> stringList = new ArrayList<>();
        String[] strinArray;

        Aircraft hali = new Aircraft();
        hali.readFile("file.txt");

        hali.writeOverFile("file.txt");
        hali.readFile("file.txt");







//        Carrier carrier = new Carrier(2300, 5000);
//        carrier.add(4, 5, "F16");
//        carrier.add(6,7, "F35");
//        carrier.fill();
////        carrier.getStatus();
//
//
//        Carrier carrier2 = new Carrier(2300, 62);
//        carrier2.add(4, 5, "F16");
//        carrier2.add(6,7, "F35");
//        carrier2.fill();
////        carrier2.getStatus();
//
//        carrier.figth(carrier2);
//        carrier.getStatus();
//        carrier2.getStatus();





//        Aircraft air = new Aircraft();
//        System.out.println(air.getStatus());
//        F35 hali = new F35();
//        System.out.println(hali.getStatus());
//
//        F16 hali2 = new F16();
//        System.out.println(hali2.getStatus());
//        hali2.refill(30);
//        System.out.println(hali2.getStatus());
//        hali2.figt();
//        hali2.refill(30);
//        hali2.figt();
//        System.out.println(hali2.getStatus());
//
//        hali.getType();
//        hali2 .getType();

    }
}
