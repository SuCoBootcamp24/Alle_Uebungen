package org.example;

import com.sun.jdi.ObjectCollectedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



public class LibraryTest {

    Book book;
    Member member;
    Library library;

    @BeforeEach
    public void setUp() {
        this.book = new Book("Book Title", "Book Author", "Genre", 1954);
        this.member = new Member("Alice Backer", 1234);
        this.library = new Library();
    }

    @Test
    public void addBookInTheLibrary() {
        this.library.addBookInTheLibrary(book);

        assertEquals(1, this.library.getBooks().size());
        assertTrue(this.library.getBooks().contains(book));
    }

    @Test
    public void addMemberToTheLibrary() {
        this.library.addMemberToTheLibrary(member);

        assertEquals(1, this.library.getMembers().size());
        assertTrue(this.library.getMembers().contains(member));
    }

    @Test
    public void addExistMemberToTheLibrary() {
        this.library.addMemberToTheLibrary(member);
        assertThrows(IllegalArgumentException.class, () -> {this.library.addMemberToTheLibrary(member);});
    }

    @Test
    public void borrowBook() {
        this.library.addBookInTheLibrary(book);
        this.library.addMemberToTheLibrary(member);

        this.library.borrowBook(member.getMemberId(), this.book.getTitle());

        assertEquals(1, this.member.getBorrowedBooks().size());
        assertTrue(this.member.getBorrowedBooks().contains(book));
        assertTrue(book.isLoan());
    }

    @Test
    public void borrowBookWithNotExistMember() {
        this.library.getBooks().add(this.book);
        assertThrows(IllegalArgumentException.class, () -> {this.library.borrowBook(9999, this.book.getTitle());});
    }

    @Test
    public void borrowBookThatNotExist() {
        assertThrows(IllegalArgumentException.class, () -> {this.library.borrowBook(member.getMemberId(), "NonExistentBook");});
    }

    @Test
    public void borrowBookThatIsAllReadyLoan() {
        this.library.addBookInTheLibrary(book);
        this.library.addMemberToTheLibrary(member);

        this.book.setLoan(true);

        assertThrows(ObjectCollectedException.class, () -> {this.library.borrowBook(member.getMemberId(), this.book.getTitle());});
    }

    @Test
    public void returnBorrowBook() {
        this.library.addBookInTheLibrary(book);
        this.library.addMemberToTheLibrary(member);

        this.library.borrowBook(member.getMemberId(), this.book.getTitle());
        this.library.returnBorrowBook(member.getMemberId(), this.book.getTitle());

        assertEquals(0, this.member.getBorrowedBooks().size());
        assertFalse(book.isLoan());
    }

    @Test
    public void returnBorrowBookThatNotBorrowed() {
        assertThrows(IllegalArgumentException.class, () -> {this.library.returnBorrowBook(member.getMemberId(), this.book.getTitle());});
    }


}