public class ExpressionTree {

    private char op;
    private double value;
    private ExpressionTree left,right;
    private String operations = "+-*/";

    public ExpressionTree (double value) {
	this.value = value;
	op = '~';
    }
    public ExpressionTree (char op, ExpressionTree l, ExpressionTree r) {
	this.op = op;
	left = l;
	right = r;
    }

    public char getOp () {
	return op;
    }
  
    private double getValue () {
	return value;
    }

    private ExpressionTree getLeft () {
	return left;
    }

    private ExpressionTree getRight () {
	return right;
    }
  
    private boolean isOp () {
	return hasChildren();
    }
    private boolean isValue () {
	return !hasChildren();
    }
  
    private boolean hasChildren () {
	return left != null && right != null;
    }


    // Functions to be written

    public double evaluate(){
	if (isValue()) {
	    return getValue();
	} else {
	    double[] ary = { getLeft().evaluate() + getRight().evaluate(),
			     getLeft().evaluate() - getRight().evaluate(), 
			     getLeft().evaluate() * getRight().evaluate(), 
			     getLeft().evaluate() / getRight().evaluate() };
	    return ary[operations.indexOf((String) getOp())];
	}
    }
  
    // The sample tree would be: "( 3 + (2 * 10))"
    public String toString(){
	return "";
    }
  
    // The sample tree would be: "3 2 10 * +"
    public String toStringPostfix(){
	return "";
    }
  
    // The sample tree would be: "+ 3 * 2 10"
  
    public String toStringPrefix(){
	return "";
    }


    public static void main (String[] args) {
    
	ExpressionTree a = new ExpressionTree(4.0);
	ExpressionTree b = new ExpressionTree(2.0);

	ExpressionTree c = new ExpressionTree('+',a,b);
	System.out.println(c);
	System.out.println(c.toStringPostfix());
	System.out.println(c.toStringPrefix());
	System.out.println(c.evaluate());


	ExpressionTree d = new ExpressionTree('*',c,new ExpressionTree(3.5));
	System.out.println(d);
	System.out.println(d.toStringPostfix());
	System.out.println(d.toStringPrefix());
	System.out.println(d.evaluate());

	ExpressionTree ex = new ExpressionTree('-',d,new ExpressionTree(1.0));
	System.out.println(ex);
	System.out.println(ex.toStringPostfix());
	System.out.println(ex.toStringPrefix());
	System.out.println(ex.evaluate());

	ex = new ExpressionTree('+',new ExpressionTree(1.0),ex);
	System.out.println(ex);
	System.out.println(ex.toStringPostfix());
	System.out.println(ex.toStringPrefix());
	System.out.println(ex.evaluate());

	ex = new ExpressionTree('/',ex,new ExpressionTree(2.0));
	System.out.println(ex);
	System.out.println(ex.toStringPostfix());
	System.out.println(ex.toStringPrefix());
	System.out.println(ex.evaluate());
    
    }

}
