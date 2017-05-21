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

    public int getRow () {
	return row;
    }

    public int getCol () {
	return col;
    }

    public boolean isAStar () {
	return aStar;
    }
    
    public int getPriority () {
        int ans;
	if (aStar) {
	    ans = Math.abs(dToStart + dToGoal);
	} else {
	    ans = dToGoal;
	}
	return ans;
    }

    public int compareTo (Location other) {
	return this.getPriority() - other.getPriority();
    }

    public String toString () {
	return "[" + row + ", " + col + "]";
    }
    
}
