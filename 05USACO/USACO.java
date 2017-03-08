import java.util.*;
import java.io.*;

public class USACO {

    public int R, C, E, N;
    private int[][] lake;
    public static int[][] orders;

    public USACO (String fileName) {
	try {
	    File data = new File(fileName);
	    getInfo(data);
	} catch (Exception e) {
	    System.out.println(e);
	    System.exit(0);
	}
    }

    private void getInfo (File data) throws FileNotFoundException {
	
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
	//System.out.println(toString());
	
	orders = new int[N][3];
	for (int count = 0; count < N; count++) {
	    for (int num = 0; num < 3; num++) {
		orders[count][num] = Integer.parseInt(skan.next());
	    }
	}
	//System.out.println(USACO.orders[0]);
    }

    public String toString () {
	String str = "";
	for (int[] ary : lake) {
	    for (int num : ary) {
		str += num + " ";
	    }
	    str += "\n";
	}

	return str;
    }

    public static void main (String[] args) {
	
	USACO dank = new USACO("input1.txt");
	
	System.out.println(USACO.orders[1][2]);

    }
}
