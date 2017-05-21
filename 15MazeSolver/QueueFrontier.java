import java.util.*;

public class QueueFrontier implements Frontier {

    private ArrayDeque<Location> locations;

    public QueueFrontier () {
	locations = new ArrayDeque<Location>();
    }

    public void add (Location loc) {
	locations.add(loc);
    }

    public Location next () {
	return locations.remove();
    }
	
    public boolean hasNext () {
	return locations.size() > 0;
    }

}
