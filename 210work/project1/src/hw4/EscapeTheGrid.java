/*
Name: Rick Mercer and Ivan Akinfiev
Course: CSC210

Program: This program is also playing a game, but without a user. Pacman needs
to find an exit from the cell. I've implemented this algorithm in the following ways:
First, Pacman finds a wall, and then starts moving along the fence. When it found the corner
with (1,1) coordinates, it starts also moving along the fence, but now it will check every possible
cell for an exit. When the wall is empty, it will move there and the game will stop.
 */

package hw4;

public class EscapeTheGrid {
	public static void main(String[] args) {
		Grid tarpit = new Grid(10, 20);
		boolean weAtTheCorner = false;
		while (true) {
			if (tarpit.moverRow() <= 0 || tarpit.moverColumn() <= 0 || tarpit.moverColumn() > 18
					|| tarpit.moverRow() > 8) {
				System.out.println("WE WON");
				break;
			}
			if (tarpit.moverColumn() == 1 && tarpit.moverRow() == 1) {
				weAtTheCorner = true;
			}
			if (tarpit.frontIsClear()) {
				tarpit.move();
			} else if (!tarpit.frontIsClear()) {
				tarpit.turnLeft();
			}
			if (weAtTheCorner) {
				if (tarpit.rightIsClear()) {
					tarpit.turnRight();
					tarpit.move();
					System.out.println("WE WON!!!");
					break;
				}

			}
		}
	}
}