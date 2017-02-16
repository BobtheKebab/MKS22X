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

    private int[] ValidMoves (int row, int col) {
	int[][] answer = new int[8][2];
        try {
	    if (!board[row - 2][col + 1] == 0) {
		answer[0][1] = row -2;
		answer[0][2] = col + 1;
	    }

	

    public boolean Solve () {
	return solveH(0, 0, 1);
    }

    private boolean solveH (int row, int col, int level) {
	
	if (level > numKnights) {
	    updateBoardState();
	    return true;
	}

	board[row][col] = level;

    }

    public static void main (String[] args) {

	KnightBoard dank = new KnightBoard(5, 5);
	System.out.println(dank.toString(0));

    }
}
