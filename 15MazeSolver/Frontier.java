import java.util.*;

public interface Frontier {

    public void add (Location loc);

    public Location next ();
    
}

// Depth First
public class StackFrontier implements Frontier {

    private Stack<Location> locations;

    public void add (Location loc) {
	locations.push(loc);
    }

    public Location next () {
	// remove top and return it
	return locations.pop();
    }

}

// Breadth First
public class QueueFrontier {

    private ArrayDeque<Location> locations;

    public void add (Location loc) {
	locations.add(loc);
    }

    public Location next () {
	// remove top and return it
	return locations.remove();
    }

}

// Best First
public class PQFrontier {

    private MyPQ locations;

    public void add (Location loc) {

    }

    public Location next () {
	return locations.remove();
    }

}
