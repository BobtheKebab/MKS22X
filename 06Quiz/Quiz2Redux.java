import java.util.*;

public class Quiz2Redux {

    public static ArrayList<String> combinations (String str) {
	ArrayList<String> ary = new ArrayList<String>();
	combinationsH(ary, "", str, 0);
	return ary;
    }

    private static void combinationsH (ArrayList<String> ary, String str, String strOG, int index) {
	
	//System.out.println(str);
	//System.out.println(ary);
	//System.out.println(index);

	if (ary.contains(str) || index >= strOG.length()) {
	    ary.add(str);
	    return;
	}

	//System.out.println("Passed check");

	ary.add(str);
	combinationsH(ary, str, strOG, index + 1);
	System.out.println("A");
	System.out.println(ary);
	combinationsH(ary, str + strOG.charAt(index), strOG, index + 1);
	System.out.println("B");
    }

    public static void main (String[] args) {

	Quiz2Redux dank = new Quiz2Redux();
	System.out.println(dank.combinations("abc"));

    }

}
