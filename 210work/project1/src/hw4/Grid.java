package hw4;
/**
 * The Grid class is present to help students taking an introductory
 * problem-solving and programming class while using Rick Mercer's Computing
 * Fundamentals textbook in either C++ or Java from Franklin, Beedle,and
 * Associates. The Grid class supports the understanding of using existing
 * classes, sending messages, distinguishing between objects and classes,
 * learning sequential control, selection, repetition, methods,
 * argument/parameter associations, and so on. And it can be fun too!
 * 
 * The Grid class was written by Rick Mercer who was inspired by Rich Pattis'
 * Karel the Robot & a game he saw at Walt Disney's Epcot Center.
 * 
 */
// The following small program demonstrates a few Grid messages and the output
// from toString.
// Assume Grid.java is in the same directory (folder) as this file\
// public class SomeGridMessages {
// public static void main( String[] args ) {
// // Arguments needed to construct a Grid object go like this:
// // #rows, #columns, moverStartRow, moverStartColumn, moverStartDirection
// Grid tarpit = new Grid( 4, 12, 2, 1, Direction.EAST );
// // The name tarpit is used with respect for Rich Pattis' software company.
//
// tarpit.block( 1, 1 );
// System.out.println( tarpit.toString( ) );
// tarpit.move( );
// tarpit.putDown( );
// tarpit.move( );
// tarpit.turnLeft( );
// tarpit.move( );
// System.out.println( tarpit.toString( ) ); // Display current state
// }
// }
//
// Output
//
// The Grid:
// . . . . . . . . . . . .
// . # . . . . . . . . . .
// . > . . . . . . . . . .
// . . . . . . . . . . . .
//
// The Grid:
// . . . . . . . . . . . .
// . # . ^ . . . . . . . .
// . O . . . . . . . .
// . . . . . . . . . . . .
// This class should be used only with "Asserting Java" by Rick Mercer
//
// Last Modified 13-July-99: by Andrew Wilt
// Changed so the state of a Grid object can be
// viewed graphically by the GraphicGrid class included in this file.
//
// Changes--
// - Added setListener(Grid) which sets the object that
// is listening to this Grid.
//
// - Added updateState( ) This method calls the stateChanged method
// whenever the state of this Grid changes (by turnLeft( ), move( ), etc.)
// - Added cloneArray( ) A method that returns a clone of a char array.
// This clone is sent to the Grid.
//
// - Added setSleepTime( ) so that the period between changes can be adjusted.
// Update documentation. There is a bug when turning from intersection with a
// thing on it
//
// Modified by Rick Mercer 6-Jan-99:
// Uppercased the four directions (east is not EAST),
//
// Improved error handling
// Modified by Rick Mercer 6-Jan-99:
// Uppercased the four directions (east is not EAST),
// Improved error handling
// Modified by Rick Mercer 15-Sep-01:
// Removed the need for Direction.java and GridListener.java in order to
// reduce the number of files required to run a grid program
// Modified by Rick Mercer 14-Feb-02:
// Improved error handling for putDown and block
// 11-June-2021
// Added enum Direction to this file to avoid needed another file

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

enum Direction {
  NORTH, EAST, SOUTH, WEST;
}

public class Grid {

  // class constants available to wherever an instance of this class is
  // constructed
  public final static int MAX_ROWS = 22;
  public final static int MAX_COLUMNS = 36;

  // --class constant available only to other classes in this folder
  final static char intersectionChar = '.';
  final static char beenThereChar = ' ';
  final static char blockChar = '#';
  final static char thingHereChar = 'O';
  final static char moverOnThingChar = '&';
  final static char moverNorth = '^';
  final static char moverSouth = 'v';
  final static char moverEast = '>';
  final static char moverWest = '<';

  // --instance variables
  private Random ranNum;
  private int lastRow; // the number of the last row
  private int lastCol; // the number of the last column
  private char[][] rectangle = new char[MAX_ROWS][MAX_COLUMNS];
  private int currentRow; // The row where the mover is
  private int currentCol; // The column where the mover is
  private char icon; // the symbol in the currentRow, currentCol
  private Direction facing;
  private boolean showPath; // whether or not the path is shown
  private GraphicGrid myListener; // listener object to be notified when state
  // changes.
  // private boolean turningLeft = false;
  private int sleepTime = 500; // Default sleep time of 500 milliseconds

  // --Constructors (there are two)

