public class QueenBoard {

    private int[][] board;
    private int solutionCount;
    private String boardState;

    public QueenBoard (int size) {
	board = new int[size][size];
	updateBoardState();
    }

    private void addQueen (int row, int col) {
	
	for (int count = 0; count < board.length; count++) {
	    board[count][col] += 1;
	    board[row][count] += 1;
	}
	
	for (int count = row, num = col; count > -1 && num > -1; count--, num--) {
	    board[count][num] += 1;
	}
	for (int count = row, num = col; count < board.length && num < board.length; count++, num++) {
	    board[count][num] += 1;
	}

	for (int count = row, num = col; count < board.length && num > -1; count++, num--) {
	    board[count][num] += 1;
	}
	for (int count = row, num = col; count > -1 && num < board.length; count--, num++) {
	    board[count][num] += 1;
	}
	
	board[row][col] = -1;
    }

    private void removeQueen (int row, int col) {
	
	for (int count = 0; count < board.length; count++) {
	    board[count][col] -= 1;
	    board[row][count] -= 1;
	}

	for (int count = row, num = col; count > -1 && num > -1; count--, num--) {
	    board[count][num] -= 1;
	}
	for (int count = row, num = col; count < board.length && num < board.length; count++, num++) {
	    board[count][num] -= 1;
	}

	for (int count = row, num = col; count < board.length && num > -1; count++, num--) {
	    board[count][num] -= 1;
	}
	for (int count = row, num = col; count > -1 && num < board.length; count--, num++) {
	    board[count][num] -= 1;
	}
	
	board[row][col] = 0;
    }

    public boolean solve () {
	return solveH(0);
    }

    private boolean solveH (int col) {

	if (col == board.length) {
	    updateBoardState();
	    return true;
	}

	for (int count = 0; count < board.length; count++) {
	    if (board[count][col] == 0) {
		addQueen(count, col);
		//System.out.println("Add Queen \n" + toString());
		if (solveH(col + 1)) {
		    return true;
		} else {
		    removeQueen(count, col);
		}
	    }
	}
	
	return false;
	
    }

    private void updateBoardState () {
	boardState = "";
	for (int[] ary : board) {
	    for (int num : ary) {
		if (num == -1) {
		    boardState += "Q ";
		} else {
		    boardState += num + " ";
		}
	    }
	    boardState += "\n";
	}
    }

    public String toString () {
	return boardState;
    }

    // for debugging
    public String toString (int num) {
	updateBoardState();
	return boardState;
    }

    private void reset () {
	size = board.length;
	board = new int[size][size];
    }

    public void countSolutions () {
	int solutions = 0;
    }

    public int getSolutionCount() {
	return -1;
    }

    

    public static void main (String[] args) {

	// QueenBoard board = new QueenBoard(4);
	
	int limit = 20;
        for (int count = 1; count < limit + 1; count++) {
	    QueenBoard board = new QueenBoard(count);
	    board.solve();
	    System.out.println(count + "\n" + board.toString());
	}
	    

	/*
	board.addQueen(4, 4);
	board.updateBoardState();
	System.out.println(board.toString());
	board.removeQueen(4, 4);
	board.updateBoardState();
	System.out.println(board.toString());
	*/
	
    }

}
