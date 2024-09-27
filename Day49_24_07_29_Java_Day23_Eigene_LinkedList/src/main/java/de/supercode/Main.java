package de.supercode;

public class Main {

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        list.add(2);
        list.add(2);
        list.add(44);
        list.add(7);
        list.add(9);
        list.add(21);
        list.add(99);
        list.add(212);

        System.out.print("Original list: ");
        list.printList();

        list.reverse();
        System.out.print("Reversed list: ");
        list.printList();

        System.out.println("3rd element from end: " + list.getKthFromEnd(2));
    }

}