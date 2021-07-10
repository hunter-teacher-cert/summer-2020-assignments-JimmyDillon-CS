import java.io.*;
import java.util.*;


public class Bucket{
    private Person head;

    public Bucket(){
	     head = null;
    }

    public void add(Person added){
    	Person newPerson = added;

    	// first point the new node to the beginning
    	newPerson.setNext(head);

    	// point head to the new node
    	head = newPerson;

    }

    public String toString(){
    	String s = "< ";

    	Person tmp;
    	tmp = head;
    	while (tmp != null){
    	    s = s + tmp.getData()+ " ";
    	    // how can we now move tmp to the next node
    	    // this is the magic linked list idiom!!!!
    	    // this moves a pointer to the next node!!!
    	    // It's analagous to i=i+1 for an array (for loop)
    	    tmp = tmp.getNext();
    	}

    	s = s + ">";
    	return s;
    }

    public int length(){
    	int l = 0;

    	Person tmp;
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

    public void addFront(Person added){
      add(added);
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
    Return the value (not the Person) at index
    If index is invalid, do nothing.
*/

    public String get(int index){
      if(personAtIndex(index) != null){
        return personAtIndex(index).getData();
      }
      else{
        return null;
      }
    }

/**
    set (int index, String value)
    Set the Person at index to contain value
    If index is invalid, do nothing.
*/

    public void set(int index, String firstName, String lastName, String phoneNumber){
      if(personAtIndex(index) != null){
        personAtIndex(index).setData(firstName, lastName, phoneNumber);
      }
    }

/**
    personAtIndex(int index)
    Returns the Person at index
*/

  public Person personAtIndex(int index){
    Person tmp; // temporary node to run through list
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
    Insert a new Person containing value at index
    If index is invalid, do nothing.
*/

    public void insert(int index, Person added){
      if (index == 0){ // handle the base case of insert at the front
        addFront(added);
        return;
      }

      if (index > length()){
        return;
      }

      Person newPerson = added; // make a tmp node

      Person tmp = personAtIndex(index-1); // Set temp Person to Person prior to insert

      newPerson.setNext(tmp.getNext()); // New Person is linked to the Persons after it.

      tmp.setNext(newPerson); // insert
    }

/**
    search (String key)
    Returns the index of the first time key occurs in the list
    Returns -1 if key is not found
*/

    public int search(String key){
      int index = 0;
      while (index < length()){
        if(key.equals(personAtIndex(index).getLast())){
          return index;
        }
        index++;
      }
      return -1;
    }

    public String searchPhone(String key){
      int index = 0;
      while (index < length()){
        if(key.equals(personAtIndex(index).getPhone())){
          return personAtIndex(index).getData();
        }
        index++;
      }
      return null;
    }

/**
    remove (String key)
    Removes the Person at index from the list
    If index is invalid, do nothing.
*/

    public void remove(int index){
      if (index == 0){ // handle the base case of insert at the front
        head = head.getNext();
        return;
      }

      Person tmp = personAtIndex(index-1); // Set temp Person to Person prior to insert

      tmp.setNext(tmp.getNext().getNext()); // skip over the removed Person.
    }

}
