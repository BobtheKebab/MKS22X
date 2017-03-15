import java.util.*;

public class Part {

    public Part () {}

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
	    } else {
		start++;
	    }
	}

	swap(ary, pivot, start + 1);
	pivot = end;
	System.out.println(toString(ary));
	System.out.println(pVal);
	return pivot;
    }

    private static void swap (int[] ary, int index1, int index2) {
	int temp = ary[index2];
	ary[index2] = ary[index1];
	ary[index1] = temp;
    }

    public static String toString (int[] ary) {
	String str = "";
	for (int num : ary) {
	    str += num + " ";
	}
	return str;
    }

    public static void main (String[] args) {
	Part dank = new Part();
	int[] ary = {15, 10, 5, 20, 25};
	System.out.println(dank.part(ary, 0, ary.length - 1));
    }

}
