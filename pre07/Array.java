import java.math.*;
import java.util.*;

public class Array{

/**
1. The goal of this exercise is to practice encapsulation with some of the examples in this chapter.
  (A) Starting with the code in Section 8.6, write a method called powArray that takes a double array, a, and returns a new array that contains the elements of a squared. Generalize it to take a second argument and raise the elements of a to the given power.
  (B)Starting with the code in Section 8.10, write a method called histogram that takes an int array of scores from 0 to (but not including) 100, and returns a histogram of 100 counters. Generalize it to take the number of counters as an argument.
*/

  public static void main(String[] args) {

/** Question 1
    double [] bases = new double[6];

    for (int i = 0; i < bases.length; i++){
      bases[i] = (double)i;
    }

    System.out.println(Arrays.toString(powArray(bases, 3.0)));
*/

  int[] scores = new int[20];

  Random random = new Random();

  for(int i = 0; i < scores.length; i++){
    scores[i] = random.nextInt(100);
  }

  System.out.println(Arrays.toString(scores));
  System.out.println(Arrays.toString(histogram(scores, 20)));
  }
/**
  public static double[] powArray(double[] bases, double power){
    double[] results = new double[bases.length];

    for (int i = 0; i < bases.length; i++) {
      results[i] = Math.pow(bases[i], power);
    }
    return results;
  }
*/

  public static int[] histogram (int[] scores, int counters){

    int[] counts = new int[counters];
    int low = 0;
    int interval = 100/counters;
    int high = low + interval;

    for (int i = 0; i < counts.length; i++){
      counts[i] = inRange(scores, low, high);
      low = high;
      high = high + interval;
    }

    return counts;
  }

  public static int inRange(int[] a, int low, int high) {
    int count = 0;
    for (int i = 0; i < a.length; i++) {
        if (a[i] >= low && a[i] < high) {
            count++;
        }
    }
    return count;
  }
}
