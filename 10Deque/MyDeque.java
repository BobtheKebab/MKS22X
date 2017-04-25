import java.util.*;

public class MyDeque {

    private int size, front, back;
    private String[] list;

    public MyDeque () {
	list = new String[10];
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
	// Fill in all elements after and including the front
	for (int count = front; count < list.length; index++, count++) {
	    temp[index] = list[count];
	}
	// If the back is before front, it adds the rest of the elements
	if (back != list.length) {
	    for (int count = 0; count <= back; index++, count++) {
		temp[index] = list[count];
	    }
	}
    }

    private void checkNull (Object obj) {
	if (obj == null) {
	    throw new NullPointerException();
	}
    }

    public void addFirst (String str) {
	checkNull(str);
	front--;
	
	list[front % list.length] = str;
	System.out.println("k");
	size++;
	checkSize();
	//System.out.println("" + front + " " +  back + " " +  size);
    }

    public void addLast (String str) {
	checkNull(str);
	back++;
	list[back % list.length] = str;
	size++;
	checkSize();
	//System.out.println("" + front + " " + back + " " +  size);
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
	//System.out.println(front);
	return list[front];
    }

    public String getLast () {
	checkSize();
	//System.out.println(back);
	return list[back];
    }
    
    public static void main (String[] args) {
	
	MyDeque dank = new MyDeque();
	dank.addFirst("hello");
	System.out.println("added hello");
	dank.addFirst("world");
	System.out.println(dank.getFirst());
	System.out.println(dank.getLast());
	
    }

}
