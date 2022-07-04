package hw8;

/**
 * The model for John Conway's Game of Life. This class has all needed methods
 * as method stubs. The preceding comments for each are the specification for
 * the method and explain method what each method does.
 *
 * @author Rick Mercer and Ivan Akinfiev
 */
public class GameOfLife {

	// Use this data structure to represent the existence of cells.
	// A true value means a cell exists at that location.
	private boolean[][] society;

	/*
	 * Write the constructor so it takes two integer arguments to represent the
	 * number of rows and columns in the game of life. The constructor creates a
	 * society with no cells but space to store rows*cols cells.
	 *
	 * @param rows The height of the grid that shows the cells.
	 *
	 * @param cols The width of the grid that shows the cells.
	 *
	 * Precondition rows and cols are in the range of 5 through 50
	 */
	public GameOfLife(int rows, int cols) {
		society = new boolean[rows][cols];
	}

	/**
	 * Return the number of rows, which can be indexed from 0..numberOfRows()-1.
	 *
	 * @return The height of the society.
	 */
	public int numberOfRows() {
		return society.length;
	}

	/*
	 * The number of columns, which can be indexed from 0..numberOfColumns()-1.
	 *
	 * @return The height of the society.
	 */
	public int numberOfColumns() {
		return society[0].length;
	}

	/*
	 * Place a new cell in the society.
	 *
	 * @param row The row to grow the cell.
	 *
	 * @param col The column to grow the cell.
	 *
	 * Precondition: row and col are in range of the 2D array.
	 */
	public void growCellAt(int row, int col) {
		society[row][col] = true;
	}

	/*
	 * Return true if there is a cell at the given row and column. Return false if
	 * there is no cell at the specified location.
	 *
	 * @param row The row to check.
	 *
	 * @param col The column to check.
	 *
	 * @return True if there is a cell at the given row or false if none
	 *
	 * Precondition: row and col are in range.
	 */
	public boolean cellAt(int row, int col) {
		return society[row][col];
	}

	/*
	 * Return one big string of cells to represent the current state of the society
	 * of cells (see output below where '.' represents an empty space and 'O' is a
	 * live cell. There is no need to test toString. Simply use it to visually
	 * inspect if needed. Here is one sample output from toString:
	 *
	 * GameOfLife society = new GameOfLife(4, 14); society.growCellAt(1, 2);
	 * society.growCellAt(2, 3); society.growCellAt(3, 4);
	 * System.out.println(society.toString());
	 *
	 * @return A textual representation of this society of cells.
	 */
	// Sample Output:
	// ..............
	// ..O...........
	// ...O..........
	// ....O.........
	@Override
	public String toString() {
		// TODO: Complete this method. you need to send this object a
		// toString message to get 100% code coverage with EclEmma.
		// Do not write an assertion for this in an @Test.
		String window = "";
		for (boolean[] booleans : society) {
			for (int col = 0; col < booleans.length; col++) {
				if (booleans[col]) {
					window = window + "O";
				} else
					window = window + ".";
			}
			window = window + "\n";
		}

		return window;
	}

