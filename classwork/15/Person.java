public class Person{
    private String lastName;
    private String firstName;
    private String phoneNumber;
    private Person nextPerson;

    public Person (){
        this.lastName = null;
        this.firstName = null;
        this.phoneNumber = null;
        this.nextPerson = null;
    }

    public Person (String lastName, String firstName, String phoneNumber){
        this.lastName = lastName;
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
        this.nextPerson = null;
    }

    public String getLast (){
        return lastName;
    }

    public String getFirst (){
        return firstName;
    }

    public String getPhone (){
        return phoneNumber;
    }

    public Person getNext (){
        return nextPerson;
    }

    public String getData (){
      return lastName+", "+firstName+" (" + phoneNumber+")";
    }

    public void setLast (String lastName){
        this.lastName = lastName;
    }

    public void setFirst(String firstName){
        this.firstName = firstName;
    }

    public void setPhone (String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public void setNext (Person next){
        nextPerson = next;
    }

    public void setData(String firstName, String lastName, String phoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

}
