import java.util.*;
import java.io.*;

public class Maze {

    public char[][] maze;
    private boolean animate;
    private int[] startLoc = new int[2];
    private int[][] moves = { {-1, 0},
			      {0, 1},
			      {1, 0},
			      {0, -1} };

    public Maze (String fileName) {
	animate = false;
	try {
	    File data = new File(fileName);;
	    fillMaze(data);
	} catch (FileNotFoundException e) {
	    e = new FileNotFoundException("Invalid file name/path");
	    System.out.println(e);
	    System.exit(0);
	} catch (Exception e) {
	    System.out.println(e);
	    System.exit(0);
	}
    }

    private void fillMaze (File data) throws FileNotFoundException, Exception {

	// Initialize maze
	
	Scanner skan = new Scanner(data);
	int rows = 0, cols = 0, colCount = 0;
	
	while (skan.hasNextLine()) {
	    rows++;
	    if (colCount == 0) {
		cols = skan.nextLine().length();
		colCount++;
	    } else {
		skan.nextLine();
	    }
	}
	maze = new char[rows][cols];

	// Fill the maze
	
	boolean isE = false;
	skan = new Scanner(data);
	
	for (int count = 0; count < maze.length; count++) {
	    String text = skan.nextLine();
	    for (int num = 0; num < maze[0].length; num++) {
		char chr = text.charAt(num);
		if (chr == 'S') {
		    startLoc[0] = count;
		    startLoc[1] = num;
		}
		if (chr == 'E') {
		    isE = true;
		}
		maze[count][num] = text.charAt(num);
	    }
	}

	// Check if missing E or S

	if (isE == false) {
	    throw new Exception("Maze doesn't contain end point");
	    //return;
	}
	if (startLoc[0] == 0) {
	    throw new Exception("Maze doesn't contain start point");
	    //return;
	}
	
    }

    private void wait (int time) {
         try {
             Thread.sleep(time);
         }
         catch (InterruptedException e) {
         }
    }

    public void setAnimate (boolean bool) {
	animate = bool;
    }

    public void clearTerminal (){
	System.out.println("\033[2J\033[1;1H");
    }

    public String toString () {
	String str = "";
	for (char[] ary : maze) {
	    for (char chr : ary) {
		str += chr;
	    }
	    str += "\n";
	}
	return str;
    }

    public boolean solve () {
	int row = startLoc[0], col = startLoc[1];
	maze[row][col] = ' ';
	return solveH(row, col);
    }

    private boolean solveH (int row, int col) {

	if (animate) {
	    clearTerminal();
	    System.out.println(toString());
	    wait(60);
	}
	
	char chr = maze[row][col];
	if (chr  == 'E') {
	    return true;
	}
	if (chr == '#' || chr == '.' || chr == '@') {
	    return false;
	}

	maze[row][col] = '@';
	System.out.println(toString());

	for (int[] ary : moves) {
	    if (solveH(row + ary[0], col + ary[1])) {
		return true;
	    }
	}

	maze[row][col] = '.';
	return false;
    }

    public static void main (String[] args) {

	Maze dank = new Maze("data3.dat");
	dank.setAnimate(true);
	System.out.println(dank.solve());

    }
	    
}
