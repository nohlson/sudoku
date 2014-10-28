/*
Sudoku puzzle solver
Ian Polito and Nate Ohlson
CS180

*/
public class Sudoku { //default constructor
	static int[][] board;
	static int[][][] candidates;


	public void setCandidates() {
		//this first part sets only cells that have a value's candidate values to 0;
		for (int l = 0; l < 9; l++) {
			for (int m = 0; m < 9; m++) {
				for (int n = 0; n < 9; n++) { 
					candidates[l][m][n] = n;  
				}
			}
		}
		/////////
		//next section will calculate the actual candidates for the cells


	}

	public Sudoku() {
		int[][] board;
		board = new int[9][9];
		candidates = new int[9][9][9];
		for (int i = 0; i < 9; i++) {      //iterate through every cell in the 2D array
			for (int j = 0; j < 9; j++) {  //and set every value
				board[i][j] = 0;           //to 0
			}
		}
			 //creates a field for the board matrix

		for (int l = 0; l < 9; l++) {
			for (int m = 0; m < 9; m++) {
				for (int n = 0; n < 9; n++) { 
					candidates[l][m][n] = n;  //initializes the candidates 3D matrix to every value
				}
			}
		}
		 //creates a field for the candidates 3D matrix 
		//creates a Sudoku object and initializes an empty board
	}

	public Sudoku(int[][] inBoard) {
		/*creates a Sudoku object with an initial board defined
		by the 2D array 'board'. board[r][c] represents the
		value stored in the cell at the intersection of row r
		and column c. 0 represents an empty cell */
		board = inBoard; //sets the overall board equal to the arguement board

		for (int l = 0; l < 9; l++) {
			for (int m = 0; m < 9; m++) {
				for (int n = 0; n < 9; n++) { 
					candidates[l][m][n] = n;  
				}
			}
		}
	}

	public boolean isSolved() {
		//returns true if the board is in a solved state
		boolean holder = true;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != 0) { //iterates over all the cells in board and checks if their non-zero
					holder = true;
				} else {
					holder = false;
					break;
				}
			}
		}
		return holder;
	}

	public int[][] board() {
		//returns a copy of the current state of the board
		return board;
	}

	public boolean[] candidates(int row, int column) {
		//returns the list of candidates for the specified cell the array
		//contains true at i if i is a candidate for the cell at row and column
		boolean[] holder;
		holder = new boolean[9];
		holder[0] = true;
		return holder;
	}

	public boolean nakedSingles() {
		return true;
	}

	public boolean hiddenSingles() {
		return true;
	}

	public void solve() {
		/*the core of the solving code. attempts to solve the sudoku board created
		by the constructor */
		while (isSolved() && (nakedSingles() || hiddenSingles())) {
			//logic goes here
		}
	}

	public static void main(String[] args) {
		Sudoku s = new Sudoku();
		System.out.println(s.isSolved());
	}



}