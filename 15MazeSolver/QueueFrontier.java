import java.util.ArrayDeque;

public class QueueFrontier implements Frontier {

    private ArrayDeque<Location> locations = new ArrayDeque<Location>();

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
