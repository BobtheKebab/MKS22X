public class MyLinkedList {

    // Node inner class

    private class LNode {

	private int value;
	private LNode next;
	
	public LNode (int val) {
	    value = val;
	    next = null;
	}

	public LNode (int val, LNode nxt) {
	    value = val;
	    next = nxt;
	}

    }

    
    //Start of linkedList class
    
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

    private LNode getNode (int index) {
	int count = 0;
	LNode thisNode = start;
	while (count < index) {
	    thisNode = thisNode.next;
	    count++;
	}
	return thisNode;
    }

    public boolean add (int val) {
	LNode node = new LNode(val);
	if (size == 0) {
	    start = end = node;
	} else {
	    end.next = node;
	    end = node;
	}
	size++;
	return true;
    }

    public void add (int index, int val) {
	if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
	LNode node;
	if (index == 0) {
	    node = new LNode(val, start);
	    start = node;
	} else {
	    LNode thisNode = getNode(index - 1);
	    node = new LNode(val, thisNode.next);
	    thisNode.next = node;

	}
	size++;
    }

    public int remove (int index) {
	if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
	int val = get(index);
	if (index == 0) {
	    start = getNode(1);
	} else if (index == size - 1) {
	    getNode(size - 2).next = null;
	} else {
	    getNode(index - 1).next = getNode(index + 1);
	}
	size--;
	return val;
    }

    public int size () {
	return size;
    }

    public String toString () {
	int count = 0;
	String ans = "[ ";
	LNode thisNode = start;
	while (count < size - 1) {
	    ans += thisNode.value + ", ";
	    thisNode = thisNode.next;
	    count++;
	}
	ans += thisNode.value + " ]";
	return ans;
    }

    public int get (int index) {
	if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
	LNode thisNode = getNode(index);
	return thisNode.value;
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
	System.out.println(dank);
        dank.add(1, 100);
	System.out.println(dank);
	dank.remove(1);
	System.out.println(dank);
	
	int[] ary = {1, 2, 3, 4, 5};
	dank = new MyLinkedList(ary);
	System.out.println(dank);

    }

}
