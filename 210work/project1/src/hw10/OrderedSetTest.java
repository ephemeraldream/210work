package hw10;


// @author -  Ivan Akinfiev

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;



public class OrderedSetTest {

    @Test
    public void testContains() {
        OrderedSet<Integer> bst = new OrderedSet<Integer>();
        bst.add(10);
        bst.add(5);
        bst.add(10);
        bst.add(1);
        bst.add(123);
        bst.add(12);
        bst.add(3);
        assertTrue(bst.contains(3));
        assertTrue(bst.contains(123));
        assertFalse(bst.contains(2));
        assertTrue(bst.contains(1));
    }

     @Test
     public void testSize() {
         OrderedSet<Integer> bst = new OrderedSet<Integer>();
         assertFalse(bst.contains(2));
         bst.add(10);
         bst.add(5);
         bst.add(10);
         bst.add(1);
         bst.add(123);
         bst.add(12);
         bst.add(3);
         bst.add(6);
         assertFalse(bst.add(10));
         assertNotEquals(2, bst.size());
         assertNotEquals(4, bst.size());
         assertEquals(7, bst.size());
         OrderedSet<Integer> bstSecond = new OrderedSet<Integer>();
         assertEquals(0, bstSecond.size());
         assertFalse(bstSecond.contains(3));

     }
     @Test
     public void testToString() {
         OrderedSet<Integer> bst = new OrderedSet<Integer>();
         bst.add(10);
         bst.add(5);
         bst.add(10);
         bst.add(1);
         bst.add(123);
         bst.add(12);
         bst.add(3);
         assertNotEquals("1 2 123 10 5", bst.toStringInorder());
         assertEquals("1 3 5 10 12 123 ", bst.toStringInorder());
         assertEquals("1 3 5 10 12 123", bst.toStringInorder());
     }
    @Test
    public void testRemove(){
        OrderedSet<Integer> bst = new OrderedSet<Integer>();
        assertFalse(bst.remove(12));
        bst.add(20);
        bst.add(30);
        bst.add(40);
        bst.remove(20);
        assertEquals("30 40 ", bst.toStringInorder());
        bst.add(50);
        bst.add(60);
        bst.add(70);
        bst.add(80);
        bst.remove(50);
        assertEquals("30 40 60 70 80 ", bst.toStringInorder());
        OrderedSet<Integer> bsts = new OrderedSet<Integer>();
        bsts.add(50);
        bsts.add(75);
        bsts.add(25);
        bsts.add(30);
        bsts.add(80);
        bsts.add(95);
        bsts.add(85);
        bsts.add(90);
        bsts.add(82);
        bsts.add(87);
        bsts.add(99);
        assertTrue(bsts.contains(90));
        assertTrue(bsts.remove(82));
        System.out.println(bsts.toStringInorder());
        assertFalse(bsts.remove(12));
        System.out.println(bsts.toStringInorder());
        assertTrue(bsts.remove(95));
        assertTrue(bsts.remove(80));
        assertTrue(bsts.remove(25));
        OrderedSet<Integer> newBst = new OrderedSet<Integer>();
        newBst.add(12);
        newBst.add(34);
        newBst.remove(34);
        System.out.println(newBst.toStringInorder());
        newBst.remove(12);
        assertFalse(bsts.remove(0));
        assertTrue(bsts.remove(99));
        assertTrue(bsts.remove(90));
        assertTrue(bsts.remove(85));
        assertNotEquals(newBst.toStringInorder(), "34 12");
        System.out.println(bsts.toStringInorder());
     }

     @Test
    public void test(){

         OrderedSet<Integer> bsts = new OrderedSet<Integer>();
         System.out.println(bsts.toStringInorder());
         OrderedSet<Integer> xd = new OrderedSet<>();
         xd.contains(12);
         bsts.add(50);
         bsts.add(75);
         bsts.add(25);
         bsts.add(30);
         bsts.add(80);
         bsts.add(95);
         bsts.add(85);
         bsts.add(90);
         bsts.add(82);
         bsts.add(87);
         bsts.add(99);
         System.out.println(bsts.toStringInorder());
         System.out.println(bsts.contains(12));
         bsts.contains(24);
         bsts.remove(95);
         System.out.println(bsts.toStringInorder());
     }


}