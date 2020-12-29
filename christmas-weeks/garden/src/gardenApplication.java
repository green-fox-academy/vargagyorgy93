public class gardenApplication {
    public static void main(String[] args) {
        Garden garden = new Garden();
        garden.add(new Flower("yellow", 0));
        garden.add(new Flower("blue", 0));
        garden.add(new Tree("purple", 0));
        garden.add(new Tree("orange", 0));
        garden.status();

        garden.watering(40);
        garden.status();

        garden.watering(70);
        garden.status();

    }
}
