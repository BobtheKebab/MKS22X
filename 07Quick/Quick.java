import java.util.*;

public class Quick {

    public Quick () {}

    public static int part (int[] ary, int start, int end) {
	
	int dup = start;
	Random rand = new Random();
	int pivot = rand.nextInt(end - start) + start;
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
	if (start < end) {
	    int pivot = part(ary, start, end);
	    qSortH(ary, start, pivot - 1);
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
	int[] ary = {15, 10, 0, 0, 5, 10, 10, 10, 10, 10, 10, 10, 10, 5, 5, 5, 15, 25};
	int[] dk = {};
	//System.out.println(dank.part(ary, 0, ary.length - 1));
        dank.quicksort(dk);
	System.out.println(toString(dk));
	
    }

}
