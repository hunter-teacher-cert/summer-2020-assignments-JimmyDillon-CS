import java.util.*;
import java.io.*;
import java.math.*;

public class MSort {

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

  public static ArrayList<Integer> prestoArray (int numItems, int lo, int hi){

    ArrayList<Integer> retArray = new ArrayList<Integer> ();

    for (int i = 0; i < numItems; i++){
      retArray.add( (int) (lo + (hi - lo) * Math.random()));
    }

    return retArray;
  }

  public static ArrayList<Integer> merge(ArrayList<Integer> a,
                                         ArrayList<Integer> b) {
    // setup variables
    // make a new ArrayList
    // indices for each input
    int i = 0; // indices for a
    int j = 0; // indices for b
    ArrayList<Integer> mergeArray = new ArrayList<Integer> ();

    // while both indices are less than their respective lengths

    while ((i < a.size()) && (j < b.size())){

      // compare current index elements of each input list
      // add the smaller value to the new list
      if ((int)a.get(i) < (int)b.get(j)){
        mergeArray.add(a.get(i));
        i++; //update index we took the value from
      }
      else {
        mergeArray.add(b.get(j));
        j++; //update index we took the value from
      }
    }

    //loop ends: one index is past the end of the list
    while (i < a.size()){
      mergeArray.add(a.get(i));
      i++;
    }

    while (j < b.size()){
      mergeArray.add(b.get(j));
      j++;
    }

    //copy the values from the reamining list over

    //return the new list
    //System.out.println(mergeArray);
    return mergeArray;
  }//merge

  public static ArrayList<Integer> mergeSort(ArrayList<Integer> al){
    if (al.size() <= 1){
      //System.out.println(al);
      return al;
    }

    else{
      int mid = al.size()/2;
      ArrayList<Integer> loArray = slice(al, 0, mid - 1);
      //System.out.println(loArray);
      loArray = mergeSort(loArray);
      ArrayList<Integer> hiArray = slice(al, mid, al.size()-1);
      //System.out.println(hiArray);
      hiArray = mergeSort(hiArray);
      return merge(loArray, hiArray);
    }
  }

  public static ArrayList<Integer> slice(ArrayList<Integer> al, int lo, int hi) {

    ArrayList<Integer> sub = new ArrayList<Integer>();
    for (; lo <= hi; lo++) {
      sub.add( al.get(lo) );
    }//copy
    return sub;
  }//slice

  public static void main (String args[]){

    ArrayList<Integer> al000 = prestoArray (8000, 0, 100);
    System.out.println("Original Arrays:");
    System.out.println(al000);
    //ArrayList<Integer> al001 = prestoArray (2, 0, 100);
    //System.out.println(al001);
    //selSort(al000);
    //selSort(al001);
    //ArrayList<Integer> al002 = merge(al000, al001);

    /* Final Test

    System.out.println("Original Arrays:");
    System.out.println(al000);
    System.out.println(al001);
    selSort(al000);
    selSort(al001);
    System.out.println("Sorted Arrays:");
    System.out.println(al000);
    System.out.println(al001);
    */

    ArrayList<Integer> al002 = mergeSort(al000);
    System.out.println("Merged Array:");
    System.out.println(al002);


    /* Testing for Swap, findMin and prestoArray
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
