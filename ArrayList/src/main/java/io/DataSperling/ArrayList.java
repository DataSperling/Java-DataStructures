package io.DataSperling;


import java.util.Arrays;
import java.util.NoSuchElementException;

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
            backingArray[0] = data;
        } else if (size + 1 <= INITIAL_CAPACITY) {
            T[] tempArray = (T[]) new Object[INITIAL_CAPACITY];
            tempArray[0] = data;
            for (int i=0; i<size; i++) {
                tempArray[i+1] = backingArray[i];
            }
            backingArray = tempArray;
        } else {
            int currentCapacity = INITIAL_CAPACITY;
            T[] tempArray = (T[]) new Object[calculateCurrentCapacity()];
            tempArray[0] = data;
            for (int i=0; i<size; i++) {
                tempArray[i+1] = backingArray[i];
            }
            backingArray = tempArray;
        }
        size++;
    }

    /*
    * Adds data at specified index
    *
    * @param index: the index at which to add the data
    * @throws: java.lang.IllegalArgumentException if data is null
    */
    public void addAtIndex(int index, T data) {}

    /*
    * Adds data to back of ArrayList
    *
    * @param data: the data to be added
    * @throws: java.lang.IllegalArgumentException if data is null
    */
    public void addToBack(T data) {
        if (data == null) {
            throw new IllegalArgumentException();
        }
        if (size + 1 <= backingArray.length) {
            backingArray[size] = data;
        } else {
            T[] tempArray = (T[]) new Object[calculateCurrentCapacity()];
            for (int i=0; i<size; i++) {
                tempArray[i] = backingArray[i];
            }
            tempArray[size] = data;
            backingArray = tempArray;

        }
        size++;
    }

    /*
    * Removes first element of array and returns its data to the user
    *
    * @throws: java.util.NoSuchElementException if list is empty
    * @return: the data that was at index = 0 of ArrayList
    */
    public T removeFromFront() {
        if (size == 0) {
            throw new NoSuchElementException("Error: List is empty");
        }
        T tempData = backingArray[0];
        if (size == 1) {
            backingArray[0] = null;
        } else {
            T[] tempArray = backingArray;
            for (int i=0; i<size; i++) {
                tempArray[i] = backingArray[i+1];
            }
            backingArray = tempArray;
        }
        size--;
        return tempData;
    }

    /*
    * Removes last element of ArrayList and returns its data to the user
    *
    * @throws: java.util.NoSuchElementException if list is empty
    * @return: the data that was at index = 0 of ArrayList
    */
    public T removeFromBack() {
        if (size == 0) {
            throw new NoSuchElementException("Error: List is empty");
        }
        T tempData = backingArray[size-1];
        backingArray[size-1] = null;
        size--;
        return tempData;
    }

    /*
    * helper method to calculate currentCapacity dynamically
    *
    * @param size: the integer size of the ArrayList (number occupied elements)
    * @return: the integer size of the current backingArray (capacity until resize is required)
    */
    private int calculateCurrentCapacity() {
        int currentCapacity = INITIAL_CAPACITY;
        while (currentCapacity <= size) {
            currentCapacity = currentCapacity * 2;
        }
        return currentCapacity;
    }

    /*
    * accessor method for backingArray.size
    *
    * @return: the integer size of tha backingArray
    */
    public int getSize() {
        return size;
    }

    /*
    * accessor method for backingArray
    * Object Array is cast to generic array: can cause class cast exception
    *
    * @return: the generic object backingArray
    * @ClassCastException: array is cast to "generic[]" from Object[]
    */
    public T[] getBackingArray() {
        return backingArray;
    }

}
