import java.util.Arrays;

public class Domino implements java.lang.Comparable<Domino> {
    private final int left;
    private final int right;

    public Domino(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public int getLeftSide() {
        return left;
    }

    public int getRightSide() {
        return right;
    }

    @Override
    public String toString() {
        return "[" + left + ", " + right + "]";
    }

    @Override
    public int compareTo(Domino otherDomino) {
        if (this.left > otherDomino.left){
            return  1;
        } else if (this.left < otherDomino.left){
            return -1;
        } else {
            return 0;
        }
    }
}