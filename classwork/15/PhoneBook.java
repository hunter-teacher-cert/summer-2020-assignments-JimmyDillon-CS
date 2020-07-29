public class PhoneBook{
  private LList[] buckets;
  private static int size;

  public PhoneBook(int size){
      buckets = new LList[size];
      this.size = size;
  }

/*
  Add a new entry to the phone book
*/
  public void add (Person newPerson){
      int hash = hashFunction(newPerson);
      if (buckets[hash] == null){
        LList newBucket = new LList();
        buckets[hash] = newBucket;
      }
      buckets[hash].add(newPerson);
  }

/*
    Find a person in the phone book by last name.
    Returns null if no entry is found.
*/
  public String find (String key){
      int hash = hashFunction(key);
      String result = key+" was found!";
      if (buckets[hash].search(key) == -1){
        return key+" was not found.";
      }
      else {
        return result;
      }
  }

/*
    Remove an entry from the phone book by last name.
*/
  public void remove (String key){
      int hash = hashFunction(key);
      // System.out.print("hash for Dillon is: ");
      // System.out.println(hash);
      int index = buckets[hash].search(key);
      // System.out.print("index for Dillon is: ");
      // System.out.println(index);
      buckets[hash].remove(index);
  }

/*
    Prints the entire phone book.
*/
  public void printList (){
      for (int i = 0; i < buckets.length ; i++) {
        if (buckets[i] != null){
          System.out.println(buckets[i].toString());
        }
      }
  }

/*
    Creates a hash based on the last name of the person
*/
  public static int hashFunction(Person added){
      return hashFunction(added.getLast());
  }

  public static int hashFunction(String last){
      return last.hashCode()%size;
  }

}
