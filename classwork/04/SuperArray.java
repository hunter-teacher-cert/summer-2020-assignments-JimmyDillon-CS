public class SuperArray {
    private int[] data;
    private int numberElements;

    public SuperArray(){
      this.data = new int[10];
      this.numberElements = 0;
    }

    public SuperArray(int size){
      this.data = new int[size];
      this.numberElements = 0;
    }

    /**
    * This routine will add the parameter value to the end of the SuperArray (don’t forget to update numberElements). If there is no more room in the array do nothing.
    */
    public void add(int value){
      if (this.numberElements < this.data.length){
        this.data[numberElements] = value;
        this.numberElements++;
      }
    }

    /**
    * Return the value at location index from the array. If index is past the last element, return -1.
    */
    public int get(int index){
      return this.data[index];
    }

    /**
    * Return True if there are no elemets in the internal array, false otherwise.
    */

    public boolean isEmpty(){
      if (numberElements == 0) {
        return true;
      }
      else {
        return false;
      }
    }

    /**
    * Build and return a String with all the elements of the array in a printable form
    */

    public String toString(){
      String contents;
      contents = "[";

      for (int i = 0; i < this.numberElements; i++){
        contents = contents + this.data[i] + ", ";
      }
      contents = contents + "]";
      return contents;
    }
}
