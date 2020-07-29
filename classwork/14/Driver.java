import java.io.*;
import java.util.*;

public class Driver {

  public static void main (String[] args){
    BSTree t = new BSTree ();

    t.insert(10);
    t.insert(20);
    t.insert(5);
    t.insert(7);
    t.insert(8);
    t.insert(3);
    t.insert(17);
    t.insert(2);
    t.insert(4);
    t.insert(6);

    t.preorderTraverse();

    t.delete(5);


    //t.preorderTraverse();
    //t.postorderTraverse();
    t.preorderTraverse();
  }

}
