import java.io.*;
import java.util.*;

public class Recursion {

   public static void main(String[] args) {
        System.out.println("Good News Everyone!");
        for (int i = 0; i < 11 ; i++ ) {
            System.out.printf(i+"! = %d\n", factorial(i) );
        }
        for (int i = 0; i < 11 ; i++) {
            System.out.printf("fib("+i+") = %d\n", fib(i) );
        }
   }

   public static int factorial(int n) {
        if((n == 0)||(n==1))
            return 1;
        else
            return n * factorial(n - 1);
   }
   public static int fib(int n) {
        if((n==0)||(n==1))
            return 1;
        else
            return fib(n - 1) + fib(n - 2);
   }

}
