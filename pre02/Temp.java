import java.util.Scanner;

/*
Write a program that converts a temperature from Celsius to Fahrenheit. It should (1) prompt the user for input, (2) read a double value from the keyboard, (3) calculate the result, and (4) format the output to one decimal place. For example, it should display "24.0 C = 75.2 F".
Here is the formula. Be careful not to use integer division!
*/

public class Temp {

    public static void main(String[] args) {
      Scanner in = new Scanner (System.in);

      System.out.println("What is the temperature in degrees Fahrenheit?");

      F_to_C(in.nextInt());
    }

    public static void F_to_C(int f){
      double c = ((double)f - 32) * 5 / 9;
      System.out.printf("%d degrees Fahrenheit converts to %.2f degrees Celsius", f, c);
      System.out.println();
    }
}
