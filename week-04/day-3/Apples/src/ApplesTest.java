import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ApplesTest {

    Apples apple;

    @Before
    public void setup(){
        apple = new Apples();
    }

    @Test
    public void appleTester(){
//        Apples apple = new Apples();
        assertEquals("appl", apple.getApple());
    }


}