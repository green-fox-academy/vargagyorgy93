import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Anagram {

    public boolean anagram(String word1, String word2){
        char[] first = word1.toCharArray();
        char[] secound = word2.toCharArray();

        Arrays.sort(first);
        Arrays.sort(secound);

        return Arrays.equals(first, secound);
    }

    public static void main(String[] args) {
        Anagram anc = new Anagram();
        System.out.println(anc.anagram("hello", "olleh"));
    }
}
