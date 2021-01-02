package fishtank;

public class Tang extends Fish{
    public Tang(String name, int weight, String color) {
        super(name, weight, color);
    }

    @Override
    public void feed() {
        weight += 1;
    }

    @Override
    public void status() {
        System.out.println(this.name + ", weight: " + this.weight + ", color: " + this.color + ", short-term memory loss: " + true);
    }
}
