import java.util.*;

public class QueueFrontier implements Frontier {

    private ArrayDeque<Location> locations;

    public void add (Location loc) {
	locations.add(loc);
    }

    public Location next () {
	return locations.remove();
    }

}