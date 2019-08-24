package _04_Maze_Maker;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;


public class MazeMaker{
	
	private static int width;
	private static int height;
	
	private static Maze maze;
	
	private static Random randGen = new Random();
	private static Stack<Cell> uncheckedCells = new Stack<Cell>();
	
	
	public static Maze generateMaze(int w, int h){
		width = w;
		height = h;
		maze = new Maze(width, height);
		
		//4. select a random cell to start
		int x = randGen.nextInt(width);
		int y = randGen.nextInt(height);
		Cell victim = maze.getCell(x, y);
		
		//5. call selectNextPath method with the randomly selected cell
		selectNextPath(victim);
		
		return maze;
	}

	//6. Complete the selectNextPathMethod
	private static void selectNextPath(Cell currentCell) {
		//A. mark cell as visited
		currentCell.hasBeenVisited();
		//B. Get an ArrayList of unvisited neighbors using the current cell and the method below
		
		//C. if has unvisited neighbors,
		
			//C1. select one at random.
			
			//C2. push it to the stack
		
			//C3. remove the wall between the two cells

			//C4. make the new cell the current cell and mark it as visited
		
			//C5. call the selectNextPath method with the current cell
			
			
		//D. if all neighbors are visited
		
			//D1. if the stack is not empty
			
				// D1a. pop a cell from the stack
		
				// D1b. make that the current cell
		
				// D1c. call the selectNextPath method with the current cell
				
			
		
	}

	//7. Complete the remove walls method.
	//   This method will check if c1 and c2 are adjacent.
	//   If they are, the walls between them are removed.
	private static void removeWalls(Cell c1, Cell c2) {
		
	}
	
	//8. Complete the getUnvisitedNeighbors method
	//   Any unvisited neighbor of the passed in cell gets added
	//   to the ArrayList
	
	private static ArrayList<Cell> getUnvisitedNeighbors(Cell c) { 
		if (c.getX() != 0 && c.getY() != 0) {
			if (cells[x - 1][y - 1].isAlive) { // 1
				neighbors++;
			}
		}
		if (c.getX() != 0) {
			if (cells[x - 1][y].isAlive) { // 4
				neighbors++;
			}
			if (y < cells.length-1) {
				if (cells[x - 1][y + 1].isAlive) { // 6
					neighbors++;
				}
			}
		}
		if (y != 0) {
			if (cells[x][y - 1].isAlive) { // 2
				neighbors++;
			}
			if (x < cells.length-1) {
				if (cells[x + 1][y - 1].isAlive) { // 3
					neighbors++;
				}
			}
		}
		if (y < cells.length-1) {
			if (cells[x][y + 1].isAlive) { // 7
				neighbors++;
			}
		}
		if (x < cells.length-1) {
			if (cells[x + 1][y].isAlive) { // 5
				neighbors++;
			}
			if (y < cells.length-1) {
				if (cells[x + 1][y + 1].isAlive) { // 8
					neighbors++;
				}
			}
		}

		return neighbors;
	}
}
