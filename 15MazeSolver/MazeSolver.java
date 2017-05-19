public class MazeSolver {

    private Maze maze;
    private Frontier frontier;
    private final int[][] directions = { {0, -1},   // Left
					 {0, 1},    // Right
					 {1, 0},    // Up
					 {-1, 0} }; // Down

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

    private ArrayList<Location> getAdjacent (int row, int col, boolean aStar) {

	ArrayList<Location> list = new ArrayList<Location>();
	Location loc;

	for (int[] arr : directions) {
	    for (int[] ary : arr) {

		int r = row + arr[0], c = row + arr[1];

		if (maze.get(r, c) == " ") {
		    if (aStar) {
			loc = new Location(r, c);
		    } else {
			loc = new Location(r, c, );
		    }
		}

		list.add(loc);

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
	frontier = new PQFrontier();
	// more stuff
    }

    private void aStarSearch () {
	// idek what this is tbh
    }

    public String toString () {
	return maze;
    }

}
