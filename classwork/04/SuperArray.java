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
      if (this.isFull()){
        this.grow();
      }
      data[numberElements] = value;
      numberElements++;
    }

/*
    This is a second version of add it will add an element at location index. If index is past the end of the array, do nothing,. Otherwise, shift down all the elements past index to create room and then insert value into the correct location. Don’t forget to grow the array as in the previous question if necessary.
*/

    public void add(int index, int value){
      if (data.length <= index){
        return;
      }
      if (this.isFull()){
        this.grow();
      }
      int [] tmpArray = new int[numberElements-index];
      int tmpIndex = 0;
      // Add ints after insert to a temp array
      for (int i = index; i < numberElements; i ++){
        tmpArray[tmpIndex] = data[i];
        tmpIndex++;
      }
      // insert the value at the index;
      this.data[index] = value;
      // Add ints from tmpArray back to data array
      int insertIndex = index + 1;
      for (int i = 0; i < tmpIndex; i++ ){
        data[insertIndex] = tmpArray[i];
        insertIndex++;
      }
      numberElements++;
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

    public boolean isEmpty (){
      if (numberElements == 0) {
        return true;
      }
      else {
        return false;
      }
    }

    public boolean isFull (){
      if (numberElements == data.length){
        return true;
      }
      else{
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

/*
    Removes an int at index.
*/

    public void remove (int index){
      if (data.length <= index){
        return;
      }
      if (this.isEmpty()){
        return;
      }
      for (int i = index; i < numberElements ; i++ ) {
        data[i] = data[i+1];
      }
      numberElements--;
    }

/*
    Grows the array by 50%
*/
    public void grow (){
      int[] newData = new int[data.length + data.length / 2];
      for (int i = 0; i < numberElements ; i++) {
        newData[i] = data[i];
      }
      data = newData;
    }

}
