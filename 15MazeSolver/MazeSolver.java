public class MazeSolver {

    private Maze maze;
    private Frontier frontier;

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

    public String toString () {
	return maze;
    }

}
