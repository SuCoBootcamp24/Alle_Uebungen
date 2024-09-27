package org.example;

import com.sun.jdi.ObjectCollectedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



public class MemberTest {

    Member testMember;
    Book testBook;
    @BeforeEach
    public void setUp() {
        this.testMember = new Member("Alice Backer", 1234);
        this.testBook = new Book("1984", "George Orwell","Test", 1);
    }
    @Test
    public void testBorrowBook() {
    this.testMember.borrowBook(this.testBook);
    assertEquals(this.testBook, this.testMember.getBorrowedBooks().get(0));
    assertTrue(this.testBook.isLoan());
    }

    @Test
    public void testBorrowBookWhenAlreadyBorrowed() {
        this.testMember.borrowBook(this.testBook);
        assertThrows(ObjectCollectedException.class, () -> {this.testMember.borrowBook(this.testBook);});
    }

    @Test
    public void testReturnBook() {

        this.testMember.getBorrowedBooks().add(this.testBook);
        this.testBook.setLoan(true);


        this.testMember.returnBook(this.testBook);
        assertTrue(this.testMember.getBorrowedBooks().isEmpty());
        assertFalse(this.testBook.isLoan());
    }

    @Test
    public void testReturnBookWhenNotBorrowed() {
        assertThrows(ObjectCollectedException.class, () -> {this.testMember.returnBook(this.testBook);});
    }


}