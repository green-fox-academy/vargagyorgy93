import java.util.ArrayList;
import java.util.List;

public class SharpieSet {
    List<Sharpie> Sharpie = new ArrayList<>();
    Sharpie sharp = new Sharpie();
    public int usable = 0;


    public void removeTrash() {
        for (int i = 0; i < Sharpie.size(); i++) {

            if (sharp.inkAmonut < 1) {
                Sharpie.remove(i);
            }
        }
    }

    public void countUsable() {
        if (sharp.inkAmonut > 1) {
            usable++;
        } else {

        }

    }

    public static void main(String[] args) {

    }
}
