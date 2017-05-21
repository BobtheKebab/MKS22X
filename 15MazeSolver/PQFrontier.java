import java.util.*;

public class PQFrontier implements Frontier {

    private MyPQ locations;

    public PQFrontier (boolean bool) {
	locations = new MyPQ(bool);
    }

    public void add (Location loc) {
	locations.add(loc);
    }

    public Location next () {
	return locations.remove();
    }

}
