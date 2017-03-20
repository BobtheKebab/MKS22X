import java.util.*;

public class Quick {

    public Quick () {}

    public static int part (int[] ary, int start, int end) {
	
	Random rand = new Random();
	int pivot = rand.nextInt(end - start) + start;
	int pVal = ary[pivot];

	//Move pivot to end of array
	swap(ary, pivot, end);
	pivot = end;
	end--;

        while (start < end) {
	    if (ary[start] > pVal) {
		swap(ary, start, end);
		end--;
	    } else if (ary[start] == pVal) {
		swap(ary, start + 1, 
	    }
	}

	// Chooses pivot's final index
	System.out.println(start);
	if (pVal <= ary[start]) {
	    swap(ary, pivot, start);
	    pivot = start;
	} else {
	    swap(ary, pivot, start + 1);
	    pivot = start + 1;
	}
	
	System.out.println(toString(ary));
	System.out.println(ary[pivot]);
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
	if (start < end) {
	    part(ary, start, pivot - 1);
	    part(ary, pivot + 1, start);
	}
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
	int[] ary = {5, 5, 5, 10, 5, 20, 25};
	System.out.println(dank.part(ary, 0, ary.length - 1));
	//System.out.println(dank.quick(ary, 4));
    }

}
