package example.main;

import example.library.Book;
import example.library.Library;

public class Main {
    public static void main(String[] args) {
        Library library1 = new Library();
        library1.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "9780", 1960));
        library1.addBook(new Book("1984", "George Orwell", "9780", 1980));
        library1.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "9", 2000));

        library1.showBookList();
        library1.printBookDetails(library1.getBookList().get(0));

    }
}