  /**
   * Construct a totalRows by totalCols Grid object with the mover's start
   * position and direction are fixed by the arguments.
   * 
   * @param totalRows
   *          The maximum number of rows (Note the first row == 0)
   * @param totalCols
   *          The maximum number of columns (Note the first column == 0)
   * @param startRow
   *          The row in which the mover begins
   * @param startCol
   *          The column in which the mover begins
   * @param startDirection
   *          The direction in which the mover will face. This parameter should be
   *          specified as Direction.NORTH, Direction.EAST, Direction.SOUTH, or
   *          Direction.WEST. However, you could actually send use an int argument
   *          of 0 (Direction.NORTH), 1 (Direction.EAST) , 2, or 3
   *          (Direction.WEST), but it's not as clear.
   */
  public Grid(int totalRows, int totalCols, int startRow, int startCol, Direction startDirection) {
    // Check the initial position of the mover is within the Grid
    lastRow = totalRows - 1;
    lastCol = totalCols - 1;
    showPath = true; // Show path when true, when it's false keep the
    // intersection visible
    int r, c;
    for (r = 0; r <= lastRow; r++) {
      for (c = 0; c <= lastCol; c++) {
        rectangle[r][c] = intersectionChar;
      }
    }

    currentRow = startRow;
    currentCol = startCol;
    facing = startDirection;
    setIcon();
    rectangle[currentRow][currentCol] = icon;
    new GraphicGrid(this);
  }

  /**
   * Construct a totalRows by totalCols Grid object that has a border all around
   * it except for one exit placed in a random spot with the mover's start
   * position at some random location inside the Grid object facing a random
   * direction (Direction.NORTH, Direction.SOUTH, Direction.EAST, or
   * Direction.WEST).
   */
  public Grid(int totalRows, int totalCols) {
    if (totalRows > MAX_ROWS)
      error("row argument " + totalRows + " too large");
    else if (totalRows < 1)
      error(totalRows + " rows must be >= 1");
    if (totalCols > MAX_COLUMNS)
      error("column argument " + totalCols + " too large");
    if (totalCols < 1)
      error(totalCols + " columns must be >= 1");

    // Set up a border on the edges with one escape route
    ranNum = new Random();

    showPath = true; // Show path when true, when it's false 0 keep the
    // intersection visible
    lastRow = totalRows - 1;
    lastCol = totalCols - 1;

    int r, c;
    for (r = 0; r <= lastRow; r++) {
      for (c = 0; c <= lastCol; c++) {
        rectangle[r][c] = intersectionChar;
      }
    }

    for (c = 0; c <= lastCol; c++) {
      rectangle[0][c] = blockChar; // block first row
      rectangle[lastRow][c] = blockChar; // blocked last row
    }

    for (r = 0; r <= lastRow; r++) {
      rectangle[r][0] = blockChar; // block first column
      rectangle[r][lastCol] = blockChar; // block last column
    }

    // Put the mover somewhere in the Grid, but NOT a border
    ranNum = new Random();
    currentRow = Math.abs(ranNum.nextInt()) % (lastRow - 1) + 1;
    currentCol = Math.abs(ranNum.nextInt()) % (lastCol - 1) + 1;

    // Pick a random direction
    int direct = Math.abs(ranNum.nextInt()) % 4;
    if (direct == 0)
      facing = Direction.NORTH;
    else if (direct == 1)
      facing = Direction.EAST;
    else if (direct == 2)
      facing = Direction.SOUTH;
    else
      facing = Direction.WEST;

    setIcon();
    rectangle[currentRow][currentCol] = icon;

    // Put one opening on any of the four edges
    if (Math.abs(ranNum.nextInt()) % 2 == 0) { // set on top or bottom at
      // any
      // column
      c = Math.abs(ranNum.nextInt()) % lastCol;

      if (c == 0)
        c++; // avoid upper and lower left corner exits (see below)
      if (c == lastCol)
        c--; // avoid upper and lower right corner exits (see below)

      if (Math.abs(ranNum.nextInt()) % 2 == 0)
        r = lastRow; // half the time. on the bottom
      else
        r = 0; // the other half, on the top
    } else { // set on left or right at any column
      r = Math.abs(ranNum.nextInt()) % lastRow;

      if (r == 0) // avoid upper right and left corner exits
        r++;
      if (r == lastRow)
        r--; // avoid lower left and lower right exits

      if (Math.abs(ranNum.nextInt()) % 2 == 0)
        c = lastCol; // half the time in the right column
      else
        c = 0; // the other half, put on left
    }
    rectangle[r][c] = intersectionChar;
    new GraphicGrid(this);
  }

  // -accessors

  /**
   * The row in which this Grid object's mover is currently located.
   * 
   * @return the row where the mover currently is. Note: the first row is 0
   */
  public int moverRow() {
    return currentRow;
  }

  /**
   * The column in which this Grid object's mover is currently located
   * 
   * @return the row where the mover currently is. Note: the first column is 0
   */
  public int moverColumn() {
    return currentCol;
  }

  /**
   * Find out how many rows are in this particular Grid object
   * 
   * @return the number of rows in this Grid object
   */
  public int getRows() { // lastRow is the number of the last row as in
    // 0..lastRow
    // so the total number of rows is one more than that
    return lastRow + 1;
  }

  /**
   * Find out how many columns are in this particular Grid object
   * 
   * @return the number of columns in this Grid object
   */
  public int getColumns() { // lastCol is the number of the last column as in
    // 0..lastCol
    // so the total number of columns is one more than that
    return lastCol + 1;
  }

