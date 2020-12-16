public class WarApp {
    public static void main(String[] args) {
        Armada armada = new Armada();
        Armada otherArmada = new Armada();
        String weWon = armada.war(otherArmada);

        System.out.println(weWon);
    }
}
