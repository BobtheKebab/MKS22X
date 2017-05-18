public class Location {

    private int row, col;
    private int dToStart, dToGoal;
    private Location prev;
    private boolean aStar;

    public Location (int r, int c, Location previous, int distStart, int distGoal, boolean star) {
	row = r;
	col = c;
	prev = previous;
	dToStart = distStart;
	dToGoal = distGoal;
	aStar = star;
    }

    // Write accessors
    
    public int getPriority () {
	return Math.abs(dToStart - dToGoal);
    }

    public int compareTo (Location other) {
	return this.getPriority() - other.getPriority();
    }

    public String toString () {
	return "[" + row + ", " + col + "]";
    }
    
}
