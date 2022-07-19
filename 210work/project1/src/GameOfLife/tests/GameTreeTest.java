package GameOfLife.tests;

/*
 * A start of a unit test for class GameTree in the Game of 20 questions project.
 *
 * This class contains three methods to get you started and to explain some behavior.
 *
 *---@BeforeClass public static void setUp() throws FileNotFoundException
 * This setUp() method contains code that write a new file at
 * the beginning so that file always will have the same exact questions and answers.
 * Any method with @BeforeClass executes before any @Test method.
 *
 *---@Test public void testGameWithSevenNodes() {
 * Show how a game could be played by selecting Choice.YES and Choice.NO whi;
 * testing the current values of the nodes and asking if an abswer was found.
 *
 *---@Test public void testSaveGane() {
 * Test the save method after everything else is working!!!!!
 * Use testSaveGame to test your GameTree save method (you need to remove comments)
 * Method testSaveGame is a large test method that writes a new file, adds
 * questions and answers, saves the modified gGameTree and reads the new
 * game back to ensure save is working correctly.
 *
 * @author Rick Mercer and Ivan Akinfiev
 */

import static GameOfLife.model.Choice.NO;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;


import GameOfLife.model.Choice;
import GameOfLife.model.GameTree;

public class GameTreeTest {

  // This code executes once and only once before and @Test method runs. 
  // Good for initialization. This allows you to ALWAYS begin with the 
  // same exact questions and answers. The annotation is @BeforeClass.
  //
  @BeforeAll
  public static void setUp() throws FileNotFoundException {
    // Let outfile be an object like System.out. 
    // You can send println messages to outfile.
    PrintWriter outFile = 
        new PrintWriter(new FileOutputStream("t2UofATEST.txt"));

    // Write seven lines to an output file:
    outFile.println("Has feathers?");
    outFile.println("Barnyard?");
    outFile.println("chicken");
    outFile.println("owl");
    outFile.println("Is it a mammal?");
    outFile.println("tiger");
    outFile.println("rattlesnake");

    outFile.close(); // Make sure you close() the file
  }

  @Test
  public void TestConstructor(){
    GameTree tree = new GameTree("C:\\work\\320\\210work\\project1\\src\\GameOfLife\\actors.txt");
    System.out.println(tree.toString());
  }

  @Test
  public void testGameWithSevenNodes() {
    /*
     * This test uses the following input file t2UofATEST.txt Has feathers?
     * Barnyard? chicken owl Is it a mammal? tiger rattlesnake
     */
    GameTree aGame = new GameTree("t2UofATEST.txt");
    // Output from toString()
    // - - rattlesnake
    // - Is it a mammal?
    // - - tiger
    // Has feathers?
    // - - owl
    // - Barnyard?
    // - - chicken
    assertFalse(aGame.foundAnswer());
    assertEquals("Has feathers?", aGame.getCurrent());
    assertFalse(aGame.foundAnswer());
    Choice userSelection = Choice.YES;
    aGame.playerSelected(userSelection);
    assertEquals("Barnyard?", aGame.getCurrent());
    assertFalse(aGame.foundAnswer());
    aGame.playerSelected(Choice.NO);
    assertEquals("owl", aGame.getCurrent());
    assertTrue(aGame.foundAnswer());
    System.out.println(aGame.preOrder());
  }






  // Write more @Tests including one for add 
  // and another for saveGame at least.

  @Test
  public void testReStart(){
    GameTree aGame = new GameTree("t2UofATEST.txt");
    String stringRoot = aGame.getCurrent();
    aGame.playerSelected(Choice.NO);
    aGame.playerSelected(Choice.NO);
    aGame.reStart();
    assertEquals(stringRoot, aGame.getCurrent());


  }


  @Test
    public void testAdd(){
    GameTree aGame = new GameTree("t2UofATEST.txt");
    aGame.playerSelected(Choice.NO);
    aGame.playerSelected(Choice.NO);
    assertEquals("rattlesnake", aGame.getCurrent());
    aGame.add("Does it have 40 legs?", "Spider from Mars");
    System.out.println(aGame.getCurrent());
    assertEquals("Does it have 40 legs?", aGame.getCurrent());
    aGame.playerSelected(Choice.YES);
    assertEquals("Spider from Mars", aGame.getCurrent());




  }



  @Test
  public void saveGameTest() throws FileNotFoundException {

    GameTree aGame = new GameTree("C:\\work\\320\\210work\\project1\\src\\GameOfLife\\animals.txt");
    aGame.playerSelected(Choice.YES);
    System.out.println(aGame.getCurrent());
    aGame.playerSelected(Choice.NO);
    System.out.println(aGame.getCurrent());
    //aGame.add("Can it Speak?", "Parrot"); ALREADY ADDED. WE CAN ADD ANYTHING, BUT IT WILL WORK ONLY ONCE,
    // BECAUSE EVERYTIME WE OVERWRITE IT.
    aGame.saveGame(); // I don't know how to make this test "universal", since everytime we are adding something to a file,
                     // and it will not be the same.
    boolean check = false;
    Scanner scanner = new Scanner(new File("C:\\work\\320\\210work\\project1\\src\\GameOfLife\\animals.txt"));
    while (scanner.hasNext()){
      String temp = scanner.nextLine();
      if ("Parrot".equals(temp)) check = true;
    }
    assertTrue(check);
  }




}