import java.math.*;
import java.util.*;

public class Craps{

  public static void main(String[] args) {
    Scanner in = new Scanner (System.in);

    System.out.println("How many rounds would you like to play?");
    int rounds = in.nextInt();

    int wins = 0;

    for(int i = 1; i <= rounds; i++){ // Set i to 1 so that round numbers display easily
      if (round()){
        System.out.println("You won Round " + i);
        wins++;
      }
      else{
        System.out.println("You lost Round " + i);
      }
    }
    System.out.println("You won " + wins + " rounds out of " + rounds + " (" + (double)wins / rounds * 100 + "%)"); // for simulating lots of games
  }

/**
Based on the number of sides of a fair die, it generates a random number by virtually rolling.

@ param sides is the integer number of sides of a fair die.
@ return a random number between 1 and the number of sides, incusive
*/

  public static int roll (int sides){
    Random random = new Random();

    int dieNum = random.nextInt(sides) + 1; // translate minimum up from zero to one and maximum up to the number of sides

    System.out.println("You rolled a " + dieNum);

    return dieNum;
  }

/**
Based on the number of dice and the number of sides of those dice, it totals the values found on the dice after n rolls.

@ param numDice is the number of dice and sides is the number of sides of those dice.
@ return the total of rolling n dice
*/

  public static int shoot(int numDice, int sides){
    int result = 0;
    for (int i = 0; i < numDice; i++){
      result = result + roll (sides);
    }
    System.out.println("Result: " + result);
    return result;
  }

/**
Based on the rules of Craps, it decides whether a person has won (true) or lost (false) a round of Craps.

@ param none
@ return the boolean expression representing a win or loss.
*/

  public static boolean round(){
    boolean win = true;
    int point = 0;
    int numDice = 2; // Craps is normally played with two dice
    int diceSides = 6; // The dice are normally six-sided.
    int result = shoot(numDice, diceSides);

    if(result == 2 || result == 3 || result == 12){
      win = false;
      System.out.println("Craps");
    }
    else if(result == 7 || result == 11){
      win = true;
      System.out.println("Natural");
    }
    else{
      point = result;
      System.out.println("Point is set to: " + point);
      result = shoot(numDice, diceSides);
      while (result != point && result !=7) {
        result = shoot(numDice, diceSides);
      }
      if (result == 7){
        win = false;
      }
    }

    return win;
  }
}
