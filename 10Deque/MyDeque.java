import java.util.LinkedList;

public class MyDeque {

    private int size, front, back;
    private LinkedList<String> list;

    public MyDeque () {
	back = -1;
	list = new LinkedList<String>();
    }

    public void addFirst (String str) {
	list.add(front, str);
        back++;
	size++;
	//System.out.println("" + front + " " +  back + " " +  size);
    }

    public void addLast (String str) {
	list.add(str);
	back++;
	size++;
	//System.out.println("" + front + " " + back + " " +  size);
    }

    public String removeFirst () {
	String first = getFirst();
	return first;
    }

    public String removeLast () {
	String last = getLast();
	return last;
    }

    public String getFirst () {
	//System.out.println(front);
	return list.get(front);
    }

    public String getLast () {
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
