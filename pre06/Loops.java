import java.math.*;
import java.util.Scanner;

/**
3. In Exercise 9 we wrote a recursive version of power, which takes a double x and an integer n and returns x^n. Now write an iterative method to perform the same calculation.

4. Section 6.7 presents a recursive method that computes the factorial function. Write an iterative version of factorial.

5. One way to calculate ex is to use the infinite series expansion:

e^x = 1 + x + x2 / 2! + x3 / 3! + x4 / 4! + …
The ith term in the series is xi / i!.

a. Write a method called myexp that takes x and n as parameters and estimates ex by adding the first n terms of this series. You can use the factorial method from Section 6.7 or your iterative version from the previous exercise.
b. You can make this method more efficient if you realize that the numerator of each term is the same as its predecessor multiplied by x, and the denominator is the same as its predecessor multiplied by i. Use this observation to eliminate the use of Math.pow and factorial, and check that you get the same result.
Write a method called check that takes a parameter, x, and displays x, myexp(x), and Math.exp(x). The output should look something like:
1.0     2.708333333333333     2.718281828459045
You can use the escape sequence "\\t" to put a tab character between columns of a table.

Vary the number of terms in the series (the second argument that check sends to myexp) and see the effect on the accuracy of the result. Adjust this value until the estimated value agrees with the correct answer when x is 1.
Write a loop in main that invokes check with the values 0.1, 1.0, 10.0, and 100.0. How does the accuracy of the result vary as x varies? Compare the number of digits of agreement rather than the difference between the actual and estimated values.
Add a loop in main that checks myexp with the values -0.1, -1.0, -10.0, and -100.0. Comment on the accuracy.
*/

public class Loops {

    public static void main(String[] args) {
      Scanner in = new Scanner (System.in);

      choice();
    }


/**
 * Presents user with choice of question number and provides prompts and results
 *
 * @param does not contain any parameters
 * @return does not return a value.
 */

  public static void choice (){
    Scanner in = new Scanner (System.in);
    System.out.println("Which question from Chapter 7 are you looking at?");
    int choice = in.nextInt();

    if (choice == 3){
      System.out.println("What is the base of your exponential expression? Please use a double.");
      double base = in.nextDouble();

      System.out.println("What is the exponent of your exponential expression? Please use an integer.");
      int exp = in.nextInt();

      System.out.println("The result is: " + Power(base, exp));
    }

    if (choice == 4){
      System.out.println("For what integer would you like to generate a factorial?");
      System.out.println("The result is: " + Factorial(in.nextInt()));

    }

    if (choice == 5){
      /**
      System.out.println("Let's approximate e^x! What is the value of x?");
      int x = in.nextInt();
      System.out.println("Great! How many terms of the infinite series would you like to expand?");
      int terms = in.nextInt();
      */

      double i = 0.1;
      while (i <=100){ // accuracy decreases as the value of i increase
        Check(i, 50);
        i = i * 10;
      }

      i = -.01;
      while (i >= -100){ // accuracy decreases as the value of i decreases
        Check(i, 50);
        i = i * 10;
      }
    }
  }

/**
 * Evaluates an exponential expression, where the coefficient is 1.
 *
 * @param x is the base and n is the exponent of the exponential expression.
 * @return double based on the conditions that follow
 */

  public static double Power (double x, int n){
    double result = 1.0;

    if (x == 0.0 && n == 0){ // The case in which the base and exponent are zero
      System.out.println("Undefined");
      return -1.0;
    }

    if (x == 0.0){ // The case in which the base is zero
      return 0.0;
    }

    if (n == 0){ // The case in which the exponent is zero
      return 1.0;
    }

    while (n > 0){ // The case in which the exponent is positive
      result = result * x;
      n--;
    }

    while (n < 0){ // The case in which the exponent is negative
      result = result / x;
      n++;
    }

    return result;
  }

/**
 * Evaluates a factorial expression
 *
 * @param n is the integer for which a factorial is being calculated.
 * @return double based on the conditions that follow
 */

  public static double Factorial (int n){
    double result = 1;

    if (n == 0){ // The case in which n is zero, this n! = 1
      return 1.0;
    }

    while (n > 0){ // The case in which n is positive.
      result = result * (double) n;
      n--;
    }

    while (n < 0){ // The case in which n is negative; Roman factorial returned.
      result = result / (double) n;
      n++;
    }

    return result;
  }

  /**
   * Calculates the Taylor Series for e^x
   *
   * @param x is a double that represens the value of x and n is an integer representing the number of terms in the series.
   * @return double representing the calculation of the series.
   */

  public static double myexp (double x, int n){
    double term_num = 1.0;
    double term_den = 1.0;
    double prev_num;
    double prev_den;
    double result = 1.0;
    for(int i = 1; i < n; i++){
      prev_num = term_num;
      prev_den = term_den;

      term_num = term_num * x;
      term_den = term_den * i;

      result = result + (term_num/term_den);
    }

    return result;
  }

  /**
   * Checks the accuracy of the Taylor Series run through Java by displaying results in table form compared to Java's Math package. As the values of x get further from 1, positive and negative, the accuracy decreases.
   *
   * @param x is a double that represens the value of x and n is an integer representing the number of terms in the series.
   * @return does not return a value.
   */

  public static void Check(double x, int n){
    System.out.printf("%.1f \t %.16f \t %.16f", x, myexp(x, n), Math.exp(x));
    System.out.println();
  }
}
