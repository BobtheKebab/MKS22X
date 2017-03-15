import java.util.*;

public class Quick {

    public Quick () {}

    public static int part (int[] ary, int start, int end) {
	
	Random rand = new Random();
	int pivot = rand.nextInt(end - start) + start;
	pivot = 0;
	int pVal = ary[pivot];

	//Move pivot to end of array
	swap(ary, pivot, end);
	pivot = end;
	end--;

        while (start < end) {
	    if (ary[start] > pVal) {
		System.out.println(start);
		System.out.println(end);
		System.out.println(toString(ary));
		swap(ary, start, end);
		end--;
		System.out.println(toString(ary));
	    } else {
		start++;
	    }
	}

	System.out.println("FINAL PHASE");
	System.out.println(ary[start]);
	System.out.println(ary[end]);
	if (pVal < ary[start]) {
	    swap(ary, pivot, start);
	    pivot = start;
	}
	System.out.println(toString(ary));
	System.out.println(pVal);
	return pivot;
    }

    private static void swap (int[] ary, int index1, int index2) {
	int temp = ary[index2];
	ary[index2] = ary[index1];
	ary[index1] = temp;
    }

    public static int quickselect(int[] ary, int k) {
	int num = -1;
	while (num != k) {
	    num = part(ary, 0, ary.length - 1);
	}

	return ary[k];
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
	int[] ary = {15, 10, 5, 20, 25};
	System.out.println(dank.part(ary, 0, ary.length - 1));
    }

}
