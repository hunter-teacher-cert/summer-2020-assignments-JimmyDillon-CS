import java.math.*;
import java.util.*;

public class Array{

  public static void main(String[] args) {
    chooser();
  }

  public static double[] powArray(double[] bases, double power){
    double[] results = new double[bases.length];

    for (int i = 0; i < bases.length; i++) {
      results[i] = Math.pow(bases[i], power);
    }
    return results;
  }

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

  public static int indexofMax(int[] a){

    int maxIndex = 0;
    int max = a[0];

/** With a regular for loop
    for(int i = 1; i < a.length; i++){
      if (a[i] > max){
        max = a[i];
        maxIndex = i;
      }
    }
*/

// With an enhanced for loop
    int i = 0;
    for (int integer : a){
      if (integer > max) {
        max = integer;
        maxIndex = i;
      }
      i++;
    }
    return maxIndex;
  }

  public static boolean[] sieve (int integer){
    boolean[] truePrimes = new boolean[integer];
    int[] primes = new int[integer];

    primes[0] = 2;
    int primeCounter = 1;

    truePrimes[0] = false;
    truePrimes[1] = false;
    truePrimes[2] = true;

    for(int i = 3; i < integer-1; i++){
      boolean flag = true;
      for (int j = 0; j < primes.length; j++){
        if ((primes[j] != 0) && (i % primes[j]) == 0){
          flag = false;
        }
      }
      if (flag == true){
        primes[primeCounter] = i;
        primeCounter++;
      }
      truePrimes[i] = flag;
    }
    System.out.println(Arrays.toString(primes));
    return truePrimes;
  }

  public static void chooser(){
    int choice;
    Scanner in = new Scanner (System.in);

    System.out.println("Which question are you answering from Chapter 8 of Think Java? Please pick 1, 4, or 5");
    choice = in.nextInt();
/**
1. The goal of this exercise is to practice encapsulation with some of the examples in this chapter.
  (A) Starting with the code in Section 8.6, write a method called powArray that takes a double array, a, and returns a new array that contains the elements of a squared. Generalize it to take a second argument and raise the elements of a to the given power.
  (B)Starting with the code in Section 8.10, write a method called histogram that takes an int array of scores from 0 to (but not including) 100, and returns a histogram of 100 counters. Generalize it to take the number of counters as an argument.
*/

    if (choice == 1){

      System.out.println("Which part are you answering?");
      choice = in.nextInt();

      if (choice == 1){
        double [] bases = new double[6];
        double exp = 3.0;

        for (int i = 0; i < bases.length; i++){
          bases[i] = (double)i;
        }
        System.out.println(Arrays.toString(bases));
        System.out.println("POWER UP! (EXPONENT: " + exp +")");
        System.out.println(Arrays.toString(powArray(bases, exp)));
      }

      if (choice == 2){
        int[] scores = new int[20];

        Random random = new Random();

        for(int i = 0; i < scores.length; i++){
          scores[i] = random.nextInt(100);
        }

        System.out.println(Arrays.toString(scores));
        System.out.println(Arrays.toString(histogram(scores, 20)));
      }
    }
/**
4. Write a method called indexOfMax that takes an array of integers and returns the index of the largest element. Can you write this method using an enhanced for loop? Why or why not?
*/
    else if (choice == 4){
      int[] integers = new int[20];

      Random random = new Random();

      for(int i = 0; i < integers.length; i++){
        integers[i] = random.nextInt(100);
      }

      System.out.println(Arrays.toString(integers));
      System.out.println("The largest number can be found at this index: " + indexofMax(integers));
      System.out.println("Yes, you can use an enhanced for loop, but you have to take the extra step of creating and tracking an index number, which the enhanced for loop does not include. This kind of defeats the purpose of using an enhanced for loop.");
    }

/** The Sieve of Eratosthenes is “a simple, ancient algorithm for finding all prime numbers up to any given limit,” which you can read about at https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes.
Write a method called sieve that takes an integer parameter, n, and returns a boolean array that indicates, for each number from 0 to n - 1, whether the number is prime.
*/

    else if (choice == 5){
      System.out.println("What is your integer parameter for the Sieve of Eratosthenes?");
      choice = in.nextInt();
      System.out.println(Arrays.toString(sieve(choice)));
    }

    else{
      System.out.println("Please try again.");
    }
  }
}
