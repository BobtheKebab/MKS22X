import java.util.ArrayList;

public class MyPQ {

    private ArrayList<Location> heap = new ArrayList<Location>();
    private int constant = 1, size = 0;

    // Initialized as max-heap
    public MyPQ () {
        heap.add(null);
    }

    // True for max-heap, false for min-heap
    public MyPQ (boolean bool) {
	if (!bool) {
	    constant = -1;
	}
	heap.add(null);
    }

    public void add (Location loc) {
	size++;
	heap.add(loc);
	pushUp();
    }

    public Location remove () {
	Location ans = heap.get(1);
	heap.set(1, heap.remove(size));
	pushDown();
	size--;
	return ans;
    }

    public Location peek () {
        return heap.get(1);
    }

    public String toString () {
        heap.remove(0);
	String str = heap.toString();
	heap.add(0, null);
	return str;
    }

    private void pushUp () {
	for (int index = size; index > 1; index /= 2) {
	    if (compare(index, index / 2) < 0) {
		swap(index, index / 2);
	    } else if (compare(index, index / 2 + 1) < 0) {
		swap(index, index / 2 + 1);
	    }
	}
    }

    private void pushDown () {
	for (int index = 1; index < size / 2; index *= 2) {
	    if (compare(index, index * 2) > 0) {
		swap(index, index * 2);
	    } else if (compare(index, index * 2 + 1) > 0) {
		swap(index, index * 2 + 1);
	    }
	}
    }

    private int compare (int index1, int index2) {
	Location loc1 = heap.get(index1);
	Location loc2 = heap.get(index2);
	return loc1.compareTo(loc2) * constant;
    }

    private void swap (int index1, int index2) {
	Location temp = heap.get(index2);
	heap.set(index2, heap.get(index1));
	heap.set(index1, temp);
    }

    public static void main (String[] args) {

	MyPQ dank = new MyPQ();

    }

}
