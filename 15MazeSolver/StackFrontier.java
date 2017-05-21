import java.util.*;

public class StackFrontier implements Frontier {

    private Stack<Location> locations;

    public void add (Location loc) {
	locations.push(loc);
    }

    public Location next () {
	return locations.pop();
    }

}