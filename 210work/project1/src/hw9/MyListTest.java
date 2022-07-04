package hw9;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class MyListTest {

    @Test
    public void testAdd(){
        MyList<String> arr = new MyList<String>();
        arr.add(0, "One");
        arr.add(1, "Two");
        arr.add(2, "Three");
        arr.add(3, "Four");
        arr.add(4, "Five");
        arr.set(3, "FOUR");
        arr.set(1, "TWO");
        arr.remove("FOUR");
        arr.remove("Five");
        arr.remove("One");
        System.out.println(arr.find("Three"));
        assertEquals(arr.find("TWO"), "TWO");
        System.out.println(arr.toString());
        assertEquals("One", arr.get(0));
    }



}
