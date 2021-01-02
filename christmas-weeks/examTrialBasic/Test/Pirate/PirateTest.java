package Pirate;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PirateTest {

    Pirate captain = new Pirate("Captain", true, false);
    Pirate jack = new Pirate("Jack", false, false);

    @Test
    public void work() {
        captain.work();
        jack.work();
        int sum = captain.amounOfGold + captain.helathPoints;
        int sumJack = jack.amounOfGold + jack.helathPoints;
        assertEquals(25, sum);
        assertEquals(20, sumJack);

    }

    @Test
    public void party() {
        captain.party();
        jack.party();
        assertEquals(20, captain.helathPoints);
        assertEquals(11, jack.helathPoints);

    }

    @Test
    public void testToString() {
        String happyJack = "Hello, I'm Jack. I still have my real legs and 10 golds.";
        String happyCaptain = "Hello, I'm Captain. I still have my real legs and 10 golds.";
        boolean happy = false;
        if (happyJack.equals(jack.toString())){
            happy = true;
        }
        assertEquals(happyJack, jack.toString());
        assertEquals(happyCaptain, captain.toString());
    }
}