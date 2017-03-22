import java.util.*;

public class Quick {

    public Quick () {}

    public static int part (int[] ary, int start, int end) {
	
	int dup = start;
	Random rand = new Random();
	int temp = (end - start + 1) + start;
	System.out.println(temp);
	int pivot = rand.nextInt(end - start + 1) + start;
	int pVal = ary[pivot];

	//Move pivot to end of array
	swap(ary, pivot, end);
	pivot = end;
	end--;

        while (start <= end) {
	    if (ary[start] == pVal) {
	        start++;
	    } else if (ary[start] < pVal) {
		swap(ary, start, dup);
		start++;
		dup++;
	    } else {
		swap(ary, start, end);
		end--;
	    }
	}

	// Final swap for pivot, moves to end of duplicates
        swap(ary, pivot, start);
	pivot = start;
	
	return pivot;
    }

    private static void swap (int[] ary, int index1, int index2) {
	int temp = ary[index2];
	ary[index2] = ary[index1];
	ary[index1] = temp;
    }

    public static int quickselect (int[] ary, int k) {

	// Check for invalid input
	if (k < 0 || k >= ary.length) {
	    return -1;
	}

	int num = -1, start = 0, end = ary.length - 1;
	while (num != k) {
	    num = part(ary, start, end);
	    if (num < k) start = num;
	    if (num > k) end = num;
	}

	return ary[k];
    }

    public static void quicksort (int[] ary) {
	qSortH(ary, 0, ary.length - 1);
    }

    private static void qSortH (int[] ary, int start, int end) {
	int pivot = part(ary, start, end);

	//System.out.println(toString(ary));
	//	System.out.println(start);
	//	System.out.println(pivot);
	
	if (start < end) {
	    qSortH(ary, start, pivot);
	    qSortH(ary, pivot + 1, end);
	} else return;
    }

    public static String toString (int[] ary) {
	String str = "";
	for (int num : ary) {
	    str += num + " ";
	}
	return str + "\n";
    }

    public static void main (String[] args) {
	Quick dank = new Quick();
	int[] ary = {10, 5, 20, 25};
	//System.out.println(dank.part(ary, 0, ary.length - 1));
        dank.quicksort(ary);
	System.out.println(toString(ary));
	
    }

}
