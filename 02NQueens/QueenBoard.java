public class QueenBoard {

    private int[][] board;
    private int solutionCount;
    private String boardState;

    public QueenBoard (int size) {
	board = new int[size][size];
	updateBoardState();
    }

    public void solve () {

    }

    private void solveH () {

    }

    private void updateBoardState () {
	boardState = "";
	for (int[] ary : board) {
	    for (int num : ary) {
		boardState += num;
	    }
	    boardState += "\n";
	}
    }

    public String toString () {
	return boardState;
    }

    public static void main (String[] args) {
	QueenBoard board = new QueenBoard(8);
	System.out.println(board.toString());
    }

}
