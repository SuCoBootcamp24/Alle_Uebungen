package example.main;

import example.administration.peoples.Admin;
import example.administration.peoples.User;
import example.library.books.Book;
import example.library.Library;
import example.library.books.EBook;
import example.library.books.PrintetBook;

public class Main {
    public static void main(String[] args) {
        Library library1 = new Library();
        addEBooks(library1);
        addPrintetBooks(library1);
        library1.showBookList();
        library1.printBookDetails(library1.getBookList().get(0));

        System.out.println("----------");

        User user1 = new User("John Doe", "user@user.de", "Abc str. 123");
        Admin admin1 = new Admin("Admin Smith", "admin@admin.de", "Def str.");

        library1.setBookBorrowable(admin1, "The Great Gatsby");
        library1.borrowBook(user1, "The Great Gatsby");
        library1.returnBook(user1, "The Great Gatsby");



    }

    private static void addPrintetBooks(Library library) {
        library.addBook(new PrintetBook("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565", 1925, 0.5));
        library.addBook(new PrintetBook("To Kill a Mockingbird", "Harper Lee", "9780061120084", 1960, 0.4));
        library.addBook(new PrintetBook("1984", "George Orwell", "9780451524935", 1949, 0.3));
        library.addBook(new PrintetBook("Pride and Prejudice", "Jane Austen", "9780141439518", 1813, 0.6));
        library.addBook(new PrintetBook("The Catcher in the Rye", "J.D. Salinger", "9780316769488", 1951, 0.5));
    }

    private static void addEBooks(Library library) {
        library.addBook(new EBook("Digital Minimalism", "Cal Newport", "9780525536512", 2019, 1.2));
        library.addBook(new EBook("The Lean Startup", "Eric Ries", "9780307887894", 2011, 2.4));
        library.addBook(new EBook("Becoming", "Michelle Obama", "9781524763138", 2018, 3.6));
        library.addBook(new EBook("Sapiens", "Yuval Noah Harari", "9780062316097", 2015, 4.2));
        library.addBook(new EBook("Educated", "Tara Westover", "9780399590504", 2018, 2.8));
    }

}
