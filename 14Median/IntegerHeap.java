import java.util.ArrayList;

public class IntegerHeap {

    private ArrayList<Integer> heap = new ArrayList<Integer>();
    private int size = 0;
    private int constant = -1;

    // Initialized as max-heap
    public IntegerHeap () {
        heap.add(69);
    }

    // True for max-heap, false for min-heap
    public IntegerHeap (boolean bool) {
	if (!bool) {
	    constant = 1;
	}
	heap.add(69);
    }

    public void add (Integer str) {
	size++;
	heap.add(str);
	pushUp();
    }

    public Integer remove () {
	Integer ans = heap.get(1);
	heap.set(1, heap.remove(size));
	pushDown();
	size--;
	return ans;
    }

    public Integer peek () {
	if (size == 0) {
	    return 0;
	} else {
	    return heap.get(1);
	}
    }

    public String toString () {
        heap.remove(0);
	String str = heap.toString();
	heap.add(0, 69);
	return str;
    }

    public int getSize () {
	return size;
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
	Integer num1 = heap.get(index1);
	Integer num2 = heap.get(index2);
	return num1.compareTo(num2) * constant;
    }

    private void swap (int index1, int index2) {
	Integer temp = heap.get(index2);
	heap.set(index2, heap.get(index1));
	heap.set(index1, temp);
    }

    public static void main (String[] args) {

	IntegerHeap dank = new IntegerHeap();
	dank.add(25);
	dank.add(15);
	dank.add(30);
	System.out.println(dank);
	dank.add(2);
	System.out.println(dank);
	dank.add(1);
	System.out.println(dank);
	dank.remove();
	System.out.println(dank);
	dank.remove();
	System.out.println(dank);

    }

}
