import java.util.*;
import java.io.*;

public class USACO {

    //public int R, C, E, N;
    //private int[][] lake;
    //public static int[][] orders;

    public USACO () {

    }

    public static int silver (String fileName) {

	int R, C, E, N, answer = 0;
	int[][] lake, orders;

	try {

	    // Get all info from input

	    File data = new File(fileName);
	    Scanner skan = new Scanner(data);
	    R = Integer.parseInt(skan.next());
	    C = Integer.parseInt(skan.next());
	    E = Integer.parseInt(skan.next());
	    N = Integer.parseInt(skan.next());
	    lake = new int[R][C];
	    for(int i = 0; i < R; i++){
		for (int count = 0; count < C; count++) {
		    lake[i][count] = Integer.parseInt(skan.next());
		}
	    }
	
	    orders = new int[N][3];
	    for (int count = 0; count < N; count++) {
		for (int num = 0; num < 3; num++) {
		    orders[count][num] = Integer.parseInt(skan.next());
		}
	    }

	    System.out.println(toString(lake));
	    System.out.println(toString(orders));

	    // Run calculations and return output

	} catch (FileNotFoundException e) {
	    System.out.println(e);
	    System.exit(0);
	}

	return answer;
	
    }

    public static String toString (int[][] array) {
	String str = "";
	for (int[] ary : array) {
	    for (int num : ary) {
		if (num < 10) {
		    str += num + "  ";
		} else {
		    str += num + " ";
		}
	    }
	    str += "\n";
	}

	return str;
    }

    public static void main (String[] args) {
	
	USACO dank = new USACO();
	
	System.out.println(USACO.silver("input1.txt"));

    }
}
