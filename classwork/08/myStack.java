import java.io.*;
import java.util.*;

public class myStack{
  
  private LList stack;

  public myStack(){
    stack = new LList();
  }

  public void push(String data){
    stack.addFront(data); // only way to add data
  }

  public String pop(){
    String retValue = stack.get(0);
    stack.remove(0);
    return retValue;
  }

  public String top(){
    return stack.get(0);
  }

  public boolean isEmpty(){
      return stack.length() == 0;
  }

  public int size(){
    return stack.length();
  }
    
}
