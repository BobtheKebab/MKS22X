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

	for (int count = 0, num = 0; count < board.length && num < -1; count++, num--) {
	    board[count][num] += 1;
	}
	for (int count = 0, num = 0; count > -1 && num < board.length; count--, num++) {
	    board[count][num] += 1;
	}
	
	board[row][col] = -1;
    }

    private void removeQueen (int row, int col) {
	for (int count = 0; count < board.length; count++) {
	    board[count][col] -= 1;
	    board[row][count] -= 1;
	}
	board[row][col] = 0;
    }

    public void solve () {

    }

    private void solveH () {

    }

    public void updateBoardState () {
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

    public static void main (String[] args) {
	QueenBoard board = new QueenBoard(8);
	board.addQueen(4, 4);
	board.updateBoardState();
	System.out.println(board.toString());
	board.removeQueen(4, 4);
	board.updateBoardState();
	System.out.println(board.toString());
    }

}
