package uniquecharacters;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class uniqueCharactersTest {

    uniqueCharacters unique = new uniqueCharacters();
    String given;

    @Test
    public void isHappy() {
        given = "anagrammok";
        List<Character> result = new ArrayList<>();
        result.add('g');
        result.add('k');
        result.add('n');
        result.add('o');
        result.add('r');
        assertEquals(result, unique.getuniqueCharacters(given));

    }

    @Test
    public void capitalLetter() {
        given = "Never";
        List<Character> result = new ArrayList<>();
        result.add('N');
        result.add('r');
        result.add('v');
        assertEquals(result, unique.getuniqueCharacters(given));
    }

    @Test(expected = NullPointerException.class)
    public void nullTest() {
        unique.getuniqueCharacters(null);
    }
}