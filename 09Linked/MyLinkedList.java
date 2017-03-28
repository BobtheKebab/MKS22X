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

    public boolean add (int num) {
	LNode node = new LNode(num);
	if (size == 0) {
	    start = end = node;
	} else {
	    end.next = node;
	    end = node;
	}
	size++;
	return true;
    }

    public String toString () {
	int count = 0;
	String ans = "";
	LNode thisNode = start;
	while (count < size) {
	    ans += thisNode.value + " ";
	    thisNode = thisNode.next;
	    count++;
	}
	return ans;
    }

    public static void main (String[] args ) {
	
	MyLinkedList dank = new MyLinkedList();
        dank.add(10);
	dank.add(5);
	System.out.println(dank);

    }

}