  /**
   * Find out if the mover could move one space forward
   * 
   * @return true if the mover could currently move forward by one space
   */
  public boolean frontIsClear() {
    if (facing == Direction.NORTH) {
      if (currentRow == 0)
        return false;
      else if (rectangle[currentRow - 1][currentCol] == blockChar)
        return false;
      else
        return true;
    } else if (facing == Direction.EAST) {
      if (currentCol == lastCol)
        return false;
      else if (rectangle[currentRow][currentCol + 1] == blockChar)
        return false;
      else
        return true;
    } else if (facing == Direction.SOUTH) {
      if (currentRow == lastRow)
        return false;
      else if (rectangle[currentRow + 1][currentCol] == blockChar)
        return false;
      else
        return true;
    } else // Must be facing West
    {
      if (currentCol == 0)
        return false;
      else if (rectangle[currentRow][currentCol - 1] == blockChar)
        return false;
      else
        return true;
    }
  }

  /**
   * Find out if the mover could move to the right with 3 turnLeft()s and a
   * move(1)
   * 
   * @return true if the mover could currently move right by one space
   */
  public boolean rightIsClear() {
    boolean result = true;

    if (facing == Direction.WEST) {
      if ((currentRow == 0) || (rectangle[currentRow - 1][currentCol] == blockChar))
        result = false;
    } else if (facing == Direction.NORTH) {
      if ((currentCol == lastCol) || (rectangle[currentRow][currentCol + 1] == blockChar))
        result = false;
    } else if (facing == Direction.EAST) {
      if ((currentRow == lastRow) || (rectangle[currentRow + 1][currentCol] == blockChar))
        result = false;
    } else // must be WEST
    {
      if ((currentCol == 0) || (rectangle[currentRow][currentCol - 1] == blockChar))
        result = false;
    }

    return result;
  }

  /**
   * Show the current state of this Grid object
   */
  public String toString() {
    int r, c;

    String result = "The Grid:\n";
    for (r = 0; r <= lastRow; r++) {
      for (c = 0; c <= lastCol; c++) {
        result += (char) rectangle[r][c] + " ";
      }
      result += "\n";
    }
    return result;
  }

  // -modifiers

  /**
   * The mover will be facing 90 degrees to the left.
   */
  public void turnLeft() {
    if (facing == Direction.NORTH)
      facing = Direction.WEST;
    else if (facing == Direction.EAST)
      facing = Direction.NORTH;
    else if (facing == Direction.SOUTH)
      facing = Direction.EAST;
    else
      // must be facing west
      facing = Direction.SOUTH;

    setIcon();
    rectangle[currentRow][currentCol] = icon;
    updateState();
  }

  /**
   * The mover will be facing 90 degrees to the right.
   */
  public void turnRight() {
    if (facing == Direction.NORTH)
      facing = Direction.EAST;
    else if (facing == Direction.EAST)
      facing = Direction.SOUTH;
    else if (facing == Direction.SOUTH)
      facing = Direction.WEST;
    else
      // must be facing west
      facing = Direction.NORTH;

    setIcon();
    rectangle[currentRow][currentCol] = icon;
    updateState();
  }

  // Only called from
  private void setIcon() {
    if (rectangle[currentRow][currentCol] == moverOnThingChar) {
      if (facing == Direction.NORTH)
        icon = moverNorth;
      else if (facing == Direction.EAST)
        icon = moverEast;
      else if (facing == Direction.SOUTH)
        icon = moverSouth;
      else
        // must be west
        icon = moverWest;
    } else {
      if (facing == Direction.NORTH)
        icon = moverNorth;
      else if (facing == Direction.EAST)
        icon = moverEast;
      else if (facing == Direction.SOUTH)
        icon = moverSouth;
      else
        // must be west
        icon = moverWest;
    }
  }

  public void move() {
    move(1);
  }

