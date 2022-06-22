package hw6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;


public class ArrayFunTest {
    ArrayFun func = new ArrayFun();

    @Test
    public void tesPairs(){
        assertEquals(3, func.numberOfPairs(new String[] {"s", "s","s","s"}));
        assertEquals(0, func.numberOfPairs(new String[] {"123","1", "123"}));
        assertEquals(0, func.numberOfPairs(new String[] {"0", "s0","0s","0"}));

    }

    @Test
    public void testSum(){
        assertEquals(true, func.sumGreaterThan(new double[] {2.4, 2.0, 2.0}, 6.3));
    }
    @Test
    public void testShift(){
        int[] x = {1,2,3,4,5,6,7};
        func.shiftNTimes(x, 1);
        System.out.println(Arrays.toString(x));
    }
    @Test
    public void testScan(){
        Scanner scanner = new Scanner("5 0 1 2 1 5 2");
        int[] result = func.frequency(scanner);
        assertEquals(11, result.length);
        assertEquals(1, result[0]); // there was one 0
        assertEquals(2, result[1]); // two 1s
        assertEquals(2, result[2]); // two 2s
        assertEquals(0, result[3]); // zero 3s
        assertEquals(0, result[4]); // zero 5s
        assertEquals(2, result[5]); // There were two 5s
        for(int score = 6; score <= 10; score++) {
          assertEquals(0, result[score]); // There were zero 6s, 7s, 8s, 9s, 10s
        }
    }
    @Test
    public void testHowMany(){
        assertEquals(2,func.howMany( new String[]{"A", "a", "A", "a" }, "A" ));
        assertEquals(1,func.howMany(new String[] {"And", "there", "goes", "another"}, "another"));
        assertEquals(0, func.howMany(new String[] {"And", "there", "goes", "another"},  "Not Here" ));
        assertEquals(0,func.howMany(new String[] { }, "empty array"));
    }
    @Test
    public void minmax(){
        assertEquals(10, func.range(new int[] {10,11,12,13,20}));
        assertEquals(0, func.range(new int[] {10}));
        assertEquals(15, func.range(new int[] {-5,-2,4,10,8}));
        assertEquals(10, func.range(new int[] {10,11,12,13,20}));
    }
    @Test void testFound(){
        assertEquals(true, func.found("Fuck", new String[] {"b", "c", "d", "Fuck"}));
    }
    @Test void testEvens(){
        int[] array = {1,2,1,1,1,1,11,1};
        func.evensLeft(array);
        System.out.println(Arrays.toString(array));
    }
    @Test
    public void testReplace(){
        char[] chars = {};
        char[] newChars = func.replaced(chars, 'c', 'X');
        System.out.println(Arrays.toString(newChars));

    }
    @Test
    public void testDistance(){
        int[] array = {1,4,2,1,4,1,4,0,0,0,0,0,0,0,0,0,0,1};
        System.out.println(func.largestWidth(array));
    }

}