public class RunningMedian {

    private IntegerHeap underMed, overMed;
    private double median = 0.0;

    public RunningMedian () {
	underMed = new IntegerHeap();
	overMed = new IntegerHeap(false);
    }

    public void add (int num) {
	if (num > median) {
	    overMed.add(num);
	} else {
	    underMed.add(num);
	}
	rebalance();
        setRunningMedian();
    }
    
    public double getMedian () {
	return median;
    }

    public String toString () {
	return underMed.toString() + " " + overMed.toString();
    }

    private void setRunningMedian () {
	double num1 = (double) underMed.peek(), num2 = (double) overMed.peek();
	int s1 = underMed.getSize(), s2 = overMed.getSize();
	if (s1 + s2 == 1) {
	    median = num1 + num2;
	} else if (s2 > s1) {
	    median = num2;
	} else if (s1 > s2) {
	    median = num1;
	} else {
	    median = ( num1 + num2 ) / 2;
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

	RunningMedian dank = new RunningMedian();
	dank.add(1);
	dank.add(2);
	dank.add(1);
	dank.add(2);
	dank.add(60);
	dank.add(100);
	dank.add(1000);
	dank.add(1000);
	System.out.println(dank);
	System.out.println(dank.getMedian());
	
    }
    
}
