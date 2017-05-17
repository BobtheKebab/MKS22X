import java.util.*;

public interface Frontier {

    public void add (Location loc);

    public Location next ();
    
}

// Depth First
public class StackFrontier implements Frontier {

    private Stack<Location> locations;

    public void add (Location loc) {

    }

    public Location next () {
	// remove top and return it
    }

}

// Breadth First
public class QueueFrontier {

    private Queue<Location> locations;

    public void add (Location loc) {

    }

    public Location next () {
	// remove top and return it
    }

}

// Best First
public class PQFrontier {

    private MyPQ locations;

    public void add (Location loc) {

    }

    public Location next () {
	
    }

}
