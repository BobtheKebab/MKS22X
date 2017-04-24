import java.util.*;

public class MyDeque {

    private int size, front, back;
    private LinkedList<String> list;

    public MyDeque () {
	back = -1;
	list = new LinkedList<String>();
    }

    private void checkSize () {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
    }

    private void checkNull (Object obj) {
	if (obj == null) {
	    throw new NullPointerException();
	}
    }

    public void addFirst (String str) {
	checkNull(str);
	list.add(front, str);
        back++;
	size++;
	//System.out.println("" + front + " " +  back + " " +  size);
    }

    public void addLast (String str) {
	checkNull(str);
	list.add(str);
	back++;
	size++;
	//System.out.println("" + front + " " + back + " " +  size);
    }

    public String removeFirst () {
	checkSize();
	String first = getFirst();
	return first;
    }

    public String removeLast () {
	checkSize();
	String last = getLast();
	return last;
    }

    public String getFirst () {
	checkSize();
	//System.out.println(front);
	return list.get(front);
    }

    public String getLast () {
	checkSize();
	//System.out.println(back);
	return list.get(back);
    }

    private void doubleSize () {

    }

    public static void main (String[] args) {
	
	MyDeque dank = new MyDeque();
	dank.addFirst("hello");
	dank.addFirst("world");
	System.out.println(dank.getFirst());
	System.out.println(dank.getLast());
	
    }

}
