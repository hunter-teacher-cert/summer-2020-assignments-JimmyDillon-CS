import java.util.Scanner;
import java.math.*;

/**
2. Write a method named isDivisible that takes two integers, n and m, and that returns true if n is divisible by m, and false otherwise.

3. If you are given three sticks, you may or may not be able to arrange them in a triangle. For example, if one of the sticks is 12 inches long and the other two are one inch long, you will not be able to get the short sticks to meet in the middle. For any three lengths, there is a simple test to see if it is possible to form a triangle:

If any of the three lengths is greater than the sum of the other two, you cannot form a triangle.
Write a method named isTriangle that takes three integers as arguments and returns either true or false, depending on whether you can or cannot form a triangle from sticks with the given lengths. The point of this exercise is to use conditional statements to write a value method.

8. The goal of this exercise is to translate a recursive definition into a Java method. The Ackermann function is defined for non-negative integers as follows:

            ⎧
            |n+1	if  m = 0
A(m, n) = 	⎨A(m−1, 1)	if  m > 0  and  n = 0
            ⎪A(m−1, A(m, n−1))	if  m > 0  and  n > 0
            ⎩

Write a method called ack that takes two ints as parameters and that computes and returns the value of the Ackermann function.

Test your implementation of Ackermann by invoking it from main and displaying the return value. Note the return value gets very big very quickly. You should try it only for small values of m and n (not bigger than 3).
*/

public class Methods {

    public static void main(String[] args) {
      Scanner in = new Scanner (System.in);
      int choice;
      int dividend;
      int divisor;
      int sideA;
      int sideB;
      int sideC;
      int m;
      int n;

      System.out.println("Which question are you answering from Chapter 6 of Think Java? Please pick 2, 3, or 8");
      choice = in.nextInt();

      if (choice == 2){
        System.out.println("What is the dividend?");
        dividend = in.nextInt();

        System.out.println("What is the divisor?");
        divisor = in.nextInt();

        System.out.println("It is " + isDivisible(dividend, divisor) + " that the divisor is a factor of the dividend.");
      }

      else if (choice == 3){
        System.out.println("What is the length of side a?");
        sideA = in.nextInt();

        System.out.println("What is the length of side b?");
        sideB = in.nextInt();

        System.out.println("What is the length of side c?");
        sideC = in.nextInt();

        System.out.println("It is " + isTriangle(sideA, sideB, sideC) + " that you can form a triangle with those side lengths.");
      }

      else if (choice == 8){
        System.out.println("What is the value of m? Please use a non-negative integer.");
        m = in.nextInt();

        System.out.println("What is the value of n? Please use a non-negative integer.");
        n = in.nextInt();

        if (m < 0 || n < 0){
          System.out.println("Please choose non-negative integers next time.");
        }
        else{
        System.out.println("The return value of the Ackerman function is " + Ackerman (m, n));
        }
      }

      else{
        System.out.println("Please try again.");
      }
    }



/**
Determines whether m is a factor of n by analyzing the modulo remainder of n and m.

@ param n is the dividend, m is the divisor
@ return true if their modulo remainder is 0, false otherwise.
*/

    public static boolean isDivisible(int n, int m){
      if (n % m == 0){
        return true;
      }
      else{
        return false;
      }
    }

/**
Based on the side lengths of a triangle, the method determines whether such a triangle could exist based on the triangle inequality property

@ param a is the length of side a, b is the length of side b, and c is the length of side c;
@ return true if the triangle inequality property is true, false otherwise.
*/

    public static boolean isTriangle(int a, int b, int c){
      boolean cond1 = (a + b > c);
      boolean cond2 = (b + c > a);
      boolean cond3 = (c + a > b);

      if (cond1 && cond2 && cond3){
        return true;
      }
      else {
        return false;
      }
    }

/**
Computes the Ackerman function

@ param m is the first integer in the Ackerman function, n is the second integer.
@ returns the value after completing the Ackerman function.
*/

    public static int Ackerman (int m, int n){
      int result;

      if (m == 0){
        return n + 1;
      }
      else if(m > 0 && n == 0){
        result = Ackerman(m-1, 1);
      }
      else {
        result = Ackerman (m-1, Ackerman(m, n-1));
      }
      return result;
    }
}