  /**
   * The mover will move spaces spaces forward if possible. If this is not
   * possible, the program will be terminated with an appropriate message.
   * 
   * @param spaces
   *          The number of spaces the mover should move forward.
   */
  private void move(int spaces) {
    int oldRow = currentRow;
    int oldCol = currentCol;

    if (facing == Direction.NORTH)
      currentRow -= spaces;
    else if (facing == Direction.EAST)
      currentCol += spaces;
    else if (facing == Direction.SOUTH)
      currentRow += spaces;
    else
      // must be west
      currentCol -= spaces;

    // Fix the intersection that is about to be moved away from
    if (rectangle[oldRow][oldCol] == moverOnThingChar)
      rectangle[oldRow][oldCol] = thingHereChar;
    else if ((rectangle[oldRow][oldCol] == icon) && showPath)
      rectangle[oldRow][oldCol] = beenThereChar;
    else
      rectangle[oldRow][oldCol] = intersectionChar;

    int r, c;
    if (facing == Direction.NORTH) {
      for (r = oldRow; r > currentRow; r--) {
        if (r <= 0) {
          if ((rectangle[r][currentCol] != thingHereChar) && showPath)
            rectangle[r][currentCol] = beenThereChar;
          error("Fell off the Direction.NORTH edge");
        }

        checkForBlock(r - 1, currentCol);

        if ((rectangle[r][currentCol] != thingHereChar) && showPath)
          rectangle[r][currentCol] = beenThereChar;
      }
    } else if (facing == Direction.EAST) {
      for (c = oldCol; c < currentCol; c++) {
        checkForBlock(currentRow, c + 1);
        if (c >= lastCol) {
          if ((rectangle[currentRow][c] != thingHereChar) && showPath)
            rectangle[currentRow][c] = beenThereChar;
          error("Fell off the EAST edge");
        }
        if ((rectangle[currentRow][c] != thingHereChar) && showPath)
          rectangle[currentRow][c] = beenThereChar;
      }
    }
    if (facing == Direction.SOUTH) {
      for (r = oldRow; r < currentRow; r++) {
        checkForBlock(r + 1, currentCol);
        if (r >= lastRow) {
          if ((rectangle[r][currentCol] != thingHereChar) && showPath)
            rectangle[r][currentCol] = beenThereChar;
          error("Fell off the SOUTH edge");
        }
        if ((rectangle[r][currentCol] != thingHereChar) && showPath)
          rectangle[r][currentCol] = beenThereChar;
      }
    } else { // Direction Must be WEST
      for (c = oldCol; c > currentCol; c--) {
        if (c <= 0) {
          if ((rectangle[currentRow][c] != thingHereChar) && showPath)
            rectangle[currentRow][c] = beenThereChar;
          error("Fell off the WEST edge");
        }

        checkForBlock(currentRow, c - 1);

        if ((rectangle[currentRow][c] != thingHereChar) && showPath)
          rectangle[currentRow][c] = beenThereChar;
      }
    }

    if (rectangle[currentRow][currentCol] == thingHereChar)
      rectangle[currentRow][currentCol] = moverOnThingChar;
    else
      rectangle[currentRow][currentCol] = icon;

    updateState();
  }

  /**
   * Place a block on an intersection intersection (blockRow, blockCol). The mover
   * will not be allowed to move into this intersection. If blockRow or blockCol
   * are not within the Grid, or the intersection is already blocked, the program
   * terminates.
   * 
   * @param blockRow
   *          the row in which the block will be placed (if possible).
   * @param blockCol
   *          the column in which the block will be placed (if possible).
   */
  public void block(int blockRow, int blockCol) {
    if (blockRow > lastRow || blockRow < 0 || blockCol > lastCol || blockCol < 0)
      error("Can't block intersection at Grid(" + blockRow + ", " + blockCol + ")");

    // Can't block the place where the a block has been placed
    if (rectangle[blockRow][blockCol] == blockChar)
      error("Can't block intersection that is already blocked at (" + blockRow + ", " + blockCol + ")");

    // Can't block the place where the a block has been placed
    if (rectangle[blockRow][blockCol] == thingHereChar || rectangle[blockRow][blockCol] == moverOnThingChar)
      error("Can't block intersection with a thing put down at(" + blockRow + ", " + blockCol + ")");

    if (rectangle[blockRow][blockCol] == icon)
      error("Can't block where the mover is at Grid(" + blockRow + ", " + blockCol + ")");

    // Can block the specified row and column
    rectangle[blockRow][blockCol] = blockChar;
    updateState();
  }

  /**
   * Put down a thing on the Grid where the mover is currently located. If it is
   * blocked, or if there is a thing there already, the program terminates. This
   * method pressumes that the mover can never move into a blocked intersection or
   * off the edge. both of which are check in the move method
   */
  public void placeBeeper() { // All the requred work is in the other putDown
    // method
    placeBeeper(currentRow, currentCol);
  }

  /**
   * Place a thing on the intersection (blockRow, blockCol). If blockRow or
   * blockCol are not within the Grid, the program will terminate with an
   * appropriate message.
   * 
   * @param blockRow
   *          the row in which the block will be placed (if possible).
   * @param blockCol
   *          the column in which the block will be placed (if possible).
   */
  public void placeBeeper(int putDownRow, int putDownCol) {
    if (putDownRow > lastRow || putDownRow < 0 || putDownCol > lastCol || putDownCol < 0)
      error("Can't block intersection at Grid(" + putDownRow + ", " + putDownCol + ")");

    if (rectangle[putDownRow][putDownCol] == thingHereChar || rectangle[putDownRow][putDownCol] == moverOnThingChar
        || rectangle[putDownRow][putDownCol] == blockChar)
      error("This intersection has a thing or it has been blocked already(" + putDownRow + ", " + putDownCol + ")");

    if (rectangle[putDownRow][putDownCol] == icon)
      rectangle[putDownRow][putDownCol] = moverOnThingChar;
    else
      rectangle[putDownRow][putDownCol] = thingHereChar;

    updateState();
  }

  /**
   * Pick up a thing from the Grid where the mover is currently located
   */
  public void pickBeeper() {
    if (rectangle[currentRow][currentCol] != thingHereChar && rectangle[currentRow][currentCol] != moverOnThingChar)
      error("Attempt to pick up when nothing is at Grid(" + currentRow + ", " + currentCol + ")");

    rectangle[currentRow][currentCol] = icon;
    updateState();
  }

