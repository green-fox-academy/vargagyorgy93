package fishtank;

public class Clownfish extends Fish {
    public Clownfish(String name, int weight, String color) {
        super(name, weight, color);
    }

    @Override
    public void feed() {
        weight += 1;
        color = "color of the stripes";
    }
}
