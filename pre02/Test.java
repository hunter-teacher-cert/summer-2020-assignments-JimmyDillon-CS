import java.util.Scanner;

/**
 * Trying out some stuff
 */
public class Test {

    public static void main(String[] args) {
      Scanner in = new Scanner(System.in);

      int inch = 2;
      double cm = 5.08;

      System.out.printf("%d inches is %f centimeters", inch, cm);

      //Throws run-time error because of an illegal format conversion
      //System.out.printf("%f inches is %d centimeters", inch, cm);
    }
}