  /**
   * Change the state of this Grid object to either show the path taken by the
   * mover--if not currently shown, or to *not* show the path--if currently shown.
   */
  public void toggleShowPath() {
    showPath = !showPath;
  }

  private void error(String message) {
    System.out.println("\nERROR** " + message + "\n");
    System.out.println(this.toString());
    JOptionPane.showMessageDialog(null, message + "\nProgram will terminate");
    System.exit(0);
  }

  private void checkForBlock(int r, int c) {
    if (rectangle[r][c] == blockChar) {
      if (facing == Direction.NORTH) // must be moving Direction.NORTH
        rectangle[r + 1][c] = icon;
      else if (facing == Direction.EAST) // must be moving EAST
        rectangle[r][c - 1] = icon;
      else if (facing == Direction.SOUTH) // must be moving SOUTH
        rectangle[r - 1][c] = icon;
      else if (facing == Direction.WEST) // must be moving WEST
        rectangle[r][c + 1] = icon;
      error("Attempt to move through the block at Grid(" + r + ", " + c + ")");
    }
  }

  // The following methods were added by Andrew Wilt to make his GraphicGrid
  // class work

  /**
   * This method sets the listener that will be notified whenever the state of
   * this particular Grid object has been changed. This can be used for displaying
   * a Grid object in a graphical manner.
   * 
   * @param Grid
   *          The Listener object.
   */
  public void setGridListener(GraphicGrid listener) { // Andy Wilt
    if (listener != null)
      myListener = listener;
    updateState();
  }

  private void updateState() { // Andy Wilt
    if (myListener == null)
      return;

    char[][] newState = cloneArray();
    myListener.stateChanged(newState);

    try {
      Thread.sleep(sleepTime);
    } catch (InterruptedException e) {
    }
  }

  /**
   * Changes the amount of time that the Grid sleeps between moves.
   * 
   * @param int
   *          time
   */
  public void setDelayMilliseconds(int milliseconds) { // Andy Wilt
    sleepTime = milliseconds;
  }

  private char[][] cloneArray() { // Andy Wilt
    char[][] temp = (char[][]) rectangle.clone();
    for (int j = 0; j <= lastRow; j++)
      temp[j] = (char[]) temp[j].clone();
    return temp;
  }

} // end class Grid

/**
 * GraphicGrid is a companion to the Grid class by Rick Mercer. It displays a
 * Grid graphically in a Window. Changes to the Grid object can be seen in the
 * window. A program that has been written to use a Grid can be adapted very
 * easily to use the GraphicGrid. Example: ... Grid someGrid = new
 * Grid(5,8,3,4,Direction.WEST); // The Grid object constructed originally //
 * Make a GraphicGrid object sending the Grid object as a parameter. GraphicGrid
 * visibleGrid = new GraphicGrid(someGrid); ... This last line will start the
 * Window that displays the Grid someGrid. Any changes to someGrid such as
 * someGrid.move(), or someGrid.turnLeft() will be shown in the window. If an
 * error occurs, a modal dialog message box pops up to inform you that the
 * program will terminate
 * 
 * @author Andrew Wilt 12-July-99
 */
class GraphicGrid extends JFrame {

  public static void main(String[] args) {
    // When run, you can play with graphic grids
    new GraphicGrid();
  }

  /**
   * The Frame that holds the Grid to be displayed graphically The size of the
   * Window is set according to the size of the Grid. @ param Grid The Grid object
   * that is going to be sending stateChanges.
   */
  public GraphicGrid(Grid g) {
    super("Watch the actions of the grid");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    addWindowListener(new WindowAdapter() {

      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    myGrid = g;
    setSize(g.getColumns() * spotWidth + spacing, g.getRows() * spotHeight + spacing);
    myPanel = new GraphicGridPanel(g, spotWidth, spotHeight);
    myGrid.setGridListener(this);
    JSlider speedBar = new JSlider(JSlider.HORIZONTAL);
    speedBar.addChangeListener(new ChangeListener() {

      public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider) e.getSource();
        if (!source.getValueIsAdjusting())
          myGrid.setDelayMilliseconds((int) source.getValue() * 10);
      }
    });
    Container contentPane = getContentPane();
    contentPane.add(myPanel, "Center");
    contentPane.add(speedBar, "South");
    this.setVisible(true);
  }

  public GraphicGrid() {
    super("Interactive Grid");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    numRows = defaultNRows;
    numCols = defaultNColumns;
    myGrid = new Grid(defaultNRows, defaultNColumns, 0, 0, Direction.EAST);
    myPanel = new GraphicGridPanel(myGrid, spotWidth, spotHeight);
    myGrid.setGridListener(this);
    controls = makeButtons();
    Dimension gridSize = myPanel.getSize();
    Dimension controlSize = controls.getSize();
    setSize(new Dimension(Math.max(gridSize.width, controlSize.width) + 30, (gridSize.height + controlSize.height)));
    Container contentPane = getContentPane();

    contentPane.add(myPanel, "Center");
    contentPane.add(controls, "South");
    this.setVisible(true);
  }

