import java.util.*;
import java.io.*;
import java.math.*;

public class SelectionSort {
  
/*
    Uses selection sort (least to greatest) an ArrayList of type Integer 
*/

  public static void selSort (ArrayList <Integer> al){

    // for loop
    for (int i = 0; i < al.size()-1; i++){
      int minIndex = findMin(al, i); // find minIndex of a specific range of the al
      Swap (al, i, minIndex); // swap minIndex value with current value of iterator i.
    }
  }
  
/*
    Finds and returns the index of the smallest value in an ArrayList's range.
*/
  
  public static int findMin (ArrayList <Integer> al, int start){
    
    // int minIndex will hold the index of the smallest value in the AL's range. Originally set to the value found at start.
    int minIndex = start;  
    // for loop to iterate from start index to al's last index.
    for (int i = start; i <  al.size(); i++){
      //System.out.println("i = " + i);//diagnostic
      if ((int)al.get(i) < (int)al.get(minIndex)){
        minIndex = i; // reassign minIndex if a smaller number if found.
      }
    }
  
    return minIndex;
    
  }

/*
    Swaps the values found at index a and b of a passed ArrayList.
*/

  public static void Swap (ArrayList <Integer> al, int a, int b){
    
    // Creates a temporary int to hold the value at index a.
    int temp = al.get(a);
    // Set value at index a with value at index b.
    al.set(a, al.get(b));
    // Set value at index b with tmp variable.
    al.set(b, temp);
  }
  
/*
    Creates a randomized array with numItems values between lo and hi
*/
  
  public static ArrayList<Integer> PrestoArray (int numItems, int lo, int hi){
    
    ArrayList<Integer> retArray = new ArrayList<Integer> ();
    
    for (int i = 0; i < numItems; i++){
      retArray.add( (int) (lo + (hi - lo) * Math.random()));
    }
    
    return retArray;  
  }
  
  public static void main (String args[]){

    ArrayList<Integer> al000 = PrestoArray (10, 0, 100);
    
    /* Final Test
    */
    System.out.println("Original Array:");
    System.out.println(al000);
    selSort(al000);
    System.out.println("Sorted Array:");
    System.out.println(al000);
    
    
    /* Testing for Swap, findMin and PrestoArray
    System.out.println("Original Array:");
    System.out.println(al000);
    System.out.print("Smallest value:");
    System.out.println(findMin(al000, 0));
    Swap(al000, 0, 9);
    System.out.println("Swapped first and last items:");
    System.out.println(al000);
    */
  }
  
}