package de.supercode;


public class MyLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addFirst(E data) {
        Node<E> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
        size++;
    }

    public void addLast(E data) {
        Node<E> newNode = new Node<>(data);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    public E removeFirst() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        E data = head.getData();
        head = head.getNext();
        if (head != null) {
            head.setPrev(null);
        } else {
            tail = null;
        }
        size--;
        return data;
    }

    public E removeLast() {
        if (tail == null) {
            throw new IllegalStateException("List is empty");
        }
        E data = tail.getData();
        tail = tail.getPrev();
        if (tail != null) {
            tail.setNext(null);
        } else {
            head = null;
        }
        size--;
        return data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printList() {
        Node<E> current = head;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    public void reverse() {
        Node<E> current = head;
        Node<E> temp = null;

        // Swap next and prev for all nodes of the list
        while (current != null) {
            temp = current.getPrev();
            current.setPrev(current.getNext());
            current.setNext(temp);
            current = current.getPrev();
        }

        // Before changing head, check for the cases like empty list and list with only one node
        if (temp != null) {
            head = temp.getPrev();
        }
    }

    public E getKthFromEnd(int k) {
        if (k > size || k <= 0) {
            throw new IllegalArgumentException("Invalid value of k: " + k);
        }

        Node<E> front = head;
        Node<E> back = head;

        // Move front k-1 steps ahead
        for (int i = 0; i < k - 1; i++) {
            if (front != null) {
                front = front.getNext();
            }
        }

        // Move both front and back until front reaches the end
        while (front != null && front.getNext() != null) {
            front = front.getNext();
            back = back.getNext();
        }

        return back.getData();
    }

    public int size() {
        return size;
    }

    // Additional methods can be implemented as needed
}
