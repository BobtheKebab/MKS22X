public class Median {

    private DoubleHeap underMed, overMed;
    private double median = 0.0;

    public Median () {
	underMed = new DoubleHeap();
	overMed = new DoubleHeap(false);
    }

    public void add (double num) {
	if (num > median) {
	    overMed.add(num);
	} else {
	    underMed.add(num);
	}
	rebalance();
        setMedian();
    }
    
    public double getMedian () {
	return median;
    }

    public String toString () {
	return underMed.toString() + " " + overMed.toString();
    }

    private void setMedian () {
	int s1 = underMed.getSize(), s2 = overMed.getSize();
	if (s1 + s2 == 1) {
	    median = underMed.peek() + overMed.peek();
	} else if (s2 > s1) {
	    median = overMed.peek();
	} else if (s1 > s2) {
	    median = underMed.peek();
	} else {
	    median = ( underMed.peek() + overMed.peek() ) / 2;
	}
    }
    
    private void rebalance () {
	int s1 = underMed.getSize(), s2 = overMed.getSize();
	if (s2 > s1 + 1) {
	    shiftOver(true);
	} else if (s1 > s2 + 1) {
	    shiftOver(false);
	}
    }

    // True to shift high to low, false for vice versa
    private void shiftOver (boolean bool) {
	if (bool) {
	    underMed.add(overMed.remove());
	} else {
	    overMed.add(underMed.remove());
	}
    }

    public static void main (String[] args) {

	Median dank = new Median();
	dank.add(50);
	dank.add(40);
	dank.add(40);
	dank.add(50);
	dank.add(60);
	dank.add(100);
	System.out.println(dank);
	System.out.println(dank.getMedian());
	
    }
    
}
