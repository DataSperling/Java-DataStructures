package io.DataSperling;

public class ArrayList<T> {

    /*
    * the initial capacity of the ArrayList
    */
    public static final int INITIAL_CAPACITY = 11  ;

    private T[] backingArray;
    private int size;

    /*
    * Constructor for ArrayList using generic object cast as an array
    */
    public ArrayList() {
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
    }

    /*
    * Adds data to the front of the list
    *
    * @param data: the data to be added
    * @throws: java.lang.IllegalArgumentException if data is null
     */
    public void addToFront(T data) {

        if (data == null) {
            throw new IllegalArgumentException("Error, can't add null data to ArrayList");

        }
        if (size == 0) {
            backingArray[1] = data;
        } else if (size + 1 <= INITIAL_CAPACITY) {
            System.out.println("add to front and shift to right");
            T[] tempArray = (T[]) new Object[INITIAL_CAPACITY];
            tempArray[0] = data;
            for (int i=1; i<=size; i++) {
                tempArray[i] = backingArray[i];
                backingArray = tempArray;
            }
        } else {
            System.out.println("regrow array, add to front, copy data");
        }
        size++;
    }

    public int getSize() {
        return size;
    }

    public T[] getBackingArray() {
        return backingArray;
    }





}
