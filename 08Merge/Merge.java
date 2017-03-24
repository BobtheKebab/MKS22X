public class Merge {

    public Merge () {}

    // Mandatory Tests: random big, random small, same value, sorted, reverse sorted

    private static int[] merge (int[] ary, int[] yar) {
	int[] answer = new int[ary.length + yar.length];
	int ind1 = 0, ind2 = 0;
	boolean bool = true;
	
	while (ind1 < ary.length && ind2 < yar.length) {

	    if (ary[ind1] < yar[ind2]) {
		answer[ind1 + ind2] = ary[ind1];
		ind1++;
	    } else {
		answer[ind1 + ind2] = yar[ind2];
		ind2++;
	    }
	    if (ind1 == yar.length - 1) bool = false;

	}

	if (bool) {
	    while (ind1 < ary.length) {
		answer[ind1 + ind2] = ary[ind1];
		ind1++;
	    }
	} else {
	    while (ind2 < yar.length) {
		answer[ind1 + ind2] = yar[ind2];
		ind2++;
	    }
	}

	return answer;
    }

    private static int[] makeCopy (int[] ary, int start, int end) {
	int answer = new int[end - start];
	for (int count = 0; count < end - start; count++, start++) {
	    answer[count] = ary[start];
	}
	return answer;
    }

    public static void mergesort (int[] ary) {
	int half = (ary.length - 1) / 2;
	int[] left = makeCopy(ary, half);
	int[] right = makeCopy(half + 1, ary.length - 1);
	mergesort(left);
	mergesort(right);
	ary = merge(left, right);
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
	int[] b = {5, 10};
	System.out.println(merge(a, b)[3]);
	
    }
}

