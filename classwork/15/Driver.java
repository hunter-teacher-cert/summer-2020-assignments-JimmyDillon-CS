public class Driver {

public static void main(String[] args) {

  Person jimmy = new Person ("Dillon", "Jimmy", "301-659-1072");
  Person hiral = new Person ("Patel", "Hiral", "443-603-5631");
  Person smith = new Person ("Smith", "John", "123-456-7890");
  Person jen = new Person ("Dillon", "Jen", "301-534-2345");

  LList bucket = new LList();
  PhoneBook book = new PhoneBook(256);

  book.add(jimmy);
  book.add(hiral);
  book.add(smith);
  book.add(jen);

  System.out.println(book.find("Smith"));

  book.printList();

  book.remove("Dillon");

  book.printList();

  }
}
