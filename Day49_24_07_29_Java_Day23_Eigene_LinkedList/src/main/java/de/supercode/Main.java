package de.supercode;


public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.addFirst(1);
        list.addLast(2);
        list.addFirst(0);
        list.printList(); // Ausgabe: 0 1 2

        list.reverse();
        list.printList(); // Ausgabe: 2 1 0

        list.addLast(3);
        list.addLast(4);
        list.printList(); // Ausgabe: 2 1 0 3 4

        System.out.println(list.getKthFromEnd(2)); // Ausgabe: 3
        System.out.println(list.getKthFromEnd(5)); // Ausgabe: 2

        list.removeFirst();
        list.printList(); // Ausgabe: 1 0 3 4

        list.removeLast();
        list.printList(); // Ausgabe: 1 0 3
    }
}
