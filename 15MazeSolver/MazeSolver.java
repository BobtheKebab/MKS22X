import java.util.*;

public class MazeSolver {

    private Maze maze;
    private Frontier frontier;
    private boolean animate;
    private final int[][] directions = { {0, -1},   // Left
					 {0, 1},    // Right
					 {1, 0},    // Up
					 {-1, 0} }; // Down
    
    public MazeSolver (Maze mzzz) {
	maze = mzzz;
    }

    public MazeSolver (Maze mzzz, boolean ani) {
	maze = mzzz;
	animate = ani;
    }

    public void solve () {
	solve(1);
    }

    public void solve (int style) {
	switch (style) {
	case 0 : frontier = new StackFrontier();   // Depth
	case 1 : frontier = new QueueFrontier();   // Breadth
	case 2 : frontier = new PQFrontier();      // Best
	case 3 : frontier = new PQFrontier(false); // A*
	}

	frontier.add(maze.getStart());
	while (frontier.hasNext()) {
	    
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