  /**
   * Called by the Grid object whenever the state changes.
   * 
   * @param char[][]
   *          2D Array of chars that represents the Grid.
   */
  public void stateChanged(char[][] rect) {
    myPanel.stateChanged(rect);
  }

  private JPanel makeButtons() {
    JPanel gridControls = new JPanel();
    gridControls.setOpaque(true);
    gridControls.setLayout(new BoxLayout(gridControls, BoxLayout.Y_AXIS));
    MyTextFieldListener textListener = new MyTextFieldListener();

    // First row of objects
    JPanel firstRow = new JPanel();
    firstRow.setOpaque(true);
    JButton newGrid = new JButton("newGrid");
    final GraphicGrid outside = this;
    newGrid.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {
        if (moverRowNum < 0 || moverColNum < 0)
          myGrid = new Grid(numRows, numCols);
        else
          myGrid = new Grid(numRows, numCols, moverRowNum, moverColNum, currentDirection);
        myPanel.setGrid(myGrid);
        myGrid.setGridListener(outside);
        frontIsClearLabel.setText(String.valueOf(myGrid.frontIsClear()));
        Dimension gridSize = myPanel.getSize();
        Dimension controlSize = controls.getSize();
        setSize(new Dimension(Math.max(gridSize.width, controlSize.width), (gridSize.height + controlSize.height)));
        repaint();
      }
    });
    firstRow.add(newGrid);

    firstRow.add(new JLabel("nRows", SwingConstants.RIGHT));

    JTextField nRows = new JTextField(textFieldWidth);
    nRows.setText(String.valueOf(defaultNRows));
    nRows.getDocument().addDocumentListener(textListener);
    nRows.getDocument().putProperty("name", "nRows");
    firstRow.add(nRows);

    firstRow.add(new JLabel("nCols", SwingConstants.RIGHT));

    JTextField nCols = new JTextField(textFieldWidth);
    nCols.setText(String.valueOf(defaultNColumns));
    nCols.getDocument().addDocumentListener(textListener);
    nCols.getDocument().putProperty("name", "nCols");
    firstRow.add(nCols);
    gridControls.add(firstRow);

    // Second row of objects
    JPanel secondRow = new JPanel();
    secondRow.setOpaque(true);
    secondRow.add(new JLabel("moverRow", SwingConstants.RIGHT));

    JTextField moverRow = new JTextField(textFieldWidth);
    moverRow.setText(String.valueOf(0));
    moverRow.getDocument().addDocumentListener(textListener);
    moverRow.getDocument().putProperty("name", "moverRow");
    secondRow.add(moverRow);

    secondRow.add(new JLabel("moverCol", SwingConstants.RIGHT));

    JTextField moverCol = new JTextField(textFieldWidth);
    moverCol.setText(String.valueOf(0));
    moverCol.getDocument().addDocumentListener(textListener);
    moverCol.getDocument().putProperty("name", "moverCol");
    secondRow.add(moverCol);

    secondRow.add(new JLabel("moverDirection", SwingConstants.RIGHT));

    String[] dirList = { "NORTH", "SOUTH", "EAST", "WEST" };
    JComboBox<?> moverDirection = new JComboBox<Object>(dirList);
    moverDirection.setSelectedIndex(2);

    moverDirection.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {
        currentDirection = getDirection((String) ((JComboBox<?>) e.getSource()).getSelectedItem());
      }
    });

    secondRow.add(moverDirection);
    gridControls.add(secondRow);
    gridControls.add(Box.createRigidArea(new Dimension(0, 5)));

    // Fourth row of objects
    JPanel fourthRow = new JPanel();
    fourthRow.setOpaque(true);
    JButton block = new JButton("block");
    block.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {
        myGrid.block(blockRowNum, blockColNum);
      }
    });
    fourthRow.add(block);

    fourthRow.add(new JLabel("row", SwingConstants.RIGHT));

    JTextField blockRow = new JTextField(textFieldWidth);
    blockRow.setText(String.valueOf(blockRowNum));
    blockRow.getDocument().addDocumentListener(textListener);
    blockRow.getDocument().putProperty("name", "blockRow");
    fourthRow.add(blockRow);

    fourthRow.add(new JLabel("cols", SwingConstants.RIGHT));

    JTextField blockCol = new JTextField(textFieldWidth);
    blockCol.setText(String.valueOf(blockColNum));
    blockCol.getDocument().addDocumentListener(textListener);
    blockCol.getDocument().putProperty("name", "blockCol");
    fourthRow.add(blockCol);

    JButton putDown = new JButton("putDown");
    putDown.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {
        myGrid.placeBeeper(putDownRowNum, putDownColNum);
      }
    });
    fourthRow.add(putDown);

    fourthRow.add(new JLabel("row", SwingConstants.RIGHT));

    JTextField putDownRow = new JTextField(textFieldWidth);
    putDownRow.setText(String.valueOf(putDownRowNum));
    putDownRow.getDocument().addDocumentListener(textListener);
    putDownRow.getDocument().putProperty("name", "putDownRow");
    fourthRow.add(putDownRow);

    fourthRow.add(new JLabel("cols", SwingConstants.RIGHT));

    JTextField putDownCol = new JTextField(textFieldWidth);
    putDownCol.setText(String.valueOf(putDownColNum));
    putDownCol.getDocument().addDocumentListener(textListener);
    putDownCol.getDocument().putProperty("name", "putDownCol");
    fourthRow.add(putDownCol);
    gridControls.add(fourthRow);

    // Fifth row of objects
    JPanel fifthRow = new JPanel();
    fifthRow.setOpaque(true);
    JButton move = new JButton("move");
    move.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {
        myGrid.move();
      }
    });
    fifthRow.add(move);

    JButton turnLeft = new JButton("turnLeft");
    turnLeft.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {
        myGrid.turnLeft();
      }
    });
    fifthRow.add(turnLeft);

    JButton pickUp = new JButton("pickUp");
    pickUp.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {
        myGrid.pickBeeper();
      }
    });
    fifthRow.add(pickUp);

    JCheckBox showPath = new JCheckBox("showPath");
    showPath.setSelected(true);
    showPath.addItemListener(new ItemListener() {

      public void itemStateChanged(ItemEvent e) {
        myGrid.toggleShowPath();
      }
    });
    fifthRow.add(showPath);
    gridControls.add(fifthRow);

    // Sixth line of objects
    JPanel sixthRow = new JPanel();
    sixthRow.setOpaque(true);
    JButton frontIsClear = new JButton("frontIsClear");
    frontIsClear.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {
        frontIsClearLabel.setText(String.valueOf(myGrid.frontIsClear()));
      }
    });
    sixthRow.add(frontIsClear);

    frontIsClearLabel = new JLabel(String.valueOf(myGrid.frontIsClear()), SwingConstants.LEFT);
    sixthRow.add(frontIsClearLabel);

    gridControls.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Grid Commands"),
        BorderFactory.createEmptyBorder(5, 5, 5, 5)));

    gridControls.setSize(gridControls.getPreferredSize());

    return gridControls;
  }

  private int getNumber(String txt) {
    try {
      return Integer.parseInt(txt);
    } catch (NumberFormatException e) {
      return -1;
    }
  }

  private Direction getDirection(String dir) {
    if (dir.equals("NORTH"))
      return Direction.NORTH;
    else if (dir.equals("SOUTH"))
      return Direction.SOUTH;
    else if (dir.equals("EAST"))
      return Direction.EAST;
    else
      return Direction.WEST;
  }

  class MyTextFieldListener implements DocumentListener {

    public void insertUpdate(DocumentEvent e) {
      setValue(e);
    }

    public void removeUpdate(DocumentEvent e) {
      setValue(e);
    }

    public void changedUpdate(DocumentEvent e) {
    }

    private void setValue(DocumentEvent e) {
      Document field = e.getDocument();
      String txt = new String();
      try {
        txt = field.getText(0, field.getLength());
      } catch (BadLocationException exc) {
        return;
      }
      int temp = getNumber(txt);
      if (field.getProperty("name").equals("moverRow")) {
        if (txt.length() == 0)
          moverRowNum = -1;
        if (temp >= 0)
          moverRowNum = temp;
      }
      if (field.getProperty("name").equals("moverCol")) {
        if (txt.length() == 0)
          moverColNum = -1;
        if (temp >= 0)
          moverColNum = temp;
      }
      if (field.getProperty("name").equals("nRows")) {
        if (temp >= 0 && temp <= Grid.MAX_ROWS)
          numRows = temp;
      }
      if (field.getProperty("name").equals("nCols")) {
        if (temp >= 0 && temp <= Grid.MAX_COLUMNS)
          numCols = temp;
      }
      if (field.getProperty("name").equals("blockRow")) {
        if (temp >= 0)
          blockRowNum = temp;
      }
      if (field.getProperty("name").equals("blockCol")) {
        if (temp >= 0)
          blockColNum = temp;
      }
      if (field.getProperty("name").equals("putDownRow")) {
        if (temp >= 0)
          putDownRowNum = temp;
      }
      if (field.getProperty("name").equals("putDownCol")) {
        if (temp >= 0)
          putDownColNum = temp;
      }
      if (field.getProperty("name").equals("moveSpaces")) {
        if (temp >= 0)
          moveNumSpaces = temp;
        temp = moveNumSpaces;
      }
    }
  }

  protected JLabel frontIsClearLabel;

  protected JLabel rightIsClearLabel;

  private Grid myGrid;

  private JPanel controls;

  private GraphicGridPanel myPanel;

  private int defaultNRows = 7;

  private int defaultNColumns = 7;

  private int numRows;

  private int numCols;

  private int moverRowNum;

  private int moverColNum;

  private Direction currentDirection = Direction.EAST;

  private int blockRowNum;

  private int blockColNum;

  private int putDownRowNum;

  private int putDownColNum;

  private int moveNumSpaces;

  private static final int textFieldWidth = 3;

  private static final int spotWidth = 20;

  private static final int spotHeight = 20;

  private static final int spacing = 100;
}

