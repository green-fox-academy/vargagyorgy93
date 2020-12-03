public class Sharpie {
    public String color;
    public Float width;
    public Float inkAmonut = 100f;


    public void use(Float decreaseAmount) {
        inkAmonut -= decreaseAmount;
    }


}
