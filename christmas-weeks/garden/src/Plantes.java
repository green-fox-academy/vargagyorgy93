public class Plantes {
    public String color;
    public int currentWater = 0;

    public Plantes(String color, int currentWater) {
        this.color = color;
        this.currentWater = currentWater;
    }

    public void drink(int wateredByAmount) {
    }

    public boolean isNeedWater() {
        return false;
    }

}
