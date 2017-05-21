import java.util.*;

public class MazeSolver {

    private Maze maze;
    private Frontier frontier;
    private final int[][] directions = { {0, -1},   // Left
					 {0, 1},    // Right
					 {1, 0},    // Up
					 {-1, 0} }; // Down

    
    public MazeSolver (Maze mzzz) {
	maze = mzzz;
    }

    public void solve () {
	solve(1);
    }

    public void solve (int style) {
	switch (style) {
	case 0 : depthFirstSearch();
	case 1 : breadthFirstSearch();
	case 2 : bestFirstSearch();
	case 3 : aStarSearch();
	}
    }

    private int getDist (Location loc1, Location loc2) {
	int rowDif = loc1.getRow() - loc2.getRow();
	int colDif = loc1.getCol() - loc2.getCol();
	return Math.abs(rowDif) + Math.abs(colDif);
    }

    private Location makeLoc (int row, int col, Location prev) {
	int dToStart = getDist(prev, maze.getStart());
	int dToGoal = getDist(prev, maze.getEnd());
	Location loc = new Location(row, col, prev, dToStart, dToGoal, prev.isAStar());
	return loc;
    }

    private ArrayList<Location> getAdjacent (Location loc) {

	ArrayList<Location> list = new ArrayList<Location>();

	for (int[] ary : directions) {
	    int r = loc.getRow() + ary[0], c = loc.getCol() + ary[1];
	    if (maze.get(r, c) == ' ') {
		list.add(makeLoc(r, c, loc));
	    }
	}

	return list;

    }

    private void depthFirstSearch () {
	frontier = new StackFrontier();
	// more stuff
    }

    private void breadthFirstSearch () {
	frontier = new QueueFrontier();
	// more stuff
    }

    private void bestFirstSearch () {
	frontier = new PQFrontier(false);
	// more stuff
    }

    private void aStarSearch () {
	frontier = new PQFrontier(true);
	// idek what this is tbh
    }

    public String toString () {
	return maze.toString();
    }

    public static void main (String[] args) {

	MazeSolver dank = new MazeSolver(new Maze(args[0]));

	if (args.length != 2) {
	    dank.solve();
	} else {
	    dank.solve(Integer.parseInt(args[1]));
	}
	
    }

}
