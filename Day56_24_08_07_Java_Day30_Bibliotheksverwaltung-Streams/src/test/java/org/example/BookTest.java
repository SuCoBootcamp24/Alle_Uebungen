package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class BookTest {

    Book testBook;

    @BeforeEach
    public void setUp() {
        this.testBook = new Book("1984", "George Orwell", "genre", 1999);
    }
    @Test
    public void CreateBook() {
    Book book = new Book("1984", "George Orwell", "genre", 1999);
        assertEquals("1984", book.getTitle());
        assertEquals("George Orwell", book.getAuthor());
        assertFalse(book.isLoan());
    }

}