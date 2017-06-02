import java.util.Stack;

public class StackFrontier implements Frontier {

    private Stack<Location> locations = new Stack<Location>();

    public void add (Location loc) {
	locations.push(loc);
    }

    public Location next () {
	return locations.pop();
    }

    public boolean hasNext () {
	return locations.size() > 0;
    }

}
