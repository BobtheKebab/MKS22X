import java.util.*;

public class MyLinkedList implements Iterable<Integer> {

    // Node inner class

    private class LNode {

	private int value;
	private LNode prev, next;
	
	public LNode (int val) {
	    value = val;
	    next = prev = null;
	}

	public LNode (int val, LNode prv, LNode nxt) {
	    value = val;
	    prev = prv;
	    next = nxt;
	}

	public String toString () {
	    String prv, val, nxt;
	    if (prev == null) {
		prv = "null";
	    } else {
		prv = "" + prev.value;
	    }
	    if (next == null) {
		nxt = "null";
	    } else {
		nxt = "" + next.value;
	    }
	    return "(" + prv + ")" + " " + value + " " + "(" + nxt + ")";
	}

    }

    // Iterator inner class

    private class MyIterator implements Iterator<Integer> {

	private MyLinkedList list;

	public MyIterator (MyLinkedList lyst) {
	    list = lyst;
	}

	public boolean hasNext () {
	    return list.size > 0;
	}

	public Integer next () {
	    if (hasNext()) {
		int temp = list.remove(0);
		return temp;
	    } else {
		throw new NoSuchElementException();
	    }
	}

	public void remove () {
	    throw new UnsupportedOperationException();
	}
	
    }
    
    // Start of MyLinkedList class
    
    private LNode start, end;
    private int size;

    public MyLinkedList () {
	start = end = null;
	size = 0;
    }

    public MyLinkedList (int[] ary) {
        start = end = null;
	size = 0;
	for (int num : ary) {
	    add(num);
	}
    }

    public Iterator<Integer> iterator () {
	return new MyIterator(this);
    }

    private LNode getNode (int index) {
	int count = 0;
	LNode thisNode = start;
	while (count < index) {
	    thisNode = thisNode.next;
	    count++;
	}
	return thisNode;
    }
    
    // Adds to end
    public boolean add (int val) {
	LNode node = new LNode(val);
	if (size == 0) {
	    start = end = node;
	} else {
	    end.next = node;
	    node.prev = end;
	    end = node;
	}
	size++;
	return true;
    }

    // Adds to anywhere
    public void add (int index, int val) {
	if (index < 0 || index >= size + 1) throw new IndexOutOfBoundsException();
	LNode node;
	if (index == 0) {
	    node = new LNode(val, null, start);
	    start.prev = node;
	    start = node;
	} else if (index == size) {
	    node = new LNode(val, end, null);
	    end.next = node;
	    end = node;
	} else {
	    node = new LNode(val, getNode(index - 1), getNode(index));
	    node.prev.next = node;
	    node.next.prev = node;
	}
	size++;
    }

    public int remove (int index) {
	if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
	int val = get(index);
	if (size == 1) {
	    start = end = null;
	} else if (index == 0) {
	    getNode(1).prev = null;
	    start = getNode(1);
	} else if (index == size - 1) {
	    getNode(size - 2).next = null;
	    end = getNode(size - 2);
	} else {
	    getNode(index - 1).next = getNode(index + 1);
	    getNode(index + 1).prev = getNode(index - 1);
	}
	size--;
	return val;
    }

    public int size () {
	return size;
    }

    public String toString () {
	if (size == 0) {
	    return "[]";
	} else {
	    String ans = "[ ";
	    LNode thisNode = start;
	    for (int count = 0; count < size - 1; count++) {
		ans += thisNode.value + ", ";
		thisNode = thisNode.next;
	    }
	    ans += thisNode.value + " ]";
	    return ans;
	}
    }

    // Shows prev and next values
    public String toStringDebug () {
	String ans = "[ ";
	LNode thisNode = start;
        for (int count = 0; count < size - 1; count++) {
	    ans += thisNode.toString() + ", ";
	    thisNode = thisNode.next;
	}
	ans += thisNode.toString() + " ]";
	return ans;
    }

    public int get (int index) {
	if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
	return getNode(index).value;
    }

    public int set (int index, int newVal) {
	if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
	LNode thisNode = getNode(index);
	int ans = thisNode.value;
	thisNode.value = newVal;
	return ans;
    }

    public int indexOf (int val) {
	int count = 0;
	LNode thisNode = start;
	while (count < size) {
	    if (thisNode.value == val) return count;
	    thisNode = thisNode.next;
	    count++;
	}
	return -1;
    }

    public static void main (String[] args ) {
	
	MyLinkedList dank = new MyLinkedList();
	
        dank.add(10);
	dank.add(5);
	dank.add(11);
	dank.add(1);
	dank.remove(3);
	//System.out.println(dank);
	dank.add(3, 50);
	/*
	System.out.println(dank);
        dank.add(1, 100);
	System.out.println(dank);
	dank.remove(1);
	System.out.println(dank);
	*/

	//int[] ary = {1, 2, 3, 4, 5};
	//dank = new MyLinkedList(ary);
	System.out.println(dank.remove(0));
	System.out.println(dank.toStringDebug());

	for (int num : dank) {
	    System.out.println(num);
	}

    }

}