	/*
	 * The return values should always be in the range of 0 through 8.
	 *
	 * @return The number of neighbors around any cell using wrap around.
	 *
	 *
	 * Count the neighbors around the given location. Use wraparound. A cell in row
	 * 0 has neighbors in the last row if a cell is in the same column, or the
	 * column to the left or right. In this example, cell 0,5 has two neighbors in
	 * the last row, cell 2,8 has four neighbors, cell 2,0 has four neighbors, cell
	 * 1,0 has three neighbors. The cell at 3,8 has 3 neighbors. The potential
	 * location for a cell at 4,8 would have three neighbors.
	 */
	// .....O..O
	// O........
	// O.......O
	// O.......O
	// ....O.O..
	//
	// Precondition: row and col are in range of the 2D array
	public int neighborCount(int row, int col) {
		int count = 0; // Our result.
		int i = row;
		int j = col;
		int colMax = society[0].length - 1;
		int rowMax = society.length - 1;
		if (i == 0 && j == 0) {
			if (society[1][0])
				count++;
			if (society[1][1])
				count++;
			if (society[0][1])
				count++;
			if (society[rowMax][0])
				count++;
			if (society[rowMax][1])
				count++;
			if (society[0][colMax])
				count++;
			if (society[1][colMax])
				count++;
			if (society[rowMax][colMax])
				count++;
		} else if (i == 0 && j == colMax) {
			if (society[1][0])
				count++;
			if (society[0][0])
				count++;
			if (society[rowMax][0])
				count++;
			if (society[rowMax][colMax])
				count++;
			if (society[rowMax][colMax - 1])
				count++;
			if (society[0][colMax - 1])
				count++;
			if (society[1][colMax])
				count++;
			if (society[1][colMax - 1])
				count++;

		} else if (i == rowMax && j == 0) {
			if (society[0][0])
				count++;
			if (society[0][1])
				count++;
			if (society[0][colMax])
				count++;
			if (society[rowMax][colMax])
				count++;
			if (society[rowMax - 1][colMax])
				count++;
			if (society[rowMax - 1][0])
				count++;
			if (society[rowMax - 1][1])
				count++;
			if (society[rowMax][1])
				count++;
		} else if (i == rowMax && j == colMax) {
			if (society[0][0])
				count++;
			if (society[rowMax][0])
				count++;
			if (society[rowMax - 1][0])
				count++;
			if (society[0][colMax])
				count++;
			if (society[0][colMax - 1])
				count++;
			if (society[rowMax - 1][colMax - 1])
				count++;
			if (society[rowMax - 1][colMax])
				count++;
			if (society[rowMax][colMax - 1])
				count++;
		} else if (i == 0) {
			if (society[0][j - 1])
				count++;
			if (society[0][j + 1])
				count++;
			if (society[1][j])
				count++;
			if (society[1][j + 1])
				count++;
			if (society[1][j - 1])
				count++;
			if (society[rowMax][j])
				count++;
			if (society[rowMax][j + 1])
				count++;
			if (society[rowMax][j - 1])
				count++;
		} else if (j == 0) {
			if (society[i - 1][0])
				count++;
			if (society[i + 1][0])
				count++;
			if (society[i - 1][1])
				count++;
			if (society[i + 1][1])
				count++;
			if (society[i][1])
				count++;
			if (society[i][colMax])
				count++;
			if (society[i + 1][colMax])
				count++;
			if (society[i - 1][colMax])
				count++;
		} else if (j == colMax) {
			if (society[i - 1][colMax])
				count++;
			if (society[i + 1][colMax])
				count++;
			if (society[i][colMax - 1])
				count++;
			if (society[i - 1][colMax - 1])
				count++;
			if (society[i + 1][colMax - 1])
				count++;
			if (society[i][0])
				count++;
			if (society[i + 1][0])
				count++;
			if (society[i - 1][0])
				count++;
		} else if (i == rowMax) {
			if (society[rowMax][j - 1])
				count++;
			if (society[rowMax][j + 1])
				count++;
			if (society[rowMax - 1][j])
				count++;
			if (society[rowMax - 1][j + 1])
				count++;
			if (society[rowMax - 1][j - 1])
				count++;
			if (society[0][j])
				count++;
			if (society[0][j + 1])
				count++;
			if (society[0][j - 1])
				count++;
		} else {
			if (society[i][j + 1])
				count++;
			if (society[i][j - 1])
				count++;
			if (society[i + 1][j + 1])
				count++;
			if (society[i - 1][j - 1])
				count++;
			if (society[i + 1][j])
				count++;
			if (society[i - 1][j])
				count++;
			if (society[i + 1][j - 1])
				count++;
			if (society[i - 1][j + 1])
				count++;
		}
		return count;
	}

	/*
	 * Update the state to represent the next society. Typically, some cells will
	 * die off while others are born.
	 */
	public void update() {
		int rows = society.length;
		int cols = society[0].length;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (cellAt(i, j)) {
					if (neighborCount(i, j) > 3 || neighborCount(i, j) < 2) {
						society[i][j] = false;
					}
				} else {
					if (neighborCount(i, j) == 3)
						society[i][j] = true;
				}
			}
		}
	}

}