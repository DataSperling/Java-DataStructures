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

    }

}
