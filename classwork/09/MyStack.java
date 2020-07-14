import java.util.*;
import java.io.*;

public class MyStack {
  
/*  
    Converts a String into a stack with each individual character the stack.
**/

  public static Stack <Character> parseStoC (String s){
    Stack<Character> charStack = new Stack<Character>();
    
    for (int i = 0; i < s.length(); i++){
      charStack.push(s.charAt(i));
    }
    
    return charStack;
  }

/*  
Converts a String with spaces into a stack with each individual word stored as a String in the stack
**/

  public static Stack <String> parseStoS (String s){
    Stack<String> stringStack = new Stack<String>();
    
    while(s.contains(" ")){
      stringStack.push(s.substring(0, s.indexOf(" ")));
      s = s.substring(s.indexOf(" ")+1, s.length());
    }
    
    stringStack.push(s);
    
    return stringStack;
  }

/*
    returns String s in reverse order by character or returns String s in reverse order by individual Strings if a space is included in the string.
**/
  
  public static String reverse(String s){
    String returnString = new String();
    
    Stack<Character> charStack = parseStoC(s);
    
    while (!charStack.empty()){
      returnString += charStack.pop();
    }
    
    return returnString;
  }
  
  public static Stack<String> reverse (Stack<String> stackString){
    
    Stack<String> revStack = new Stack<String>();
    
    while(!stackString.empty()){
      revStack.push(stackString.pop());
    }
    
    return revStack;
  }
  
/*
    Returns true or false depneding on whether s is a palindrome (can be read the same forward & backward)
**/

  public static boolean isPalindrome(String s){

    return s.equals(reverse(s));

  }
  
  public static boolean isPalindromeSpaces(String s){
  
    Stack<String> stringStack = parseStoS(s);

    String revString = stringStack.pop();
    
    while(!stringStack.empty()){
      revString = revString + " " + stringStack.pop();
    }

    return s.equals(revString);
    
  }

/*
    Returns true if the parentheses in the expression are matched accurately.
**/

  public static boolean parenCheck(String s){
    return true;
  }
  
  public static void main (String args[]){
    String s = "racecar is racecar";
    String t = "racecar is a racecar";
    
    System.out.println(isPalindromeSpaces(s));
    System.out.println(isPalindromeSpaces(t));
    
  }
  
}