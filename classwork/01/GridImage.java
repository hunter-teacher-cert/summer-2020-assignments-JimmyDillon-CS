import java.io.*;
import java.util.*;

public class GridImage {

  public static void main(String[] args) {

    int rows = 9;
    int cols = 9;

    int[][] grid = new int[rows][cols];
    
    //rowPop(grid, 4, 500);
    //colPop(grid, 4, 500);
    invert(grid);
    diagonal(grid, 4, 4, 0, 000);
    diagonal(grid, 4, 4, 1, 111);
    diagonal(grid, 4, 4, 2, 222);
    diagonal(grid, 4, 4, 3, 333);

    print2d(grid);
    System.out.println();

  }

  public static void print2d(int[][] d2) {

    for (int r=0; r < d2.length; r++) {
      for (int c=0; c < d2[r].length; c++) {

        System.out.printf("%03d ", d2[r][c]);
      }//end c for

      System.out.println();
    }//end r for
  }//end print2d

  public static void colPop(int[][] d2, int c, int value) {
    for (int r = 0; r < d2.length; r++){
      d2[r][c] = value;
    }
  }//end colPop

  public static void rowPop(int[][] d2, int r, int value) {
    for (int c = 0; c < d2[0].length; c++){
      d2[r][c] = value;
      }
  }//end rowPop

  public static void invert(int[][] d2) {
    for (int r=0; r < d2.length; r++) {
      for (int c=0; c < d2[r].length; c++) {
        if(d2[r][c] == 0){
          d2[r][c] = 255;
        }
        else{
          d2[r][c] = 0;
        }
      }
    }
  }//end invert

  /*
    0: up + left
    1: up + right
    2: down + left
    3: down + right
   */
  public static void diagonal(int[][] d2, int r, int c, int direction, int value) {
    
    while (inBounds(d2, r, c)){
      d2[r][c] = value;
      
      if(direction == 0){
        r--;
        c--;
      }
      else if(direction == 1){
        r--;
        c++;
      }
      else if(direction == 2){
        r++;
        c--;
      }
      else if(direction == 3){
        r++;
        c++;
      }
    }
    
  }//end diagonal

  public static boolean inBounds(int [][] d2, int row, int col){
    if(row < d2.length && col < d2[0].length && row >= 0 && col >= 0){
      return true;
    }
    else{
      return false;
    }
  }
}