/*
Sudoku puzzle solver
Ian Polito and Nate Ohlson
CS180
*/

public class Sudoku { //default constructor
	

	public Sudoku() {
		int[][] board;
		board = new int[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				board[i][j] = 0;
			}
		}
		//creates a Sudoku object and initializes an empty board
	}

	public Sudoku(int[][] board) {
		/*creates a Sudoku object with an initial board defined
		by the 2D array 'board'. board[r][c] represents the
		value stored in the cell at the intersection of row r
		and column c. 0 represents an empty cell */
	}

	public boolean isSolved() {
		//returns true if the board is in a solved state
		return true;
	}

	public int[][] board() {
		//returns a copy of the current state of the board
		int[][] f;
		f = new int[1][1];
		f[0][0] = 1;
		return f;
	}

	public boolean[] candidates(int row, int column) {
		//returns the list of candidates for the specified cell the array
		//contains true at i if i is a candidate for the cell at row and column
		boolean[] f;
		f = new boolean[1];
		f[0] = true;
		return f;
	}

	public void solve() {
		/*the core of the solving code. attempts to solve the sudoku board created
		by the constructor */
	}

	public static void main(String[] args) {
		Sudoku s = new Sudoku();
		
	}



}