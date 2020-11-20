//Gyakorló rész, nem egy feladat

public class Conditionals {
    public static void main(String[] args) {
        boolean thirsty = true;
        boolean hungry = false;

        if (thirsty && hungry) {
            System.out.println("Lunch Time!");
        } else if (thirsty || hungry) {
            System.out.println("Snack Time!");
        } else {
            System.out.println("No food for you.");
        }


    }
}
