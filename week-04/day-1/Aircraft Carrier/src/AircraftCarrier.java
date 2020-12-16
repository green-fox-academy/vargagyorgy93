public class AircraftCarrier {

    public static void main(String[] args) {
//        Aircraft air = new Aircraft();
//        System.out.println(air.getStatus());
//        F35 hali = new F35();
//        System.out.println(hali.getStatus());
//
        F16 hali2 = new F16();
        System.out.println(hali2.getStatus());
        hali2.refill(30);
        System.out.println(hali2.getStatus());
        hali2.figt();
        hali2.refill(30);
        hali2.figt();
        System.out.println(hali2.getStatus());
//
//        hali.getType();
//        hali2 .getType();

    }
}
