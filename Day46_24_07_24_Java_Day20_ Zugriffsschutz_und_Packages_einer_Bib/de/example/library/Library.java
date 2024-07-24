package example.library;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> bookList;

    public ArrayList<Book> getBookList() {
        return bookList;
    }

    public Library() {
        bookList = new ArrayList<>();
    }

    public void addBook(Book book) {
        if (!bookList.contains(book)) bookList.add(book);
    }

    public void showBookList() {
        for (Book book : bookList) {
            System.out.println(book.getTitle());
        }
    }

    public void printBookDetails(Book book) {
        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("ISBN: " + book.getIsbn());
        System.out.println("Year: " + book.getYear());
    }
}