class GraphicGridPanel extends JPanel {

  private static Color foreground = Color.black;

  private static Color background = Color.white;

  private static Color moverColor = Color.blue;

  /**
   * Constructs the Panel that the Grid will be drawn on. @ param Grid The grid
   * that will be drawn. @ param int spotWidth The width of each square that might
   * hold an element in the Grid. @ param int spotHeight The height of each square
   * in the Grid.
   */
  public GraphicGridPanel(Grid g, int spotWidth, int spotHeight) {
    myGrid = g;
    setOpaque(true);
    setBackground(background);
    setForeground(foreground);
    this.setFont(new Font("Serif", Font.PLAIN, 18));
    gridColumnSize = spotWidth;
    gridRowSize = spotHeight;
    setSize(new Dimension(gridColumnSize * myGrid.getColumns() + 60, gridRowSize * myGrid.getRows() + 60));
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (myGrid != null) {
      Dimension d = getSize();
      int x = d.width / 2 - gridColumnSize * myGrid.getColumns() / 2;
      int y = d.height / 2 - gridRowSize * myGrid.getRows() / 2;
      for (int r = 0; r < myGrid.getRows(); r++)
        for (int c = 0; c < myGrid.getColumns(); c++) {
          drawChar(g, x + c * gridColumnSize, y + r * gridRowSize, myRect[r][c]);
        }
    }
  }

