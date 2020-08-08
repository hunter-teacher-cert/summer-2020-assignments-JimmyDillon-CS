public class PhoneBook{
  private Bucket[] buckets;
  private static int size;
  private static int entries;

  public PhoneBook(int size){
      buckets = new Bucket[size];
      this.size = size;
      entries = 0;
  }

/*
  Add a new entry to the phone book
*/
  public void add (Person newPerson){
      String last = newPerson.getLast();
      int hash = hashFunction(newPerson);
      if (buckets[hash] == null){
        Bucket newBucket = new Bucket();
        buckets[hash] = newBucket;
      }
      buckets[hash].add(newPerson);
      entries++;
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
      int index = buckets[hash].search(key);
      if (index > -1){
        buckets[hash].remove(index);
        entries--;
      } else{
        System.out.println("Result not found.");
      }
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

  public String reverseLookup (String phoneNumber){
    for (int i = 0; i < buckets.length ; i++) {
      if (buckets[i] != null){
        if (buckets[i].searchPhone(phoneNumber) != null){
          return buckets[i].searchPhone(phoneNumber);
        }
      }
    }
    return "No Phone Number Found.";
}

/*
    Creates a hash based on the last name of the person
*/
  public static int hashFunction(Person added){
      //System.out.println("in hashfunction");
      return hashFunction(added.getLast());
  }

  public static int hashFunction(String last){
      //System.out.println("in hash function for string");
      return last.hashCode()%size;
  }

}
