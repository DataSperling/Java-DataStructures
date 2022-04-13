package io.DataSperling;


/**
 * Generic SinglyLinkedListNode class for LinkedList (singly linked list)
 *
 * @author DataSperling
 * @version 1.5
 */


public class SinglyLinkedListNode<T> {

    private T data;
    private SinglyLinkedListNode<T> next;

    /*
     * Constructs a new node with given data AND next reference
     *
     * @param data: the data to be stored in the node
     * @param next: reference to next node in list
     */
    SinglyLinkedListNode(T data, SinglyLinkedListNode<T> next) {
        this.data = data;
        this.next = next;
    }

    /*
     * Node constructor with only data field for adding to list
     *
     * @param data: the data to be added to the node
     */
    SinglyLinkedListNode(T data) {
        this(data, null);
    }

    /*
     * Getter for data
     *
     * @return: the data to return
     */
    T getData() {
        return data;
    }

    /*
     * Getter for next node
     *
     * @return: the next node in the list
     */
    SinglyLinkedListNode<T> getNext() {
        return next;
    }

    /*
     * Setter for next reference
     *
     * @param next: the next reference to be set
     */
    void setNext(SinglyLinkedListNode<T> next) {
        this.next = next;
    }
}
