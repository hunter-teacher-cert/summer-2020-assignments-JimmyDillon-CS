import java.io.*;
import java.util.*;
/*
  2D array 

  set up 
  change values in it

  a way of applying the GOL rules 
 */

/*
The Rules of Life:
Survivals: Every cell with 2 or 3 living neighbours survives for the next generation.
Death:
  * Each cell with >3 neighbours dies from overpopulation.
  * Every cell with <2 neighbours dies from isolation.
Birth:
  * Each dead cell adjacent to exactly 3 living neighbours is a birth cell. It will come alive next generation.
  
NOTA BENE:  All births and deaths occur simultaneously. Together, they constitute a single generation
*/

class Life{

    /*
      create a new 2D array, fill it with ' ' 
      representing that the entire board is empty.

     */
    public static char[][] createNewBoard(int rows, int cols){
    	char[][] board = new char[rows][cols];
    	for (int r = 0; r < rows; r++) {
    	  for (int c = 0; c < cols; c++) {
    		  board[r][c] = ' ';
	       }
	    }
	  return board;
    }
    
    public static void printBoard(char[][] board){
    	for (int r = 0; r < board.length; r++) {
    	    for (int c = 0; c < board[r].length; c++) {
    		    System.out.printf("%c",board[r][c]);
    	    }
    	  System.out.println();
    	}
    	System.out.println("\n\n------------------\n\n");
    }

    /*
      set the cell (r,c) to value
    */
    public static void setCell(char[][] board, int r, int c, char val){
    	if (r>=0 && r<board.length && c>=0 && c<board[r].length){
    	    board[r][c] = val;
    	}
    }
    /* 
       Count and return the number of living neigbords around board[r][c]

       approach 1 - lots of if statements
       approach 2 - you can loop over the grid from board[r-1][c-1]
                    to board[r+1][c+1]
    */
    public static int countNeighbours(char[][] board, int r, int c){
	    int neighbours = 0;
	    int[][] offset = new int[3][3];
	    for (int row = -1; row < 2; row++){
	      for (int col = -1; col < 2; col++){
	        if (inBounds(board, r + row, c + col) && board[r+row][c+col] == 'X' && (r != 0 && c!= 0)){
	          neighbours++;
	        }
	      }
	   }
	    
	    return neighbours;
    }
    public static boolean inBounds (char [][] board, int r, int c){
      if(r >= 0 && c >= 0 && r < board.length && c < board[r].length){
        return true;
      }
      else{
        return false;
      }
    }
    
    /*
      given a board and a cell, determine, based on the rules for 
      Conway's GOL if the cell is alive ('X') or dead (' ') in the 
      next generation.
      
     */
    public static char getNextGenCell(char[][] board,int r, int c){
    	// calculate the number of living neighbors around board[r][c]
      int neighbours = countNeighbours(board, r, c);

    	// determine if board[r][c] is living or dead
    	//    if living and 2 3 neighbors then remain alive
    	//    if dead and 3 neighbors then become alive
      if ((neighbours == 2 && board[r][c] == 'X') || (neighbours == 3)){
        return 'X';
      }
	    else{
	      return ' ';
	    }
    }
    /*
      scan the board to generate a NEW board with the
      next generation
    */
    public static char[][] generateNextBoard(char[][] board){
	    char newBoard[][] = new char[25][25];
	    // fill the new board
	    
	    for (int r = 0; r < board.length; r++) {
    	    for (int c = 0; c < board[r].length; c++) {
    		    newBoard[r][c] = getNextGenCell(board, r, c);
    	    }
    	}
    	
	    return newBoard;
    }
    
    public static void main(String[] args) {
    	char[][] board;
    	board = createNewBoard(25,25);
      setCell(board, 0, 0, 'X');
      setCell(board, 0, 1, 'X');
      setCell(board, 1, 0, 'X');
      printBoard(board);
      board = generateNextBoard(board);
      printBoard(board);
    }
}
