public class KnightBoard {
    
    public int[][] board;
    private String boardState;
    private int numKnights;
    private int[][] moves = { {1, 2} , 
			      {-2, -1},
			      {-2, 1}, 
			      {2, 1}, 
			      {2, -1},
			      {-1, 2},
			      {-1, -2},
			      {1, -2} };
    
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

    // For testing
    public String toStringRun () {
        solve();
	String size = board.length + "x" + board[0].length;
	return size + "\n" + boardState;
    }

    public void reset () {
        board = new int[board.length][board[0].length];
    }

    public void solve () {
	if (numKnights == 1) {
	    boardState = "1";
	}  else { 
	    if (solveH(0, 0, 1)) {
		System.out.println("SOLVED");
		updateBoardState();
		reset();
	    } else {
		System.out.println("NO SOLUTION");
		reset();
	    }
	}
    }

    private boolean solveH (int row, int col, int level) {
	
	if (level > numKnights) {
	    return true;
	}

	if (board[row][col] == 0) {
	    board[row][col] = level;
	    for (int[] ary : moves) {
		int newRow = row + ary[0];
		int newCol = col + ary[1];
		if (isInBounds(newRow, newCol) && solveH(newRow, newCol, level + 1)) {
		    return true;
		}
	    }

	    board[row][col] = 0;
	}

	return false;		

    }

    private boolean isInBounds (int row, int col) {
	return (row >= 0 && col >= 0 && row < board.length && col < board[0].length);
    }

    public static void main (String[] args) {

	int tick = 0;
	if (tick == 1) {
	    int limit = 7;
	    for (int count = 1; count < limit + 1; count++) {
		KnightBoard board = new KnightBoard(count, count);
		System.out.println(board.toStringRun());
	    }
	}

	int tock = 1;
	if (tock == 1) {
	    KnightBoard board = new KnightBoard(4, 6);
	    System.out.println(board.toStringRun());
	}

    }
    
}
