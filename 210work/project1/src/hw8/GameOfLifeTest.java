package hw8;


// Ivan Akinfiev

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GameOfLifeTest {
  @Test
  public void testConstructorAndGetters() {
    GameOfLife society = new GameOfLife(5, 8);
    assertEquals(5, society.numberOfRows());
    assertEquals(8, society.numberOfColumns());
    for (int r = 0; r < society.numberOfRows(); r++) {
      for (int c = 0; c < society.numberOfColumns(); c++) {
        assertFalse(society.cellAt(r, c));
      }
    }
  }

  @Test
  public void testGrowCellAtAndCellAt() {
    GameOfLife society = new GameOfLife(4, 4);
    society.growCellAt(1, 1);
    society.growCellAt(2, 2);
    society.growCellAt(3, 3);
    society.growCellAt(0,0);
    society.growCellAt(1,0);
    assertTrue(society.cellAt(1, 1));
    assertTrue(society.cellAt(2, 2));
    assertTrue(society.cellAt(3, 3));
    assertTrue(society.cellAt(0,0));
    System.out.println(society.toString());
  }

  @Test
  public void testNeighborsNoWrapping() {
    GameOfLife society = new GameOfLife(10, 16);
    society.growCellAt(3, 3);
    society.growCellAt(3, 4);
    society.growCellAt(3, 5);
    society.growCellAt(1, 1);
    society.growCellAt(2, 2);
    society.growCellAt(3, 3);
    society.growCellAt(0,0);
    society.growCellAt(7,8);
    society.growCellAt(9,10);
    society.growCellAt(3,0);
    society.growCellAt(5,15);
    society.growCellAt(2,9);
    society.growCellAt(1,0);
    society.growCellAt(2,10);
    society.growCellAt(1,0);
    society.growCellAt(1,0);
    society.growCellAt(0,15);
    society.growCellAt(1,15);
    society.growCellAt(9,15);
    society.growCellAt(9,14);
    society.growCellAt(9,0);



    System.out.println(society.toString());
    assertEquals(6, society.neighborCount(0, 0));
    assertEquals(0, society.neighborCount(9, 2));
    assertEquals(3, society.neighborCount(2, 3));
    assertEquals(3, society.neighborCount(1, 15));
    assertEquals(1, society.neighborCount(1, 11));
    assertEquals(3, society.neighborCount(1, 15));
    assertEquals(6, society.neighborCount(0, 15));
    assertEquals(4, society.neighborCount(9, 15));
    assertEquals(1, society.neighborCount(8, 13));
    assertEquals(1, society.neighborCount(2, 10));
    assertEquals(0, society.neighborCount(6, 11));
    assertEquals(1, society.neighborCount(9, 9));
    assertEquals(1, society.neighborCount(7, 7));
    assertEquals(3, society.neighborCount(8, 15));
    assertEquals(3, society.neighborCount(9, 0));
    assertEquals(3, society.neighborCount(9, 0));
    assertEquals(1, society.neighborCount(5, 0));
    assertEquals(0, society.neighborCount(3,0));

  }
  @Test
  public void testUpdate(){
    GameOfLife society = new GameOfLife(10, 16);
    society.growCellAt(3, 3);
    society.growCellAt(3, 4);
    society.growCellAt(3, 5);
    society.growCellAt(1, 1);
    society.growCellAt(2, 2);
    society.growCellAt(3, 3);
    society.growCellAt(0,0);
    society.growCellAt(1,0);
    society.growCellAt(0,15);
    society.growCellAt(1,15);
    society.growCellAt(9,15);
    society.growCellAt(9,14);
    society.growCellAt(9,0);

  }
  @Test
  public void testRows(){
    GameOfLife society = new GameOfLife(10, 16);
    GameOfLife societyTwo = new GameOfLife(15, 16);
    assertEquals(10, society.numberOfRows());
    assertEquals(15, societyTwo.numberOfRows());
  }
  // ... Add many more @Test methods with many, many assertions:

  @Test
  public void testColumns(){
    GameOfLife society = new GameOfLife(10, 16);
    assertEquals(16, society.numberOfColumns());
  }
  @Test
  public void testExistence(){
    GameOfLife society = new GameOfLife(10, 16);
    GameOfLife societyTwo = new GameOfLife(30, 30);
    society.growCellAt(1,15);
    society.growCellAt(9,15);
    societyTwo.growCellAt(9,15);
    assertTrue(society.cellAt(1,15));
    assertTrue(society.cellAt(9,15));
    assertTrue(societyTwo.cellAt(9,15));
    assertFalse(societyTwo.cellAt(10,16));

  }
  @Test
  public void updateTest(){
    GameOfLife societyTwo = new GameOfLife(30, 30);
    societyTwo.growCellAt(1,15);
    societyTwo.growCellAt(9,15);
    societyTwo.growCellAt(11,15);
    societyTwo.growCellAt(10,13);
    societyTwo.update();
    assertFalse(societyTwo.cellAt(9,15));
    assertFalse(societyTwo.cellAt(10,16));
    assertFalse(societyTwo.cellAt(8,14));
    assertFalse(societyTwo.cellAt(9,15));
    assertFalse(societyTwo.cellAt(7,15));
  }

}