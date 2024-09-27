package org.example;

import com.sun.jdi.ObjectCollectedException;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private int memberId;
    private List<Book> borrowedBooks;

    // Konstruktoren, Getter und Setter


    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedBooks = new ArrayList<Book>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public void borrowBook(Book book) {
        if (!borrowedBooks.contains(book)) {
            borrowedBooks.add(book);
            book.setLoan(true);
        }
        else throw new ObjectCollectedException("Book is already borrowed");
    }

    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            book.setLoan(false);
        }
        else throw new ObjectCollectedException("Book isn´t Borrowed");
    }

    // Override

    @Override
    public String toString() {
        return STR."Member{name='\{name}\{'\''}, memberId=\{memberId}\{'}'}";
    }
}