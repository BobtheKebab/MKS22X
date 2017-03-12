import java.util.*;

public class Quiz2Redux {

    public static ArrayList<String> combinations (String str) {
	ArrayList<String> ary = new ArrayList<String>();
	combinationsH(ary, "", str, 0);
	return ary;
    }

    private static void combinationsH (ArrayList<String> ary, String str, String strOG, int index) {
	
	if (ary.indexOf(str) != -1) {
	    return;
	}

	ary.add(str);
	//System.out.println(index);
	System.out.println(ary);
	index++;
	combinationsH(ary, str, strOG, index);
	combinationsH(ary, str + strOG.charAt(index), strOG, index);

    }

    public static void main (String[] args) {

	Quiz2Redux dank = new Quiz2Redux();
	System.out.println(dank.combinations("abc"));

    }

}
