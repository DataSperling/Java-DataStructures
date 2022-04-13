package io.DataSperling;



public class Main {

    static SinglyLinkedList webHistory = new SinglyLinkedList();

    public static void main(String[] args) {



        webHistory.addBefore("www.kxkxkxkx", "www.ededed.com");

        System.out.println(webHistory.getSize());
        System.out.println( webHistory.getHead().getData() );

    }


}
