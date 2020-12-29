public class Tree extends Plantes {

    public Tree(String color, int currentWater) {
        super(color, currentWater);
    }

    public void drink(int wateredByAmount) {
        if (isNeedWater()) {
            this.currentWater += wateredByAmount * 0.4;
        }
    }

    public boolean isNeedWater() {
        return this.currentWater < 10;
    }
}
