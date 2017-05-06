import java.util.ArrayList;

public class MyHeap {

    private ArrayList<String> heap = new ArrayList<String>();
    private int constant = 1, size = 0;
    private boolean isMax;

    // Initialized as max-heap
    public MyHeap () {
	isMax = true;
        heap.add("dank");
    }

    // True for max-heap, false for min-heap
    public MyHeap (boolean bool) {
	isMax = bool;
	if (!isMax) {
	    constant = -1;
	}
	heap.add("dank");
    }

    public void add (String str) {
	size++;
	heap.add(str);
	pushUp();
    }

    public String remove () {
	String ans = heap.get(1);
	heap.set(1, heap.remove(size));
	pushDown();
	size--;
	return ans;
    }

    public String peek () {
        return heap.get(1);
    }

    public String toString () {
        heap.remove(0);
	String str = heap.toString();
	heap.add(0, "dank");
	return str;
    }

    /*
    private void pushUp () {
	int index = size;
	if (isMax) {
	    while (compare(index, index / 2) < 0 && index > 1) {
		swap(index, index / 2);
		index /= 2;
	    }
	} else {
	    while (compare(index, index / 2) > 0 && index > 1) {
		swap(index, index / 2);
		index /= 2;
	    }
	}
    }

    private void pushDown () {
	int index = 1;
	if (isMax) {
	    while (compare(index, index * 2) > 0 && index < size) {
		swap(index, index * 2);
		index *= 2;
	    }
	} else {
	    while (compare(index, index * 2) < 0 && index < size) {
		swap(index, index * 2);
		index *= 2;
	    }
	}
    }
    */

    private void pushUp () {
	for (int index = size; index > 1 && compare(index, index / 2) < 0; index /= 2) {
	    swap(index, index / 2);
	}
    }

    private void pushDown () {
	for (int index = 1; index < size /2 && compare(index, index * 2) > 0; index *= 2) {
	    swap(index, index * 2);
	}
    }

    private int compare (int index1, int index2) {
	String str1 = heap.get(index1);
	String str2 = heap.get(index2);
	return str1.compareTo(str2) * constant;
    }

    private void swap (int index1, int index2) {
	String temp = heap.get(index2);
	heap.set(index2, heap.get(index1));
	heap.set(index1, temp);
    }

    public static void main (String[] args) {

	MyHeap dank = new MyHeap(false);
	dank.add("y");
	dank.add("x");
	dank.add("z");
	System.out.println(dank);
	dank.add("b");
	System.out.println(dank);
	dank.add("a");
	System.out.println(dank);
	dank.remove();
	System.out.println(dank);
	dank.remove();
	System.out.println(dank);

    }

}
