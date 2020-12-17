import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AircraftCarrierTest {
    List<Aircraft> aircrafts;
    int storedAmmo = 0;
    int healthPoint = 0;
    int totalDamage =0;


    @Before
    public void setup(){
        aircrafts = new ArrayList<>();
    }
    @Test
    public void add() {

        aircrafts.add(new Aircraft());
        assertEquals(1, aircrafts.size());
    }


}