public class Merge {

    public Merge () {}

    // Mandatory Tests: random big, random small, same value, sorted, reverse sorted

    private static int[] merge (int[] dest, int[] ary, int[] yar) {
	//dest = new int[ary.length + yar.length];
	int ind1 = 0, ind2 = 0;
	boolean bool = true;
	    
	while (ind1 < ary.length && ind2 < yar.length) {

	    if (ary[ind1] < yar[ind2]) {
		dest[ind1 + ind2] = ary[ind1];
		ind1++;
	    } else {
		dest[ind1 + ind2] = yar[ind2];
		ind2++;
	    }
	    if (ind1 == ary.length) bool = false;
	}

	if (bool) {
	    while (ind1 < ary.length) {
		dest[ind1 + ind2] = ary[ind1];
		ind1++;
	    }
	} else {
	    while (ind2 < yar.length) {
		dest[ind1 + ind2] = yar[ind2];
		ind2++;
	    }
	}

	//System.out.println(toString(dest));
	return dest;
    }

    private static int[] makeCopy (int[] ary, int start, int end) {
	int[] answer = new int[end - start];
	for (int count = 0; count < answer.length; count++, start++) {
	    answer[count] = ary[start];
	}
	return answer;
    }

    public static void mergesort (int[] ary) {
	
	if (ary.length == 1) {
	    return;
	}
	
	int half = ary.length / 2;
	int[] left = makeCopy(ary, 0, half);
	//System.out.println(toString(left));
	int[] right = makeCopy(ary, half, ary.length);
	//System.out.println(toString(right));
	mergesort(left);
	mergesort(right);
	ary = merge(ary, left, right);
	//System.out.println(toString(ary));
	return;
    }

    public static String toString (int[] ary) {
	String str = "";
	for (int num : ary) {
	    str += num + " ";
	}
	return str + "\n";
    }

    public static void main (String[] args) {

	Merge dank = new Merge();
	int[] a = {1, 7};
	int[] b = {5, 10, 2, 8};
	//int[] d = merge(d, a, b);
	//System.out.println(toString(d));

	int[] c = {13, 5, 11, 6, 9, 10, 11, 9};
	mergesort(c);
	System.out.println(toString(c));
    }
}

