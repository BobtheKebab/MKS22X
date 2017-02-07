public class Recursion {

    public static String name() {
	return "Ashraf,Ahbab";
    }

    public static double sqrt(double num) {
	return sqrtHelper(num, num);
    }

    private static double sqrtHelper(double target, double num) {
	double betterNum = (target / num + num) / 2;
	double percentDif = (num - betterNum) / (num + betterNum) / 2;
	if (percentDif < 0000000000.1) {
	    return num;
	} else {
	    return sqrtHelper(target, betterNum);
	}
    }

    public static void main (String[] args) {

	for (int count = 0; count < 11; count++) {
	    double randNum = Math.random() * 100000 + 1;
	    System.out.println(sqrt(randNum));
	    System.out.println(Math.sqrt(randNum));
	    System.out.println("--------------------");
	}
	
    }
    
}
