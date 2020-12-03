public class Station {
    int gasAmount = 10000;
    int refill;

    public void refill(Car car) {
        this.gasAmount = gasAmount - car.capaticy;
        car.gasAMount += car.capaticy;

    }
}
