public class PQFrontier implements Frontier {

    private MyPQ locations = new MyPQ();

    public void add (Location loc) {
	locations.add(loc);
    }

    public Location next () {
	return locations.remove();
    }

    public boolean hasNext () {
	return locations.getSize() > 0;
    }

}
