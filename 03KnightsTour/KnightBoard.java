public class KnightBoard {
    
    public int[][] board;
    private String boardState;
    private int numKnights;
    
    public KnightBoard (int rows, int cols) {
	board = new int[rows][cols];
	updateBoardState();
	numKnights = rows * cols;
    }

    public void updateBoardState () {
	boardState = "";
	for (int[] ary : board) {
	    for (int num : ary) {
		if (num < 10) {
		    boardState += " " + num;
		} else {
		    boardState += num;
		}
	    }
	    boardState += "\n";
	}
    }

    public String toString () {
	return boardState;
    }

    // For debugging
    public String toString (int num) {
	updateBoardState();
	return boardState;
    }

    public boolean Solve () {
	return solveH(0, 0, 0);
    }

    private boolean solveH (int row, int col, int level) {
	
	if (level > numKnights) {
	    updateBoardState();
	    return true;
	}

    }

    public static void main (String[] args) {

	KnightBoard dank = new KnightBoard(5, 5);
	System.out.println(dank.toString(0));

    }
}
