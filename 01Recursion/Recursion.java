public class Recursion {

    public static String name() {
	return "Ashraf,Ahbab";
    }

    public static double sqrt(double num) {
	if (num < 0) {
	    throw new IllegalArgumentException("i cant believe you've done this");
	}
	if (num == 0.0) {
	    return num;
	} else {
	    return sqrtHelper(num, 1.0);
	}
    }

    private static double sqrtHelper(double target, double num) {
	double betterNum = (target / num + num) / 2.0;
	double difference = Math.abs(num - betterNum) / ((num + betterNum) /2);
	if (difference < 0.00000000000001) {
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
