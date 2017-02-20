public class KnightBoard {
    
    public int[][] board;
    private String boardState;
    private int numKnights;
    private int[][] moves = { {-2, 1}, // up 2 right 1
			      {-2, -1}, 
			      {2, 1}, 
			      {2, -1}, // down 2 left 1 
			      {-1, 2},
			      {-1, -2},
			      {1, 2}, 
			      {-1, -2} };
    
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
		    boardState += "  " + num;
		} else {
		    boardState += " " + num;
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
	return boardState + numKnights;
    }	

    public boolean solve () {
	return solveH(0, 0, 1);
    }

    private boolean solveH (int row, int col, int level) {
	
	if (level > numKnights) {
	    updateBoardState();
	    return true;
	}

	if (board[row][col] <= 0) {
	    for (int[] ary : moves) {
		board[row][col] = level;
		int newRow = row + ary[0];
		int newCol = col + ary[1];
		if (isInBounds(newRow, newCol)) {
		    if (solveH(newRow, newCol, level + 1)) {
			return true;
		    }
		}
		board[row][col] = 0;
	    }
	}
	
	return false;		

    }

    private boolean isInBounds (int row, int col) {
	return (row >= 0 && col >= 0 && row < board.length && col < board[0].length);
    }

    public static void main (String[] args) {

	KnightBoard dank = new KnightBoard(5, 5);
	dank.solve();
	System.out.println(dank.toString(0));

    }
}
