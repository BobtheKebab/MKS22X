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
	    System.out.println("Invalid file name/path");
	}
    }

    private void fillMaze (File data) throws FileNotFoundException {

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
	//System.out.println(rows);
	//System.out.println(cols);
	maze = new char[rows][cols];

	// Fill the maze
	skan = new Scanner(data);
	for (int count = 0; count < maze.length; count++) {
	    String text = skan.nextLine();
	    //System.out.println(text);
	    for (int num = 0; num < maze[0].length; num++) {
		if (text.charAt(num) == 'S') {
		    startLoc[0] = count;
		    startLoc[1] = num;
		}
		
		maze[count][num] = text.charAt(num);
	    }
	}
    }

    public boolean solve () {
	int row = startLoc[0], col = startLoc[1];
	maze[row][col] = ' ';
	return solveH(row, col);
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

    private boolean solveH (int row, int col) {
	char chr = maze[row][col];
	if (chr == '#' || chr == '.') {
	    return false;
	}
	if (chr  == 'E') {
	    return true;
	}
	
	maze[row][col] = '.';
	System.out.println(toString());

	for (int[] ary : moves) {
	    if (solveH(row + ary[0], col + ary[1])) {
		return true;
	    }
	}

	return false;
    }

    public static void main (String[] args) {

	Maze dank = new Maze("data3.dat");
	System.out.println(dank.solve());

    }
	    
}
