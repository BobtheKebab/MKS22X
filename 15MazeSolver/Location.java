public class Location {

    int row, col, dToStart;
    Location prev;

    public Location (int r, int c, int dist, Location loc) {
	row = r;
	col = c;
	dToStart = dist;
	prev = loc;
    }
    
}
