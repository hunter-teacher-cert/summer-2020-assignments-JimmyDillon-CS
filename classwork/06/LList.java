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

}
