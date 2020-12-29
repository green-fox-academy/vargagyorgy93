public class Flower extends Plantes {

    public Flower(String color, int currentWater) {
        super(color, currentWater);
    }

    public void drink(int wateredByAmount) {
        if (isNeedWater()) {
            this.currentWater += wateredByAmount * 0.75;
        }
    }

    public boolean isNeedWater() {
        return this.currentWater < 5;
    }
}
