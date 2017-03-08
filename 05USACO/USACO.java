import java.util.*;
import java.io.*;

public class USACO {

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

	    // Stomp down the lake

	    for (int[] ary : orders) {
		stomp(lake, ary[0] - 1, ary[1] - 1, ary[2]);
	    }

	    for(int i = 0; i < R; i++){
		for (int count = 0; count < C; count++) {
		    if (E - lake[i][count] > 0) {
			lake[i][count] =  E - lake[i][count];
		    } else {
			lake[i][count] = 0;
		    }
		}
	    }

	    // Calculate the lake's volume (each square is 72 * 72 inches)

	    for (int[] ary : lake) {
		for (int num : ary) {
		    answer += num;
		}
	    }

	    answer *= 72 * 72;
	    
	} catch (FileNotFoundException e) {
	    System.out.println(e);
	    System.exit(0);
	}

	return answer;
	
    }

    // Must give true row and col, not row + 1 or col + 1
    private static void stomp(int[][] ary, int row, int col, int depth) {

	// Find highest elevation
	
	int highest = 0;
	for (int count = 0; count < 3; count++) {
	    for (int num = 0; num < 3; num++) {
		int i = ary[row + count][col + num];
		if (i > highest) highest = i;
	    }
	}

	// Commense stomping
	
	highest -= depth;
	for (int count = 0; count < 3; count++) {
	    for (int num = 0; num < 3; num++) {
		if (ary[row + count][col + num] > highest) {
		    ary[row + count][col + num] = highest;
		    //System.out.println("changed");
		}
	    }
	}
	
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
