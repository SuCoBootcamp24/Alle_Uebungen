package example.library;

import example.administration.LoanAdministration;
import example.administration.peoples.People;
import example.library.books.Book;
import example.library.books.PrintetBook;

import java.util.ArrayList;

public class Library {

    private LoanAdministration loanAdministration;
    private ArrayList<Book> bookList;

    public Library() {
        this.bookList = new ArrayList<>();
        this.loanAdministration = new LoanAdministration();
    }

    public void printBookDetails(Book book) {
        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("ISBN: " + book.getIsbn());
        System.out.println("Year: " + book.getYear());
    }


    public ArrayList<Book> getBookList() {
        return bookList;
    }



    public void addBook(Book book) {
        if (!bookList.contains(book)) bookList.add(book);
    }

    public void showBookList() {
        for (Book book : bookList) {
            System.out.println(book.getTitle());
        }
    }
    public Book findBookByAutor(String author) {
        for (Book book : bookList) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                return book;
            }
        }
        return null;
    }

    public void showAllBooksToBorrow() {
        for (Book book : bookList) {
            if (book.isCanBeBorrowed()) {
                System.out.println(book.getTitle());
            }
        }
    }

    public void borrowBook(People user, String title) {
        Book book = findBookByTitle(title);
        if (book!= null) {
            loanAdministration.borrowBook(user, book);
        } else {
            System.out.println("Book not found.");
        }
    }

    private Book findBookByTitle(String title) {
        for (Book book : bookList) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public void returnBook(People user, String title) {
        Book book = findBookByTitle(title);
        if (book!= null) {
            loanAdministration.returnBook(user, book);
        } else {
            System.out.println("Book not found.");
        }
    }

    public void setBookBorrowable(People user, String title) {
        Book book = findBookByTitle(title);
        if (book!= null) {
            loanAdministration.addBookToOffers(user, book);
        } else {
            System.out.println("Book not found.");
        }
    }
}
