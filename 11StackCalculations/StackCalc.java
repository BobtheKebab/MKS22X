import java.util.ArrayDeque;

public class StackCalc {

    static String operations = "+-*/%";
    
    private static double apply (String op, double a, double b) {
        double[] ary = { b + a, b - a, b * a, b / a, b % a };
	return ary[operations.indexOf(op)];
    }

    private static boolean isOp (String op) {
	return operations.contains(op);
    }

    public static double eval (String str) {
	int answer;
	String[] ary = str.split(" ");
	ArrayDeque<Double> dq = new ArrayDeque<Double>();
	for (String element : ary) {
	    if (isOp(element)) {
		dq.push(apply(element, dq.pop(), dq.pop()));
	    } else {
		dq.push(Double.parseDouble(element));
	    }
	}
	return dq.pop();
    }

    public static void main (String[] args) {

	StackCalc dank = new StackCalc();

	System.out.println(StackCalc.eval("5 2 +"));
	// 7.0
	System.out.println(StackCalc.eval("5 2 -"));
	// 3.0
	System.out.println(StackCalc.eval("5 2 *"));
	// 10.0
	System.out.println(StackCalc.eval("5.0 2.5 /"));
	// 2.0
	System.out.println(StackCalc.eval("5 2 %"));
	// 1.0
	System.out.println(StackCalc.eval("2 500 10 10 * - *"));
	// 800.0
	
    }

}
