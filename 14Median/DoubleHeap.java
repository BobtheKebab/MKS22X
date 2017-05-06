import java.util.ArrayList;

public class DoubleHeap {

    private ArrayList<Double> heap = new ArrayList<Double>();
    private int size = 0;
    private double constant = -1.0;

    // Initialized as max-heap
    public DoubleHeap () {
        heap.add(69.0);
    }

    // True for max-heap, false for min-heap
    public DoubleHeap (boolean bool) {
	if (!bool) {
	    constant = 1.0;
	}
	heap.add(69.0);
    }

    public void add (Double str) {
	size++;
	heap.add(str);
	pushUp();
    }

    public Double remove () {
	Double ans = heap.get(1);
	heap.set(1, heap.remove(size));
	pushDown();
	size--;
	return ans;
    }

    public Double peek () {
        return heap.get(1);
    }

    public String toString () {
        heap.remove(0);
	String str = heap.toString();
	heap.add(0, 69.0);
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

    private double compare (int index1, int index2) {
	Double num1 = heap.get(index1);
	Double num2 = heap.get(index2);
	return num1.compareTo(num2) * constant;
    }

    private void swap (int index1, int index2) {
	Double temp = heap.get(index2);
	heap.set(index2, heap.get(index1));
	heap.set(index1, temp);
    }

    public static void main (String[] args) {

	DoubleHeap dank = new DoubleHeap();
	dank.add(25.0);
	dank.add(15.0);
	dank.add(30.0);
	System.out.println(dank);
	dank.add(2.0);
	System.out.println(dank);
	dank.add(1.0);
	System.out.println(dank);
	dank.remove();
	System.out.println(dank);
	dank.remove();
	System.out.println(dank);

    }

}
