import java.util.Scanner;

/*
Write a program that converts a total number of seconds to hours, minutes, and seconds. It should (1) prompt the user for input, (2) read an integer from the keyboard, (3) calculate the result, and (4) use printf to display the output. For example, "5000 seconds = 1 hours, 23 minutes, and 20 seconds".
Hint: Use the modulus operator.
*/

public class Sec_Con {

    public static void main(String[] args) {
      Scanner in = new Scanner (System.in);

      System.out.println("How many seconds would you like me to convert?");

      Converter(in.nextInt());
    }

    public static void Converter(int s){
      int sec_in_hour = 60 * 60;
      int hours = s / sec_in_hour;
      int minutes = (s % 3600) / 60;
      int seconds = s % 60;
      System.out.printf("%d seconds = %d hours, %d minutes, and %d seconds", s, hours, minutes, seconds);
      System.out.println();
    }
}
