public class Driver {

public static void main(String[] args) {

  Person jimmy = new Person ("Dillon", "Jimmy", "301-659-1072");
  Person hiral = new Person ("Patel", "Hiral", "443-603-5631");
  Person smith = new Person ("Smith", "John", "123-456-7890");
  Person jen = new Person ("Dillon", "Jen", "301-534-2345");

  Bucket bucket = new Bucket();
  PhoneBook book = new PhoneBook(256);

  System.out.println("Empty phone book.");
  book.printList();
  System.out.println();
  System.out.println("Adding four new entries:");
  book.add(jimmy);
  book.add(hiral);
  book.add(smith);
  book.add(jen);
  System.out.println();
  System.out.println("Printing updated phone book...");
  System.out.println();
  System.out.println("Finding Smith...");
  System.out.println();
  System.out.println(book.find("Smith"));
  System.out.println();
  System.out.println("Printing updated phone book...");
  System.out.println();
  book.printList();
  System.out.println();
  System.out.println("Removing Dillon...");
  book.remove("Dillon");
  System.out.println();
  System.out.println("Printing updated phone book...");
  System.out.println();
  book.printList();
  System.out.println();
  System.out.println("Reverse Lookup on 443-603-5631...");
  System.out.println(book.reverseLookup("443-603-5631"));
  }
}
