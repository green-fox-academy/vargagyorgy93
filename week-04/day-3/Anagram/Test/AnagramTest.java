import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnagramTest {

    Anagram ani;

    @Before
    public void setup() {
        ani = new Anagram();

    }

    @Test
    public void anagramTest_pass() {
        String word1 = "hello";
        String word2 = "olleh";

        assertEquals(true, ani.anagram(word1, word2));
    }

    @Test
    public void anagramTest_false() {
        String word1 = "hello";
        String word2 = "klleh";

        assertEquals(false, ani.anagram(word1, word2));
    }

    @Test
    public void anagramTest_zero() {
        String word1 = "hello";
        String word2 = "";

        assertEquals(false, ani.anagram(word1, word2));
    }

}