  private void drawChar(Graphics g, int x, int y, char c) {
    switch (c) {
    case Grid.intersectionChar:
      g.fillOval(x + gridColumnSize / 2 - 2, y + gridRowSize / 2 - 2, 4, 4);
      break;
    case Grid.beenThereChar:
      break;
    case Grid.blockChar:
      g.setColor(new Color(168, 0, 0));
      g.fillRect(x, y, gridColumnSize, gridRowSize);
      g.setColor(foreground);
      g.drawLine(x, y + gridRowSize / 3, x + gridColumnSize - 1, y + gridRowSize / 3);
      g.drawLine(x, y + gridRowSize * 2 / 3, x + gridColumnSize - 1, y + gridRowSize * 2 / 3);
      break;
    case Grid.thingHereChar:
      g.fillOval(x + gridColumnSize / 10, y + gridRowSize / 10, gridColumnSize - 2 * gridColumnSize / 10,
          gridRowSize - 2 * gridRowSize / 10);
      g.setColor(new Color(243, 218, 88));
      g.fillOval(x + gridColumnSize / 3, y + gridRowSize / 3, gridColumnSize - 2 * gridColumnSize / 3,
          gridRowSize - 2 * gridRowSize / 3);
      g.setColor(foreground);
      break;
    case Grid.moverOnThingChar:
      int[] xpts = { x + gridColumnSize / 2, x + gridColumnSize / 9, x + gridColumnSize / 2,
          x + gridColumnSize - 2 * gridColumnSize / 9 };
      int[] ypts = { y + gridRowSize / 9, y + gridRowSize / 2, y + gridRowSize - 2 * gridRowSize / 9,
          y + gridRowSize / 2 };
      g.setColor(new Color(80, 231, 252));
      g.fillRect(x + gridColumnSize / 4, y + gridRowSize / 4, gridColumnSize - 2 * gridColumnSize / 4,
          gridRowSize - 2 * gridRowSize / 4);
      g.fillPolygon(xpts, ypts, xpts.length);
      g.setColor(foreground);
      break;
    case Grid.moverNorth:
      drawMover(g, x, y, 120, 300);
      break;
    case Grid.moverSouth:
      drawMover(g, x, y, 300, 300);
      break;
    case Grid.moverEast:
      drawMover(g, x, y, 30, 300);
      break;
    case Grid.moverWest:
      drawMover(g, x, y, 210, 300);
      break;
    }
  }

  private void drawMover(Graphics g, int x, int y, int startAngle, int degrees) {
    g.setColor(background);
    g.fillRect(x, y, gridColumnSize, gridRowSize);
    g.setColor(moverColor);
    g.fillArc(x, y, gridColumnSize, gridRowSize, startAngle, degrees);
    g.setColor(foreground);
  }

  /**
   * Changes the Grid that this panel draws. @ param Grid The new grid to be
   * drawn.
   */
  public void setGrid(Grid g) {
    myGrid = g;
    setSize(new Dimension(gridColumnSize * myGrid.getColumns() + 60, gridRowSize * myGrid.getRows() + 60));
  }

  /**
   * Called by the Grid object whenever its state changes.
   * 
   * @param char[][]
   *          rect The 2D array of chars that represents the Grid
   */
  public void stateChanged(char[][] rect) {
    myRect = rect;
    repaint();
  }

  private int gridRowSize;
  private int gridColumnSize;
  private Grid myGrid;
  private char[][] myRect;
}