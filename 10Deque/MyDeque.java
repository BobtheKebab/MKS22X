import java.util.*;

public class MyDeque {

    private int size, front, back;
    private String[] list;

    public MyDeque () {
	list = new String[10];
	back = 9;
    }

    private void checkSize () {
	if (size == 0) {
	    throw new NoSuchElementException();
	} else if (size == list.length) {
	    doubleSize();
	}
    }

    private void doubleSize () {
	String[] temp = new String[2 * list.length];
	int index = 0;
	// Adds all elements after and including front
	for (int count = front; count < list.length; index++, count++) {
	    temp[index] = list[count];
	}
	// If back is before front, adds all remaining elements
	if (back != list.length - 1) {
	    for (int count = 0; count <= back; index++, count++) {
		temp[index] = list[count];
	    }
	}
	list = temp;
    }

    private void checkNull (Object obj) {
	if (obj == null) {
	    throw new NullPointerException();
	}
    }

    public void addFirst (String str) {
	checkNull(str);
	front = ((((front - 1) % list.length) + list.length) % list.length);
	list[front] = str;
	size++;
	checkSize();
    }

    public void addLast (String str) {
	checkNull(str);
	back = ((((back + 1) % list.length) + list.length) % list.length);
	list[back] = str;
	size++;
	checkSize();
    }

    public String removeFirst () {
	checkSize();
	String first = list[front];
	front = (front + 1) % list.length;
	return first;
    }

    public String removeLast () {
	checkSize();
	String last = list[back];
	back = (back - 1) % list.length;
	return last;
    }

    public String getFirst () {
	checkSize();
	return list[front];
    }

    public String getLast () {
	checkSize();
	return list[back];
    }
    
    public static void main (String[] args) {
	
	MyDeque dank = new MyDeque();
	for (int count = 0; count < 15; count++) {
	    dank.addFirst("hola");
	}
	dank.addFirst("hello");
	dank.addLast("world");
	//dank.removeFirst();
	//dank.removeLast();
	System.out.println(dank.getFirst());
	System.out.println(dank.getLast());
	
    }

}
