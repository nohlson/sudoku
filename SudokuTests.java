import junit.framework.TestCase;

public class SudokuTests extends TestCase {
    
    private Sudoku s1; //tested with a simple board, all with naked singles; uses TestBoard1
    private Sudoku s2; //tested with another simple board, all with naked singles; uses TestBoard2
    private Sudoku s3; //tested with a more advanced board, with a few hidden singles; uses TestBoard3
    private Sudoku s4; //tested with another more advanced board, with many hidden singles; uses TestBoard4
    private Sudoku s5; //tested with a test board that doesn't contain enough numbers; uses TestBoard5
    private Sudoku s6; //tested with a test board that contains too many numbers; uses TestBoard6
    private Sudoku s7; //tested with no board; uses TestBoard7
    private Sudoku s8; //used to test the board() method
    private int[][] testMatrix = new int[9][9]; //also used to test the board() method
    
    protected void setUp() throws Exception {
        super.setUp();
        //initialize test puzzles
        
        int[][] TestBoard1 = { { 7, 9, 6, 8, 5, 4, 3, 0, 1},
                               { 2, 4, 3, 1, 7, 6, 9, 8, 5},
                               { 8, 5, 1, 0, 3, 9, 4, 7, 6},
                               { 1, 3, 7, 9, 6, 5, 8, 4, 2},
                               { 9, 2, 5, 4, 1, 8, 7, 6, 3},
                               { 4, 6, 8, 7, 2, 3, 5, 1, 9},
                               { 6, 0, 4, 5, 9, 7, 2, 3, 8},
                               { 5, 8, 2, 3, 4, 1, 6, 9, 0},
                               { 3, 7, 9, 6, 8, 2, 1, 5, 4} };
        
        int[][] TestBoard2 = { { 0, 0, 0, 0, 0, 0, 0, 0, 0},
                               { 0, 0, 0, 0, 0, 0, 0, 0, 0},
                               { 0, 0, 0, 0, 0, 0, 0, 0, 0},
                               { 0, 0, 0, 0, 0, 0, 0, 0, 0},
                               { 0, 0, 0, 0, 0, 0, 0, 0, 0},
                               { 0, 0, 0, 0, 0, 0, 0, 0, 0},
                               { 0, 0, 0, 0, 0, 0, 0, 0, 0},
                               { 0, 0, 0, 0, 0, 0, 0, 0, 0},
                               { 0, 0, 0, 0, 0, 0, 0, 0, 0} };
        
        int[][] TestBoard3 = { { 0, 0, 2, 7, 0, 0, 1, 5, 0},
                               { 1, 4, 0, 0, 3, 5, 0, 0, 0},
                               { 0, 7, 0, 2, 0, 0, 0, 0, 6},
                               { 6, 5, 4, 0, 0, 0, 0, 8, 0},
                               { 0, 0, 0, 0, 0, 0, 0, 0, 0},
                               { 0, 8, 0, 0, 0, 0, 5, 2, 1},
                               { 8, 0, 0, 0, 0, 7, 0, 4, 0},
                               { 0, 0, 0, 9, 4, 0, 0, 1, 8},
                               { 0, 1, 3, 0, 0, 2, 6, 0, 0} };
        
        int[][] TestBoard4 = { { 0, 0, 0, 1, 0, 9, 0, 0, 0},
                               { 5, 0, 0, 0, 0, 0, 9, 0, 6},
                               { 9, 0, 6, 5, 0, 0, 3, 0, 0},
                               { 0, 0, 8, 4, 0, 5, 0, 0, 0},
                               { 4, 0, 3, 0, 0, 0, 7, 0, 5},
                               { 0, 0, 0, 6, 0, 7, 4, 0, 0},
                               { 0, 0, 7, 0, 0, 6, 5, 0, 9},
                               { 2, 0, 5, 0, 0, 0, 0, 0, 8},
                               { 0, 0, 0, 7, 0, 1, 0, 0, 0} };
        
        int[][] TestBoard5 = { { 7, 9, 0, 0, 0, 0, 3, 0, 0},
                               { 0, 0, 0, 0, 0, 6, 9, 0, 0},
                               { 8, 0, 0, 0, 3, 0, 0, 7, 6},
                               { 0, 0, 0, 0, 0, 5, 0, 0, 0},
                               { 0, 0, 5, 4, 1, 8, 7, 0, 0},
                               { 4, 0, 0, 7, 0, 0, 0, 0, 0},
                               { 6, 1, 0, 0, 9, 0, 0, 0, 8},
                               { 0, 0, 2, 3, 0, 0, 0, 0, 0},
                               { 0, 0, 9, 0, 0, 2, 1, 0, 0} };
        
        int[][] TestBoard6 = { { 7, 9, 0, 0, 0, 0, 3, 0, 0},
                               { 0, 0, 0, 0, 0, 6, 9, 0, 0},
                               { 8, 0, 0, 0, 3, 0, 0, 7, 6},
                               { 0, 0, 0, 0, 0, 5, 0, 0, 0},
                               { 0, 0, 5, 4, 1, 8, 7, 0, 0},
                               { 4, 0, 0, 7, 0, 0, 0, 0, 0},
                               { 6, 1, 0, 0, 9, 0, 0, 0, 8},
                               { 0, 0, 2, 3, 0, 0, 0, 0, 0},
                               { 0, 0, 9, 0, 0, 0, 0, 5, 4} };
        
        s1 = new Sudoku(TestBoard1);
        s2 = new Sudoku(TestBoard2);
        s3 = new Sudoku(TestBoard3);
        s4 = new Sudoku(TestBoard4);
        s5 = new Sudoku(TestBoard5);
        s6 = new Sudoku(TestBoard6);
        
    }
    //test if the program can solve the puzzles
        public void testSolve() {
            
        }
        
        public void testBoard() { //tests the board() method
          for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
              testMatrix[i][j] = 0;
            }
          }
          s7 = new Sudoku(testMatrix);
          assertEquals(testMatrix[0][0], s7.board()[0][0]);
        }
        
        public void testCandidates() { //tests the candidates(int row, int column) method
            boolean[] holder = s2.candidates(0, 0);
            assertEquals(true, holder[0]);
        }
        
        public void testIsSolved() { //tests the isSolved() method
          s2.solve();
          assertEquals(false,s2.isSolved());
        }
        
        public void testNakedSingles() {
            
        }
        
        public void testHiddenSingles() {
            
        }

}
