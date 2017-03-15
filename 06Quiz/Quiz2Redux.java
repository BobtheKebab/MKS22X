import java.util.*;

public class Quiz2Redux {

    public static ArrayList<String> combinations (String str) {
	ArrayList<String> ary = new ArrayList<String>();
	combinationsH(ary, "", str, 0);
	Collections.sort(ary);
	return ary;
    }

    private static void combinationsH (ArrayList<String> ary, String str, String strOG, int index) {

	// Adds strings that werent added during recursion, including the original
	if (index >= strOG.length()) {
	    if (!ary.contains(str)) {
		ary.add(str);
		System.out.println(str);
	    }
	    return;
	}
	
	if (!ary.contains(str)) {	   
	    ary.add(str);
	}
	combinationsH(ary, str, strOG, index + 1);
	combinationsH(ary, str + strOG.charAt(index), strOG, index + 1);
    }

    public static void main (String[] args) {

	Quiz2Redux dank = new Quiz2Redux();
	System.out.println(dank.combinations("abcd"));

    }

}
