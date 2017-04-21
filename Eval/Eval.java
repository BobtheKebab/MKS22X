public class Eval {

    private double apply (String op, double num1, double num2) {

    }

    private boolean isOp (String op) {

    }

    public static double eval (String str) {

    }

    public static void main (String[] args) {

	Eval dank = new Eval();
	System.out.println(Eval.eval("5 2 +"));
	// 7.0
	System.out.println(Eval.eval("5 2 -"));
	// 3.0
	System.out.println(Eval.eval("5 2 *"));
	// 10.0
	System.out.println(Eval.eval("5.0 2.5 /"));
	// 2.0
	System.out.println(Eval.eval("5 2 %"));
	// 1.0
	
    }

}
