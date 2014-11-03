/*
Sudoku puzzle solver
Ian Polito and Nate Ohlson
CS180

*/
public class Sudoku { //default constructor
	static int[][] board = new int[9][9];
	static int[][][] candidates = new int[9][9][9];
	static boolean isNakedSingles = true;;
	static boolean isHiddenSingles = true;
	


	public void setHiddenSingles() {
		/*The setHiddenSingles() method will try to find cells that can only be one number based on the current known board candidates
		but are not naked singles. The first section will search through the row and the column of a given cell to see if a sepecific
		candidate exists or not in any other of the cell's candidates. If that candidate does not exist in any of the other cells in that
		cells row or column that candidate  will be set to the given cell.*/
		int testCandidate = 0;
		boolean isInRow = false;
		boolean isInColumn = false;
		isHiddenSingles = false;
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) { //picked cell
				setCandidates();
				for (int z = 0; z < 9; z++) {
					if (candidates[r][c][z] != 0) { //picked a single candidate in that cell to test full row and columb candidates
						testCandidate = candidates[r][c][z];
						isInColumn = false;
						isInRow = false;
						//search column by incrementing row vv downwards aka column stays the same
						for (int r2 = 0; r2 < 9; r2++) {
							if (r2 != r) {
								for (int z2 = 0; z2 < 9; z2++) {
									if (testCandidate == candidates[r2][c][z2]) {
										isInColumn = true;
									} 
								}
								
							}
						}
						if (!isInColumn) {
							board[r][c] = testCandidate;
							isHiddenSingles = true;
						} 
						//search row by incrementing column >> sideways aka row stays the same
						for (int c2 = 0; c2 < 9; c2++) {
							if (c2 != c) {
								for (int z3 = 0; z3 < 9; z3++) {
									if (testCandidate == candidates[r][c2][z3]) {
										isInRow = true;
									} 
								}
							}
						}
						if (!isInRow) {
							board[r][c] = testCandidate;
							isHiddenSingles = true;
						}
					}
				}
			}
		}


		/*the second section of finding hidden singles consists of checking the 'boxes' above and/or below, to the right and/or
		to the left of the 'box' of a given cell. it consists of some of the most terribly written code in the
		history of time. it is so redundant and stupid that noone should ever emulate it. It's over 400 lines of code that could
		be simplified to possibly 60 or 70.*/
		int otherBoxHolder = 0;
		int changeHorizontal = 0;
		int changeVertical = 0;
		for (int rr = 0; rr < 9; rr++) {
			for (int cc = 0; cc < 9; cc++) { //picked cell
				setCandidates();
				if (board[rr][cc] == 0) {
					for (int zz = 0; zz < 9; zz++) {
						if (candidates[rr][cc][zz] != 0) {
							otherBoxHolder = candidates[rr][cc][zz];
							changeVertical = 0;
							changeHorizontal = 0;


							if (rr < 3 && cc < 3) { //box 1

								for (int b2r = 0; b2r < 3; b2r++) { //checking box 2
									for (int b2c = 3; b2c < 6; b2c++) {
										if (board[b2r][b2c] == otherBoxHolder) {
											changeHorizontal++;
										}

									}
								}

								for (int b3r = 0; b3r < 3; b3r++) { //checking box 3
									for (int b3c = 6; b3c < 9; b3c++) {
										if (board[b3r][b3c] == otherBoxHolder) {
											changeHorizontal++;
										}
									}
								}

								if (changeHorizontal == 2) {
									board[rr][cc] = otherBoxHolder;
									isHiddenSingles = true;
								}

								for (int bd1r = 3; bd1r < 6; bd1r++) { //checking box 4
									for (int bd1c = 0; bd1c < 3; bd1c++) {
										if (board[bd1r][bd1c] == otherBoxHolder) {
											changeVertical++;
										}
									}
								}

								for (int bd2r = 6; bd2r < 9; bd2r++) { //checking box 7
									for (int bd2c = 0; bd2c < 3; bd2c++) {
										if (board[bd2r][bd2c] == otherBoxHolder) {
											changeVertical++;
										}
									}
								}

								if (changeVertical == 2) {
									board[rr][cc] = otherBoxHolder;
									isHiddenSingles = true;
								}

							}

							if (rr < 3 && cc < 6 && cc >= 3) { // box 2

								for (int b2lr = 0; b2lr < 3; b2lr++) { //checking box 1
									for (int b2lc = 0; b2lc < 3; b2lc++) {
										if (board[b2lr][b2lc] == otherBoxHolder) {
											changeHorizontal++;
										}
									}
								}

								for (int b2rr = 0; b2rr < 3; b2rr++) { //checking box 3
									for (int b2rc = 6; b2rc < 9; b2rc++) {
										if (board[b2rr][b2rc] == otherBoxHolder) {
											changeHorizontal++;
										}
									}
								}

								if (changeHorizontal == 2) {
									board[rr][cc] = otherBoxHolder;
									isHiddenSingles = true;
								}

								for (int b1dr = 3; b1dr < 6; b1dr++) { //checking box 5
									for (int b2dc = 3; b2dc < 6; b2dc++) {
										if (board[b1dr][b2dc] == otherBoxHolder) {
											changeVertical++;
										}
									}
								}

								for (int b2dr = 3; b2dr < 6; b2dr++) { //checking box 6
									for (int b2dc = 6; b2dc < 9; b2dc++) {
										if (board[b2dr][b2dc] == otherBoxHolder) {
											changeVertical++;
										}
									}
								}

								if (changeVertical == 2) {
									board[rr][cc] = otherBoxHolder;
									isHiddenSingles = true;
								}

							}

							if (rr < 3 && cc >= 6) { //box 3

								for (int b2lr = 0; b2lr < 3; b2lr++) { //checking box 1
									for (int b2lc = 0; b2lc < 3; b2lc++) {
										if (board[b2lr][b2lc] == otherBoxHolder) {
											changeHorizontal++;
										}
									}
								}

								for (int b2r = 0; b2r < 3; b2r++) { //checking box 2
									for (int b2c = 3; b2c < 6; b2c++) {
										if (board[b2r][b2c] == otherBoxHolder) {
											changeHorizontal++;
										}

									}
								}

								if (changeHorizontal == 2) {
									board[rr][cc] = otherBoxHolder;
									isHiddenSingles = true;
								}


								for (int b2dr = 3; b2dr < 6; b2dr++) { //checking box 6
									for (int b2dc = 6; b2dc < 9; b2dc++) {
										if (board[b2dr][b2dc] == otherBoxHolder) {
											changeVertical++;
										}
									}
								}

								for (int b3dr = 6; b3dr < 9; b3dr++) { //checking box 9
									for (int b3dc = 6; b3dc < 9; b3dc++) {
										if (board[b3dr][b3dc] == otherBoxHolder) {
											changeVertical++;
										}
									}
								}

								if (changeVertical == 2) {
									board[rr][cc] = otherBoxHolder;
									isHiddenSingles = true;
								}

							}

							if (rr >= 3 && rr < 6 && cc < 3) { //box 4

								for (int b2lr = 0; b2lr < 3; b2lr++) { //checking box 1
									for (int b2lc = 0; b2lc < 3; b2lc++) {
										if (board[b2lr][b2lc] == otherBoxHolder) {
											changeVertical++;
										}
									}
								}

								for (int bd2r = 6; bd2r < 9; bd2r++) { //checking box 7
									for (int bd2c = 0; bd2c < 3; bd2c++) {
										if (board[bd2r][bd2c] == otherBoxHolder) {
											changeVertical++;
										}
									}
								}

								if (changeVertical == 2) {
									board[rr][cc] = otherBoxHolder;
									isHiddenSingles = true;
								}

								for (int b1dr = 3; b1dr < 6; b1dr++) { //checking box 5
									for (int b2dc = 3; b2dc < 6; b2dc++) {
										if (board[b1dr][b2dc] == otherBoxHolder) {
											changeHorizontal++;
										}
									}
								}

								for (int b2dr = 3; b2dr < 6; b2dr++) { //checking box 6
									for (int b2dc = 6; b2dc < 9; b2dc++) {
										if (board[b2dr][b2dc] == otherBoxHolder) {
											changeHorizontal++;
										}
									}
								}

								if (changeHorizontal == 2) {
									board[rr][cc] = otherBoxHolder;
									isHiddenSingles = true;
								}
							}

							if (rr >= 3 && rr < 6 && cc >= 3 && cc < 6) { //box 5

								for (int b2r = 0; b2r < 3; b2r++) { //checking box 2
									for (int b2c = 3; b2c < 6; b2c++) {
										if (board[b2r][b2c] == otherBoxHolder) {
											changeVertical++;
										}

									}
								}

								for (int bd4r = 6; bd4r < 9; bd4r++) { //checking box 8
									for (int bd4c = 3; bd4c < 6; bd4c++) {
										if (board[bd4r][bd4c] == otherBoxHolder) {
											changeVertical++;
										}
									}
								}

								if (changeVertical == 2) {
									board[rr][cc] = otherBoxHolder;
									isHiddenSingles = true;
								}

								for (int bd1r = 3; bd1r < 6; bd1r++) { //checking box 4
									for (int bd1c = 0; bd1c < 3; bd1c++) {
										if (board[bd1r][bd1c] == otherBoxHolder) {
											changeHorizontal++;
										}
									}
								}

								for (int b2dr = 3; b2dr < 6; b2dr++) { //checking box 6
									for (int b2dc = 6; b2dc < 9; b2dc++) {
										if (board[b2dr][b2dc] == otherBoxHolder) {
											changeHorizontal++;
										}
									}
								}

								if (changeHorizontal == 2) {
									board[rr][cc] = otherBoxHolder;
									isHiddenSingles = true;
								}
							}

							if (rr >= 3 && rr < 6 && cc >= 6) { //box 6

								for (int bd1r = 3; bd1r < 6; bd1r++) { //checking box 4
									for (int bd1c = 0; bd1c < 3; bd1c++) {
										if (board[bd1r][bd1c] == otherBoxHolder) {
											changeHorizontal++;
										}
									}
								}

								for (int b1dr = 3; b1dr < 6; b1dr++) { //checking box 5
									for (int b2dc = 3; b2dc < 6; b2dc++) {
										if (board[b1dr][b2dc] == otherBoxHolder) {
											changeHorizontal++;
										}
									}
								}

								if (changeHorizontal == 2) {
									board[rr][cc] = otherBoxHolder;
									isHiddenSingles = true;
								}

								for (int b2rr = 0; b2rr < 3; b2rr++) { //checking box 3
									for (int b2rc = 6; b2rc < 9; b2rc++) {
										if (board[b2rr][b2rc] == otherBoxHolder) {
											changeVertical++;
										}
									}
								}

								for (int bd2r = 6; bd2r < 9; bd2r++) { //checking box 9
									for (int bd2c = 6; bd2c < 9; bd2c++) {
										if (board[bd2r][bd2c] == otherBoxHolder) {
											changeVertical++;
										}
									}
								}

								if (changeVertical == 2) {
									board[rr][cc] = otherBoxHolder;
									isHiddenSingles = true;
								}
							}

							if (rr > 6 && cc < 3) { //box 7

								for (int b2lr = 0; b2lr < 3; b2lr++) { //checking box 1
									for (int b2lc = 0; b2lc < 3; b2lc++) {
										if (board[b2lr][b2lc] == otherBoxHolder) {
											changeVertical++;
										}
									}
								}

								for (int b2r = 0; b2r < 3; b2r++) { //checking box 2
									for (int b2c = 3; b2c < 6; b2c++) {
										if (board[b2r][b2c] == otherBoxHolder) {
											changeVertical++;
										}

									}
								}

								if (changeVertical == 2) {
									board[rr][cc] = otherBoxHolder;
									isHiddenSingles = true;
								}

								for (int bd4r = 6; bd4r < 9; bd4r++) { //checking box 8
									for (int bd4c = 3; bd4c < 6; bd4c++) {
										if (board[bd4r][bd4c] == otherBoxHolder) {
											changeHorizontal++;
										}
									}
								}

								for (int bd2r = 6; bd2r < 9; bd2r++) { //checking box 9
									for (int bd2c = 6; bd2c < 9; bd2c++) {
										if (board[bd2r][bd2c] == otherBoxHolder) {
											changeHorizontal++;
										}
									}
								}

								if (changeHorizontal == 2) {
									board[rr][cc] = otherBoxHolder;
									isHiddenSingles = true;
								}
							}

							if (rr > 6 && cc >= 3 && cc < 6) { //box 8

								for (int b2r = 0; b2r < 3; b2r++) { //checking box 2
									for (int b2c = 3; b2c < 6; b2c++) {
										if (board[b2r][b2c] == otherBoxHolder) {
											changeVertical++;
										}

									}
								}

								for (int b1dr = 3; b1dr < 6; b1dr++) { //checking box 5
									for (int b2dc = 3; b2dc < 6; b2dc++) {
										if (board[b1dr][b2dc] == otherBoxHolder) {
											changeVertical++;
										}
									}
								}

								if (changeVertical == 2) {
									changeVertical++;
								}

								for (int bd2r = 6; bd2r < 9; bd2r++) { //checking box 7
									for (int bd2c = 0; bd2c < 3; bd2c++) {
										if (board[bd2r][bd2c] == otherBoxHolder) {
											changeHorizontal++;
										}
									}
								}

								for (int bd2r = 6; bd2r < 9; bd2r++) { //checking box 9
									for (int bd2c = 6; bd2c < 9; bd2c++) {
										if (board[bd2r][bd2c] == otherBoxHolder) {
											changeHorizontal++;
										}
									}
								}

								if (changeHorizontal == 2) {
									board[rr][cc] = otherBoxHolder;
									isHiddenSingles = true;
								}

	 						}

	 						if (rr >= 6 && cc >= 6) { //box 9


	 							for (int b2rr = 0; b2rr < 3; b2rr++) { //checking box 3
									for (int b2rc = 6; b2rc < 9; b2rc++) {
										if (board[b2rr][b2rc] == otherBoxHolder) {
											changeVertical++;
										}
									}
								}

								for (int b2dr = 3; b2dr < 6; b2dr++) { //checking box 6
									for (int b2dc = 6; b2dc < 9; b2dc++) {
										if (board[b2dr][b2dc] == otherBoxHolder) {
											changeVertical++;
										}
									}
								}

								if (changeVertical == 2) {
									board[rr][cc] = otherBoxHolder;
									isHiddenSingles = true;
								}

								for (int bd2r = 6; bd2r < 9; bd2r++) { //checking box 7
									for (int bd2c = 0; bd2c < 3; bd2c++) {
										if (board[bd2r][bd2c] == otherBoxHolder) {
											changeHorizontal++;
										}
									}
								}

								for (int bd4r = 6; bd4r < 9; bd4r++) { //checking box 8
									for (int bd4c = 3; bd4c < 6; bd4c++) {
										if (board[bd4r][bd4c] == otherBoxHolder) {
											changeHorizontal++;
										}
									}
								}

								if (changeHorizontal == 2) {
									board[rr][cc] = otherBoxHolder;
									isHiddenSingles = true;
								}
							}
 						}
					}
				}
			}
		}
	}


	public void setNakedSingles() {
		//find a cell with a naked single
		int zeroCounter = 0;
		isNakedSingles = false;
		for (int l = 0; l < 9; l++) {
			for (int m = 0; m < 9; m++) {
				zeroCounter = 0;
				for (int o = 0; o < 9; o++){
					if (candidates[l][m][o] == 0) {
						zeroCounter++;
					}
					if (zeroCounter == 8) { //found a naked single. put that in
						for (int z = 0; z < 9; z++) {
							if (candidates[l][m][z] != 0) {
								board[l][m] = candidates[l][m][z];
								isNakedSingles = true;
								break;
							}
						}
					}
				}
			}
		}
	}


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
						if (board[l][o] != 0) {
							holder = board[l][o];
							candidates[l][m][holder - 1] = 0;
						}
			}
		}
		///////
		//////eliminate candidates based on column
		for (int l = 0; l < 9; l++) {
			for (int m = 0; m < 9; m++) {
				for (int o = 0; o < 9; o++) {
					if (board[o][m] != 0) {
						holder = board[o][m];
						candidates[l][m][holder - 1] = 0;
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
		/////
	}

	public Sudoku() {
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

	public Sudoku(int[][] isBoard) {
		/*creates a Sudoku object with an initial board defined
		by the 2D array 'board'. board[r][c] represents the
		value stored in the cell at the intersection of row r
		and column c. 0 represents an empty cell */
		// board = inBoard; //sets the overall board equal to the arguement board
		board = isBoard;
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
		outerloop:
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != 0) { //iterates over all the cells in board and checks if their non-zero
					holder = true;
				} else {
					holder = false;
					break outerloop;
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
		for (int h = 0; h < 9; h++) {
			if (candidates[row][column][h] != 0) {
				holder[h] = true;
			}
		}
		return holder;
	}

	public boolean nakedSingles() {
		return isNakedSingles;
	}

	public boolean hiddenSingles() {
		return isHiddenSingles;
	}

	public void solve() {
		/*the core of the solving code. attempts to solve the sudoku board created
		by the constructor */
		printBoard();
		int solveIterations = 0;
		System.out.println("###########################");
		while (!isSolved() && (nakedSingles() || hiddenSingles())) {
			//logic goes here
			//the basic idea goes as this
			//Step 1: setCandidates()
			//Step 2: find naked singles
			//Step 3: set naked singles to board value
			//step 4: setCandidates()
			//step 5: repeat until no more naked singles
			//step 6: find hidden singles
			//step 7: set hidden singles to board value
			//step 8: repeat whole system until solved
			

			setCandidates();
			while (isNakedSingles) {
				setNakedSingles();
				setCandidates();
			}
			while (isHiddenSingles) {
				setHiddenSingles();
				setCandidates();
			}


			solveIterations++;
			if (solveIterations > 30) {
				System.out.println("The puzzle is too difficult for this version. Try again later(:");
				break;
			}


		}
		printBoard();
	}

	public static void main(String[] args) {
		int[][] testBoard;
		testBoard = new int[9][9];
		if (args.length > 0) {
			int m = 0;
			for (int r = 0; r < 9; r++) {
				for (int c = 0; c < 9; c++) {
						testBoard[r][c] = Character.getNumericValue(args[0].charAt(m));
						m++;
				}
			}
			
			
		} else {
			// testBoard[3][3] = 4;
			// testBoard[3][4] = 6;
			// testBoard[3][5] = 1;
			// testBoard[4][3] = 3;
			// testBoard[4][4] = 7;
			// testBoard[4][5] = 9;
			// testBoard[5][3] = 2;
			// testBoard[5][5] = 5;

			// testBoard[0][4] = 1;
			// testBoard[1][4] = 2;


			// testBoard[3][4] = 6;
			// testBoard[4][4] = 7;
			// // testBoard[5][4] = 8;

			// testBoard[6][4] = 5;
			// testBoard[7][4] = 4;
			// testBoard[8][4] = 9;
			


		}
		int[][] testBoard2 = {   {0,0,0,0,0,0,0,0,0},
								{0,0,0,2,0,0,0,0,0},
								{3,0,0,0,0,0,0,0,0},
								{4,0,0,0,0,0,0,0,0},
								{5,0,0,0,0,0,0,0,0},
								{6,0,0,0,0,0,0,0,0},
								{7,0,0,0,0,0,0,0,0},
								{8,0,0,0,0,0,0,0,0},
								{9,0,0,0,0,0,0,0,0},
			};

		Sudoku s = new Sudoku(testBoard2);
		//s.solve();
		s.printBoard();
		s.setHiddenSingles();
		s.printBoard();

		

		//check
		
		
	}



}