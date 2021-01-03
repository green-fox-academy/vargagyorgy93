package fishtank;

public abstract class Fish {
    String name = "";
    int weight = 0;
    String color = "";

    public Fish(String name, int weight, String color) {
        this.name = name;
        this.weight = weight;
        this.color = color;
    }

    public void status() {
        System.out.println(this.name + ", weight: " + this.weight + ", color: "
                + this.color + ", short-term memory loss: " + false);
    }

    public void feed() {
        weight += 1;
    }
}
