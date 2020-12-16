public class BattleApp {
    public static void main(String[] args) {

        Ship ship = new Ship();
        ship.fillShip();
        Ship otherShip = new Ship();
        otherShip.fillShip();

        System.out.println(ship.battle(otherShip));

        Armada armada = new Armada();
        Armada otherArmada = new Armada();
        String weWon = armada.war(otherArmada);

        System.out.println(weWon);

    }
}
