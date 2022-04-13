package io.DataSperling;

import java.util.NoSuchElementException;

/**
 * Generic SinglyLinkedList implementation with external node class
 * The methods; addBefore(T data, T newData), addAfter(T data, T newData) and
 * removeData(T data) are inefficient (O(n) worst case). Arrays offer better performance
 * when searching by value and HashMaps offer better overall performance at the cost of
 * memory.
 *
 * @author DataSperling
 * @version 1.5
 */

public class SinglyLinkedList<T> {

    private SinglyLinkedListNode<T> head;
    private SinglyLinkedListNode<T> tail;
    private int size;


    /*
     * Getter for size of LinkedList
     *
     * @return: number of nodes in LinkedList as int
     */
    public int getSize() {
        return this.size;
    }


    /*
     * Getter for head of LinkedList
     *
     * @return: the head of LinkedList
     */
    public SinglyLinkedListNode<T> getHead() {
        return head;
    }


    /*
     * Getter for tail of LinkedList
     *
     * @ return: the tail of LinkedList
     */
    public SinglyLinkedListNode<T> getTail() {
        return tail;
    }


    /*
     * Adds node to front in O(1) time
     *
     * @param: data: data to add to head of list
     * @throws: java.lang.IllegalArgumentException if data is null
     */
    public void addToFront(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Error: data can't be null");
        }
        SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<T>(data);

        if (size == 0) {
            head = newNode;
            tail = head;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
        size ++;
    }


    /*
     * Adds newData before given data in:
     * O(1) best case, O(n) worst case
     * *** THIS METHOD IS INEFFICIENT ***
     * Consider using a different data structure if using regularly
     * Arrays and HashMaps are suitable for random node access.
     *
     * @param data: data, before which we want to insert the newData
     * @param newData: data to be inserted
     * @throws: java.util.NoSuchElementException if data not found
     * @throws: java.util.IllegalArgumentException if data is null
     */
    public void addBefore(T data, T newData) {
        if (newData == null) {
            throw new IllegalArgumentException("Error: data can't be null");
        }

        if (size == 0) {
            throw new NoSuchElementException("Error: \"" + data + "\" not found");
        } else if (head.getData() == data) {
            addToFront(newData);
        } else {
            SinglyLinkedListNode<T> current = head;
            while (current.getNext() != null) {
                if (current.getNext().getData() == data) {
                    SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<>(newData);
                    newNode.setNext(current.getNext());
                    current.setNext(newNode);
                    size++;
                    return;
                }
                current = current.getNext();
            }
            if (current.getNext() == null) {
                throw new NoSuchElementException("Error: \"" + data + "\" not found");
            }
        }
    }


    /*
     * Adds newData after given data in:
     * O(1) best case, O(n) worst case
     * *** THIS METHOD IS INEFFICIENT ***
     * Consider using a different data structure if using regularly
     * Arrays and HashMaps are suitable for random node access.
     *
     * @param data: data, before which we want to insert the newData
     * @param newData: data to be inserted
     * @throws: java.util.NoSuchElementException if data not found
     * @throws: java.util.IllegalArgumentException if data is null
     */
    public void addAfter(T data, T newData) {
        if (newData == null) {
            throw new IllegalArgumentException("Error: data can't be null");
        }

        SinglyLinkedListNode<T> current = head;
        SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<>(newData);

        if (size == 0) {
            addToFront(newData);
            size++;
        } else if (tail.getData().equals(data) ) {
            tail.setNext(newNode);
            tail = newNode;
            size++;
        } else {
            while (current.getNext() != null) {
                if (current.getData().equals(data)) {
                    newNode.setNext(current.getNext());
                    current.setNext(newNode);
                    size++;
                    break;
                }
                current = current.getNext();
            }
        }
        if (current.getNext() == null) {
            throw new NoSuchElementException("Error: \"" + data + "\" not found");
        }
    }


    /*
     * Adds node to back in O(n) time
     *
     * @param data: the data added to back of LinkedList
     * @throws: java.lang.IllegalArgumentException if data is null
     */
    public void addToBack(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Error: data can't be null");
        }
        SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<>(data);

        if (size == 0) {
            head = newNode;
            tail = head;
        } else {
            SinglyLinkedListNode<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
            tail = newNode;
        }
        size ++;
    }


    /*
     * Removes first node in O(1) time
     *
     * @return: the data from the node removed
     * @throws: java.util.NoSuchElementException for empty list
     */
    public T removeFromFront() {
        if (size == 0) {
            throw new java.util.NoSuchElementException("Error: list is empty");
        }
        T data = head.getData();

        if (size == 1) {
            head = tail = null;
        } else {
            head = head.getNext();
        }
        size --;
        return data;
    }


    /*
     * Removes last node in O(n) time
     *
     * @return: the data from the node removed
     * @throws: java.util.NoSuchElementException for empty list
     */
    public T removeFromBack() {
        if (size == 0) {
            throw new NoSuchElementException("Error: list is empty");
        }
        T data = tail.getData();
        if (size == 1) {
            head = tail = null;
        } else {
            SinglyLinkedListNode<T> current = head;
            while (current.getNext().getNext() != null) {
                current = current.getNext();
            }
            current.setNext(null);
            tail =current;
        }
        size--;
        return data;
    }


    /*
     * Removes data passed and returns data to the caller
     * O(1) best case, O(n) worst case
     * *** THIS METHOD IS INEFFICIENT ***
     * Consider using a different data structure if using regularly
     * Arrays and HashMaps are suitable for random node access.
     *
     * @return: the data from the node removed
     * @throws: java.util.NoSuchElementException when data not found or if list is empty
     * @throws: java.util.IllegalArgumentException if data is null
     */
    public T removeData(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Error: data can't be null");
        }
        if (size == 0) {
            throw new NoSuchElementException("Error: list is empty");
        }

        SinglyLinkedListNode<T> current = head;
        T tempData = null;

        if (head.getData().equals(data) ) {
            tempData = head.getData();
            removeFromFront();
        } else if (tail.getData().equals(data) ) {
            tempData = tail.getData();
            removeFromBack();
        } else {
            while (current != null && current.getNext() != null ) {
                if (current.getNext().getData().equals(data) ) {
                    tempData = current.getNext().getData();
                    current.setNext(current.getNext().getNext() );
                    size--;
                    return tempData;
                }
                current = current.getNext();
            }
        }
        if (tempData == null) {
            throw new NoSuchElementException("Error: \"" + data + "\" not found");
        }
        return tempData;
    }


    /*
     * Returns string representation of list indicating size
     *
     * @ return: string representation of list
     */
    public String toString() {
        String output = "";
        SinglyLinkedListNode<T> current = head;
        while (current != null) {
            output += current.getData();
            if (current.getNext() != null) {
                output += " -> ";
            }
            current = current.getNext();
        }
        return "Linked List comprises " + size + " node(s): " + output;
    }
}
