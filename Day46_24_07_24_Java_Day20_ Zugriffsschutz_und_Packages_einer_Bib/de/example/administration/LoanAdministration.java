package example.administration;

import example.administration.peoples.People;
import example.library.books.Book;
import example.library.books.PrintetBook;

import java.util.ArrayList;

public class LoanAdministration {





    public void borrowBook(People user, Book book) {
            PrintetBook printetBook = getPrintetBook(book);
            if (printetBook.isBorrowed() || !printetBook.isCanBeBorrowed() ) System.out.println("The book is not to borrowed or already borrowed.");
            else if (user.getRole() == Role.USER) {
                printetBook.setBorrowed(true);
                user.getBORROWED_LIST().add(book);
                System.out.println("The book has been borrowed by " + user.getName() + ".");
            }

    }

    public void returnBook(People user, Book book) {
        PrintetBook printetBook = getPrintetBook(book);
        if (!printetBook.isBorrowed() && !user.getBORROWED_LIST().contains(book)) System.out.println("The book is not borrowed.");
        else {
            printetBook.setBorrowed(false);
            user.getBORROWED_LIST().remove(book);
            System.out.println("The book has been returned by " + user.getName() + ".");
        }
    }

    public void addBookToOffers(People user, Book book) {
        if (user.getRole() == Role.ADMIN) {
            PrintetBook printetBook = getPrintetBook(book);
                printetBook.setCanBeBorrowed(true);
                System.out.println("The book has been added to the offers.");
        } else System.out.println("You are not an administrator.");
    }

    private PrintetBook getPrintetBook(Book book) {
        if (book instanceof PrintetBook) return (PrintetBook) book;
        System.out.println("The book is not a printet book.");
        return null;
    }

    public void removeBookFromOffers(People user, Book book) {
        if (user.getRole() == Role.ADMIN) {
            PrintetBook printetBook = getPrintetBook(book);
                printetBook.setCanBeBorrowed(false);
                System.out.println("The book has been removed from the offers.");
        } else System.out.println("You are not an administrator.");
    }
}
