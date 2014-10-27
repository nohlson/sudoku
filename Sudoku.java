/*
Sudoku puzzle solver
Ian Polito and Nate Ohlson
CS180
*/

public class Sudoku { //default constructor

	public Sudoku() {
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
	}

	public void solve() {
		/*the core of the solving code. attempts to solve the sudoku board created
		by the constructor */
	}

	public int[][] board() {
		//returns a copy of the current state of the board
	}

	public boolean[] candidates(int row, int column) {
		//returns the list of candidates for the specified cell the array
		//contains true at i if i is a candidate for the cell at row and column
	}


}