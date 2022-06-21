package hw5;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class LoopFunTest {

    LoopFun func = new LoopFun();

    @Test
    public void testGCD(){
        assertEquals(21, func.GCD(21,0));
        assertEquals(378, func.GCD(378, 378));
        assertEquals(5, func.GCD(25, -10));
        assertEquals(4, func.GCD(148, 236));
        assertEquals(1, func.GCD(7, 3));
        assertEquals(12, func.GCD(0, 12));
        assertEquals(6, func.GCD(124242, 28482));
        assertEquals(1, func.GCD(27, 11));

    }
    @Test
    public void testFact(){
        assertEquals(6, func.factorial(3));
        assertEquals(1, func.factorial(0));
        assertEquals(24, func.factorial(4));
        assertEquals(120, func.factorial(5));
        assertEquals(1, func.factorial(1));

    }

    @Test
    public void testSQRT(){
        assertEquals(3.0, func.sqrt(9, 1e-12));
        assertEquals(4, func.sqrt(16, 1e-12));
        assertEquals(1.414213562373095, func.sqrt(2, 1e-06));
        assertEquals(3.872983346207418, func.sqrt(15, 0.00001));

    }
    @Test
    public void testPRIME(){
        assertEquals(true, func.isPrime(23));
        assertEquals(true, func.isPrime(113));
        assertEquals(false, func.isPrime(12));
        assertEquals(true, func.isPrime(2));
        assertEquals(false, func.isPrime(4));


    }
    @Test
    public void testChars(){
        assertEquals(4, func.numberOfPairs("aasdfffasddf"));
        assertEquals(0, func.numberOfPairs("a"));
        assertEquals(0, func.numberOfPairs("aAa"));
        assertEquals(3, func.numberOfPairs("bbbb"));
        assertEquals(1, func.numberOfPairs("abcCcc"));
        assertEquals(1, func.numberOfPairs("asl;dfkj11"));


    }
    @Test
    public void testABBA(){
        assertEquals(1, func.howSwedish("asdfabbaasdf"));
        assertEquals(2, func.howSwedish("abbabba"));
        assertEquals(1, func.howSwedish("ABBBBBAABBAasdf"));
        assertEquals(1, func.howSwedish("ABBA"));
        assertEquals(0, func.howSwedish("a"));
    }

    @Test
    public void testEcho(){
        assertEquals("123", func.echo("123ab321"));
        assertEquals("aba", func.echo("aba"));
        assertEquals("a", func.echo("abca"));
        assertEquals("", func.echo("asdfghh"));
        assertEquals("1221", func.echo("1221"));
        assertEquals("123a321", func.echo("123a321"));
        assertEquals("123dvd321", func.echo("123dvd321"));
        assertEquals("1", func.echo("1"));
        assertEquals("1233321", func.echo("1233321"));
        assertEquals("a", func.echo("a1241245124a"));
        assertEquals("12", func.echo("12bd21"));
    }
    @Test
    public void tesRANGE(){
        Scanner scanner = new Scanner(" 222 3 4 -100 6 7 8");
        assertEquals(322, func.rangeInScanner(scanner));
    }

    @Test
    public void testSMTH(){
        Scanner scanner = new Scanner("b a b a a b a b b b ");
        assertEquals(6, func.howMany(scanner, "b"));
    }
    @Test
    public void testScore(){
        Scanner scanner = new Scanner("100 100 100 100 2 41 24 51 2 32");
        assertEquals(0.4, func.perfectPercentage(scanner));
    }
}