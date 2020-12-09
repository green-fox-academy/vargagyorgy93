import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SumTest {

   Sum Sum;
    private Object IllegalArgumentException;

    @Before
    public void setup (){
       Sum = new Sum();

    }

    @Test
    public void sumTester (){

        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);

       assertEquals(15, Sum.sum(integers));
    }

    @Test
    public void sumTester_empty (){

        ArrayList<Integer> integers = new ArrayList<>();


        assertEquals(0, Sum.sum(integers));
    }

    @Test
    public void sumTester_oneElement (){

        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);


        assertEquals(1, Sum.sum(integers));
    }

    @Test
    public void sumTester_multiple (){

        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);


        assertEquals(3, Sum.sum(integers));
    }

//    @Test
//    public void sumTester_fewNull (){
//
//        ArrayList<Integer> integers = new ArrayList<>();
//        integers.add(null);
//        integers.add(2);
//        integers.add(null);
//        integers.add(2);
//
//        assertEquals(4, Sum.sum(integers));
//    }

    @Test(expected = NullPointerException.class)
    public void sumTester_null (){
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(null);

        assertEquals(new Exception(),Sum.sum(integers));
    }



}