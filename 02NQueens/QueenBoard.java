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
		    boardState += "~ ";
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
	int size = board.length;
	board = new int[size][size];
    }

    public void countSolutions () {
	reset();
        countSolutionsH(0);
    }

    private void countSolutionsH (int col) {

	if (col == board.length) {
	    updateBoardState();
	    solutionCount++;
	    return;
	}

	for (int count = 0; count < board.length; count++) {
	    if (board[count][col] == 0) {
		addQueen(count, col);
		countSolutionsH(col + 1);
		removeQueen(count, col);
	    }
	}
	
	return;
	
    }

    public int getSolutionCount() {
	if (solutionCount == 0) {
	    if (board.length == 2 || board.length == 3) {
		return 0;
	    } else {
		return -1;
	    }
	} else {
	    return solutionCount;
	}
    }

    

    public static void main (String[] args) {

	int tock = 1;
	if (tock == 1) {
	    int lim = 12;
	    for (int count = 1; count < lim + 1; count++) {
		QueenBoard dank = new QueenBoard(count);
		dank.countSolutions();
		System.out.println(count + " " + dank.getSolutionCount());
	    }
	}

	System.out.println("\n--------------------------------------------------------------------------\n");

	int tick = 1;
	if (tick  == 1) {
	    int limit = 12;
	    for (int count = 1; count < limit + 1; count++) {
		QueenBoard board = new QueenBoard(count);
		board.solve();
		System.out.println(count + "\n" + board.toString());
	    }
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
