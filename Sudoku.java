/*
Sudoku puzzle solver
Ian Polito and Nate Ohlson
CS180

*/
public class Sudoku { //default constructor
	static int[][] board;
	static int[][][] candidates;


	public void printBoard() {
		System.out.println("    1 2 3   4 5 6   7 8 9    "); //this prints out the empty board
	    System.out.println("  +-------+-------+-------+  ");
	    System.out.println("A | "+board[0][0]+" "+board[0][1]+" "+board[0][2]+" | "+board[0][3]+" "+board[0][4]+" "+
	                       board[0][5]+" | "+board[0][6]+" "+board[0][7]+" "+board[0][8]+" | ");
	    System.out.println("B | "+board[1][0]+" "+board[1][1]+" "+board[1][2]+" | "+board[1][3]+" "+board[1][4]+" "+
	                       board[1][5]+" | "+board[1][6]+" "+board[1][7]+" "+board[1][8]+" | ");
	    System.out.println("C | "+board[2][0]+" "+board[2][1]+" "+board[2][2]+" | "+board[2][3]+" "+board[2][4]+" "+
	                        board[2][5]+" | "+board[2][6]+" "+board[2][7]+" "+board[2][8]+" | ");
	    System.out.println("  +-------+-------+-------+  ");
	    System.out.println("D | "+board[3][0]+" "+board[3][1]+" "+board[3][2]+" | "+board[3][3]+" "+board[3][4]+" "+
	                        board[3][5]+" | "+board[3][6]+" "+board[3][7]+" "+board[3][8]+" | ");
	    System.out.println("E | "+board[4][0]+" "+board[4][1]+" "+board[4][2]+" | "+board[4][3]+" "+board[4][4]+" "+
	                        board[4][5]+" | "+board[4][6]+" "+board[4][7]+" "+board[4][8]+" | ");
	    System.out.println("F | "+board[5][0]+" "+board[5][1]+" "+board[5][2]+" | "+board[5][3]+" "+board[5][4]+" "+
	                        board[5][5]+" | "+board[5][6]+" "+board[5][7]+" "+board[5][8]+" | ");
	    System.out.println("  +-------+-------+-------+  ");
	    System.out.println("G | "+board[6][0]+" "+board[6][1]+" "+board[6][2]+" | "+board[6][3]+" "+board[6][4]+" "+
	                        board[6][5]+" | "+board[6][6]+" "+board[6][7]+" "+board[6][8]+" | ");
	    System.out.println("H | "+board[7][0]+" "+board[7][1]+" "+board[7][2]+" | "+board[7][3]+" "+board[7][4]+" "+
	                        board[7][5]+" | "+board[7][6]+" "+board[7][7]+" "+board[7][8]+" | ");
	    System.out.println("I | "+board[8][0]+" "+board[8][1]+" "+board[8][2]+" | "+board[8][3]+" "+board[8][4]+" "+
	                        board[8][5]+" | "+board[8][6]+" "+board[8][7]+" "+board[8][8]+" | ");
	    System.out.println("  +-------+-------+-------+  ");
	}


	public void setCandidates() {
		//this first part sets only cells that have a value candidate values to 0;
		for (int l = 0; l < 9; l++) {
			for (int m = 0; m < 9; m++) {
				for (int n = 0; n < 9; n++) { 
					if (board[l][m] != 0) {
						candidates[l][m][n] = 0;  
					}
					
				}
			}
		}
		/////////
		//next section will calculate the actual candidates for the cells

		//eliminate candidates based on row
		int holder;
		for (int l = 0; l < 9; l++) {
			for (int m = 0; m < 9; m++) {
				for (int o = 0; o < 9; o++)
					if (o != m) {
						if (board[l][o] != 0) {
							holder = board[l][o];
							candidates[l][m][holder - 1] = 0;
						}
					}
			}
		}
		///////
		//////eliminate candidates based on column
		for (int l = 0; l < 9; l++) {
			for (int m = 0; m < 9; m++) {
				for (int o = 0; o < 9; o++) {
					if (o != m) {
						if (board[o][m] != 0) {
							holder = board[o][m];
							candidates[l][m][holder - 1] = 0;
						}	
					}
				}
			}
		}
		/////
		/////eliminate candidates based on box
		int numBox1 = 0;
		int numBox2 = 0;
		//box
		for (int nb = 0; nb <= 2; nb++) {
			numBox1 = nb * 3;
			for (int nb2 = 0; nb2 <= 2; nb2++) {
				numBox2 = nb2 * 3;
				for (int l = numBox1; l <= (2 + numBox1); l++) {
					for (int m = numBox2; m <= (2 + numBox2); m++) {
						for (int r = numBox1; r <= (2 + numBox1); r++) {
							for (int c = numBox2; c <= (2 + numBox2); c++) {

								if (board[r][c] != 0) {

									holder = board[r][c];
									candidates[l][m][holder - 1] = 0;
								}
							}
						}
					}
				}
			}
		}
		/*check
		for (int a = 0; a < 9; a++) {
			System.out.println(candidates[4][5][a]);
		}
		*/
		
		


	}

	public Sudoku() {
		candidates = new int[9][9][9];
		board = new int[9][9];
		for (int i = 0; i < 9; i++) {      //iterate through every cell in the 2D array
			for (int j = 0; j < 9; j++) {  //and set every value
				board[i][j] = 0;           //to 0
			}
		}
			 //creates a field for the board matrix

		for (int l = 0; l < 9; l++) {
			for (int m = 0; m < 9; m++) {
				for (int n = 0; n < 9; n++) { 
					candidates[l][m][n] = n + 1;  //initializes the candidates 3D matrix to every value
				}
			}
		}
		 //creates a field for the candidates 3D matrix 
		//creates a Sudoku object and initializes an empty board
	}

	public Sudoku(int[][] inBoard) {
		candidates = new int[9][9][9];
		board = new int[9][9];
		/*creates a Sudoku object with an initial board defined
		by the 2D array 'board'. board[r][c] represents the
		value stored in the cell at the intersection of row r
		and column c. 0 represents an empty cell */
		board = inBoard; //sets the overall board equal to the arguement board

		for (int l = 0; l < 9; l++) {
			for (int m = 0; m < 9; m++) {
				for (int n = 0; n < 9; n++) { 
					candidates[l][m][n] = n + 1;  
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
		int[][] testBoard;
		testBoard = new int[9][9];
		testBoard[3][3] = 4;
		testBoard[3][4] = 6;
		Sudoku s = new Sudoku(testBoard);
		System.out.println(s.isSolved());
		s.printBoard();
		s.setCandidates();
	}



}