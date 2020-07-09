import java.io.*;
import java.util.*;

public class ExceptionDriver {
  public static void main(String[] args) {

    //int[] a = new int[5];
    //a[10] = 100;
    //System.out.println( 4 % 0 );
    //Node n = null;
    //n.setData("hello");


    LList g = new LList();

    try {
      g.addFront(null);
    }
    catch ( IllegalArgumentException mikez ) {
      mikez.printStackTrace();
      System.out.println("Element not added");
    }

    try {
      g.addFront("everyone!");
      g.addFront("news!");
      g.addFront("good!");
    }
    catch ( IllegalArgumentException e ) {
      System.out.println("Element not added");
    }

    System.out.println(g);



  }//main()
}//class ExceptionDriver

class LList {

  private Node front;
  private int length;

  public LList() {
    front = null;
    length = 0;
  }//default constructor

  public String toString() {
    Node curr = front;
    String s = "<";
    while (curr != null) {
      s+= " ";
      s+= curr.getValue();
      curr = curr.getNext();
    }//while curr
    s+= " >";
    return s;
  }//toString

  public int length() {
    // int len = 0;
    // Node curr = front;
    // while (curr.getNext() != null) {
    //   len++;
    //   curr = curr.getNext();
    // }//while curr
    // return len;
    return length;
  }//length

  public void addFront(String value) {
    Node n = new Node(value);
    n.setNext(front);
    front = n;
    length++;
  }//addFront

  public boolean isEmpty() {
    return front == null;
  }//isEmpty

  public String get(int index) {

    Node curr = front;
    while (curr != null) {
      if (index == 0)
        return curr.getValue();

      curr = curr.getNext();
      index--;
    }//while curr

    return null;
  }//end get

  public void set(int index, String value) {
    Node curr = front;
    while (curr != null) {
      if (index == 0)
        curr.setData(value);
      curr = curr.getNext();
      index--;
    }//while curr

  }//end set

  public void insert(int index, String value) {

    if (index == 0) {
      addFront(value);
      return;
    }//insert 0

    Node n = new Node(value);
    Node curr = front;

    while (curr != null) {
      if (index == 1) {
        n.setNext(curr.getNext());
        curr.setNext(n);
        length++;
        return;
      }
      curr = curr.getNext();
      index--;
    }
  }//insert

  public int search(String key) {

    Node curr = front;
    int index = 0;

    while (curr != null) {
      if ( curr.getValue().equals(key) )
        return index;
      curr = curr.getNext();
      index++;
    }//while curr
    return -1;
  }//search

  public void remove(int index) {

    if ( front == null )
      return;

    Node curr = front;

    if (index == 0) {
      front = front.getNext();
      curr.setNext(null);
      length--;
      return;
    }

    while (curr != null) {

      if (index == 1) {
        Node removedNode = curr.getNext();
        curr.setNext( removedNode.getNext() );
        removedNode.setNext(null);
        length--;
        return;
      }
      curr = curr.getNext();
      index--;
    }//while curr
  }//remove

}

class Node {

  private String name;
  private Node next;

  public Node() {
    name = "";
    next = null;
  }//default constructor

  public Node(String value) {

    name = value;
    next = null;
  }//constructor(vale)

  public Node(String value, Node next) {
    name = value;
    this.next = next;
  }//constructor(value, next)

  public void setData(String value) {
    name = value;
  }//setData

  public void setNext(Node n) {
    next = n;
  }//setNext

  public String getValue() {
    return name;
  }//end getValue

  public Node getNext() {
    return next;
  }//getNext

  public String toString() {
    return name;
  }//toString

}//class Node
