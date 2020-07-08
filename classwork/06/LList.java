import java.io.*;
import java.util.*;


public class LList{
    private Node head;

    public LList(){
	     head = null;
    }

    public void add(String data){
    	Node newnode = new Node(data);

    	// first point the new node to the beginning
    	newnode.setNext(head);

    	// point head to the new node
    	head = newnode;

    }

    public String toString(){
    	String s = "";

    	Node tmp;
    	tmp = head;
    	while (tmp != null){
    	    s = s + tmp.getData()+"-->";
    	    // how can we now move tmp to the next node
    	    // this is the magic linked list idiom!!!!
    	    // this moves a pointer to the next node!!!
    	    // It's analagous to i=i+1 for an array (for loop)
    	    tmp = tmp.getNext();
    	}

    	s = s + "null";
    	return s;
    }

    public int length(){
    	int l = 0;

    	Node tmp;
    	tmp = head;
    	while (tmp != null){

    	    l = l + 1;

    	    // how can we now move tmp to the next node
    	    // this is the magic linked list idiom!!!!
    	    // this moves a pointer to the next node!!!
    	    // It's analagous to i=i+1 for an array (for loop)
    	    tmp = tmp.getNext();
    	}

    	return l;
    }

    public void addFront(String value){
      add(value);
    }

/**
    isEmpty ()
    Returns true if the list is empty, false otherwise.
*/

    public boolean isEmpty(){
      return head == null; // If the head is null, there are no elements in the linked list.
    }

/**
    get(int index)
    Return the value (not the Node) at index
    If index is invalid, do nothing.
*/

    public String get(int index){
      if(nodeAtIndex(index) != null){
        return nodeAtIndex(index).getData();
      }
      else{
        return;
      }
    }

/**
    set (int index, String value)
    Set the Node at index to contain value
    If index is invalid, do nothing.
*/

    public void set(int index, String value){
      if(nodeAtIndex(index) != null){
        return nodeAtIndex(index).setData(value);
      }
    }

/**
    nodeAtIndex(int index)
    Returns the Node at index
*/

  public Node nodeAtIndex(int index){
    Node tmp; // temporary node to run through list
    tmp = head; // set it to the head

    int counter = 0; // counter

    while ((tmp !=null) && (counter < index)){
        tmp = tmp.getNext();
        counter++;
    }
    return tmp;
  }

/**
    insert (int index, String value)
    Insert a new Node containing value at index
    If index is invalid, do nothing.
*/

    public void insert(int index, String value){
    	// make new node
      Node newnode = new Node(value);
  	   // make a tmp node
      Node tmp;
      tmp = nodeAtIndex(index-1); //

      newnode.getNext(tmp.getNext()) // New Node is linked to the Nodes after it.

      temp.getNext(newnode); 

    	// move temp down the list until it's right BEFORE the insertion point

    	// insert
    }

    public void remove(int index){
  	// make a tmp node


  	// move tmp down the list until it's BEFORE the node we want to delete

  	// change tmp's next pointer to skip the node we are deletin
    }

}
