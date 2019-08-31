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
		ArrayList<Cell> unvisitedNeighbors = getUnvisitedNeighbors(currentCell);
		//C. if has unvisited neighbors,
			if (!unvisitedNeighbors.isEmpty()) {
			//C1. select one at random.
			Random rand = new Random();
			int r = rand.nextInt(unvisitedNeighbors.size());
			//C2. push it to the stack
			uncheckedCells.push(unvisitedNeighbors.get(r));
			//C3. remove the wall between the two cells
			removeWalls(currentCell, unvisitedNeighbors.get(r));
			//C4. make the new cell the current cell and mark it as visited
			currentCell = unvisitedNeighbors.get(r);
			currentCell.hasBeenVisited();
			//unvisitedNeighbors.get(r).hasBeenVisited();
			//unvisitedNeighbors.remove(r);
			//C5. call the selectNextPath method with the current cell
			selectNextPath(currentCell);
			}
			
		//D. if all neighbors are visited
			if (unvisitedNeighbors.isEmpty() || unvisitedNeighbors.equals(null)) {
			//D1. if the stack is not empty
				if (uncheckedCells.isEmpty()) {
				// D1a. pop a cell from the stack
					Cell pop = uncheckedCells.pop();
				// D1b. make that the current cell
					currentCell = pop;
				// D1c. call the selectNextPath method with the current cell
					selectNextPath(currentCell);
				}
			}
	}

	//7. Complete the remove walls method.
	//   This method will check if c1 and c2 are adjacent.
	//   If they are, the walls between them are removed.
	private static void removeWalls(Cell c1, Cell c2) {
		System.out.println("c1 coordinates: (" + c1.getX() + ", " + c1.getY() + ")");
		System.out.println("c2 coordinates: (" + c2.getX() + ", " + c2.getY() + ")");
		if(c1.getX() == c2.getX() && c2.getY() + 1 == c1.getY()) {
			System.out.println("c1 is top, c2 is bottom");
			c1.setSouthWall(false);
			c2.setNorthWall(false);
		} else if (c1.getX() == c2.getX() && c1.getY() + 1 == c2.getY()) {
			System.out.println("c1 is bottom, c2 is top");
			c1.setNorthWall(false);
			c2.setSouthWall(false);
		} else if (c1.getY() == c2.getY() && c1.getX() + 1 == c2.getX()) {
			System.out.println("c1 is right, c2 is left");
			c1.setWestWall(false);
			c2.setEastWall(false);
		} else if (c1.getY() == c2.getY() && c2.getX() + 1 == c1.getX()) {
			System.out.println("c1 is left, c2 is right");
			c1.setEastWall(false);
			c2.setWestWall(false);
		} else {
			System.out.println("Next pair");
		}
	}
	
	//8. Complete the getUnvisitedNeighbors method
	//   Any unvisited neighbor of the passed in cell gets added
	//   to the ArrayList
	
	private static ArrayList<Cell> getUnvisitedNeighbors(Cell c) { 
		ArrayList<Cell> neighbors = new ArrayList<Cell>();
		int row = c.getX();
		int col = c.getY();
		if (row != 0 && col != 0) {
			if (!Maze.cells[row - 1][col - 1].hasBeenVisited()) { // 1
				neighbors.add(Maze.cells[row - 1][col - 1]);
			}
		}
		if (row != 0) {
			if (!Maze.cells[row - 1][col].hasBeenVisited()) { // 4
				neighbors.add(Maze.cells[row - 1][col]);
			}
			if (col < Maze.cells.length-1) {
				if (!Maze.cells[row - 1][col + 1].hasBeenVisited()) { // 6
					neighbors.add(Maze.cells[row - 1][col + 1]);
				}
			}
		}
		if (col != 0) {
			if (!Maze.cells[row][col - 1].hasBeenVisited()) { // 2
				neighbors.add(Maze.cells[row][col -1]);
			}
			if (row < Maze.cells.length-1) {
				if (Maze.cells[row + 1][col - 1].hasBeenVisited()) { // 3
					neighbors.add(Maze.cells[row + 1][col - 1]);
				}
			}
		}
		if (col < Maze.cells.length-1) {
			if (Maze.cells[row][col + 1].hasBeenVisited()) { // 7
				neighbors.add(Maze.cells[row][col + 1]);
			}
		}
		if (row < Maze.cells.length-1) {
			if (Maze.cells[row + 1][col ].hasBeenVisited()) { // 5
				neighbors.add(Maze.cells[row + 1][col]);
			}
			if (col < Maze.cells.length-1) {
				if (Maze.cells[row + 1][col + 1].hasBeenVisited()) { // 8
					neighbors.add(Maze.cells[row + 1][col + 1]);
				}
			}
		}
		return neighbors;
	}
}
