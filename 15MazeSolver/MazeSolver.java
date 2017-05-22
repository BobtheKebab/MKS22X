import java.util.*;

public class MazeSolver {

    private Maze maze;
    private Frontier frontier;
    private boolean animate;
    private final int[][] directions = { {0, -1},   // Left
					 {0, 1},    // Right
					 {1, 0},    // Up
					 {-1, 0} }; // Down
    
    public MazeSolver (String fileName) {
	this(fileName, false);
    }

    public MazeSolver (String fileName, boolean ani) {
	maze = new Maze(fileName);
	animate = ani;
    }

    public void solve () {
	solve(1);
    }

    public void solve (int style) {

	if (style == 0) {
	    frontier = new StackFrontier();
	} else if (style == 1) {
	    frontier = new QueueFrontier();
	} else if (style == 2) {
	    frontier = new PQFrontier();
	} else if (style == 3) {
	    frontier = new PQFrontier();
	    maze.getStart().setAStar(true);
	}

	frontier.add(maze.getStart());
	
	while (frontier.hasNext()) {

	    Location loc = frontier.next();
	    maze.set(loc.getRow(), loc.getCol(), '.');
	    
	    if (getDist(loc, maze.getEnd()) == 0) {
		maze.set(loc.getRow(), loc.getCol(), 'E');
		traceBack(loc);
		System.out.println(this);
		return;
	    }
	    
	    ArrayList<Location> adjLocations = getAdjacent(loc);
	    for (Location element : adjLocations) {
		maze.set(element.getRow(), element.getCol(), '?');
		frontier.add(element);
	    }
	    
	    System.out.println(this.toString());
	    
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

    private void traceBack (Location loc) {
	while (loc.getPrev() != maze.getStart()) {
	    maze.set(loc.getPrev().getRow(), loc.getPrev().getCol(), '@');
	    loc = loc.getPrev();
	}
	maze.set(loc.getPrev().getRow(), loc.getPrev().getCol(), 'S');
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
	if (animate) {
	    return maze.toString(50);
	} else {
	    return maze.toString();
	}
    }

    public static void main (String[] args) {

	MazeSolver dank = new MazeSolver(args[0], true);

	if (args.length != 2) {
	    dank.solve();
	} else {
	    dank.solve(Integer.parseInt(args[1]));
	}
	
    }

}
