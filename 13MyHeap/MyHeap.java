import java.util.ArrayList;

public class MyHeap {

    private ArrayList<String> heap = new ArrayList<String>();
    private int constant = 1, size = 0;

    // Initialized as max-heap
    public MyHeap () {
        heap.add("dank");
    }

    // True for max-heap, false for min-heap
    public MyHeap (boolean bool) {
	if (!bool) {
	    constant = -1;
	}
    }

    public void add (String str) {
	size++;
	heap.add(str);
	pushUp(size);
    }

    public String remove () {
	String ans = heap.get(1);
	heap.set(1, heap.get(size));
	heap.remove(size);
	pushDown(1);
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

    private void pushUp (int index) {
	if (size == 1) return;
	int parentIndex = (int) Math.ceil((index - 1) / 2);
	if (compare(index, parentIndex) > 0) {
	    return;
	} else {
	    swap(index, parentIndex);
	    pushUp(parentIndex);
	}
    }

    private void pushDown (int index) {
	
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

	MyHeap dank = new MyHeap();
	dank.add("z");
	dank.add("a");
	System.out.println(dank);

    }

}
