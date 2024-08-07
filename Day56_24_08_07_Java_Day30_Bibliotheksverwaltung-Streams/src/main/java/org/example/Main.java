package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        createAndAddBooks(library);
        createAndAddMembers(library);


        library.printAllListedAutors();
        System.out.println();
        library.printAllListedBooksFromGanre("Dystopian");
        System.out.println();
        library.printAvgReleasYeah();
        System.out.println();




        library.borrowBook(101, "The Lord of the Rings");
        library.borrowBook(101, "To Kill a Mockingbird");
        library.borrowBook(102, "The Great Gatsby");
        library.borrowBook(102, "1984");
        library.borrowBook(103, "Moby Dick");
        library.borrowBook(104, "The Lord of the Rings");
        library.borrowBook(104, "To Kill a Mockingbird");
        library.borrowBook(105, "To Kill a Mockingbird");


        library.printAllBorrowedBooks(101);
        System.out.println();
        library.printTop5BorrowedBooks();


        library.returnBook(101, "The Lord of the Rings");




    }



    private static void createAndAddBooks(Library library) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 1925));
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 1925)); // Duplicate
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 1925)); // Duplicate
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 1925)); // Duplicate
        books.add(new Book("To Kill a Mockingbird", "Harper Lee", "Fiction", 1960));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee", "Fiction", 1960)); // Duplicate
        books.add(new Book("To Kill a Mockingbird", "Harper Lee", "Fiction", 1960)); // Duplicate
        books.add(new Book("To Kill a Mockingbird", "Harper Lee", "Fiction", 1960)); // Duplicate
        books.add(new Book("1984", "George Orwell", "Dystopian", 1949));
        books.add(new Book("Pride and Prejudice", "Jane Austen", "Romance", 1813));
        books.add(new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", 1937));
        books.add(new Book("The Catcher in the Rye", "J.D. Salinger", "Fiction", 1951));
        books.add(new Book("The Lord of the Rings", "J.R.R. Tolkien", "Fantasy", 1954));
        books.add(new Book("The Lord of the Rings", "J.R.R. Tolkien", "Fantasy", 1954)); // Duplicate
        books.add(new Book("The Lord of the Rings", "J.R.R. Tolkien", "Fantasy", 1954)); // Duplicate
        books.add(new Book("The Lord of the Rings", "J.R.R. Tolkien", "Fantasy", 1954)); // Duplicate
        books.add(new Book("The Lord of the Rings", "J.R.R. Tolkien", "Fantasy", 1954)); // Duplicate
        books.add(new Book("The Lord of the Rings", "J.R.R. Tolkien", "Fantasy", 1954)); // Duplicate
        books.add(new Book("The Lord of the Rings", "J.R.R. Tolkien", "Fantasy", 1954)); // Duplicate
        books.add(new Book("The Lord of the Rings", "J.R.R. Tolkien", "Fantasy", 1954)); // Duplicate
        books.add(new Book("Brave New World", "Aldous Huxley", "Dystopian", 1932));
        books.add(new Book("The Grapes of Wrath", "John Steinbeck", "Fiction", 1939));
        books.add(new Book("Jane Eyre", "Charlotte Brontë", "Romance", 1847));
        books.add(new Book("Animal Farm", "George Orwell", "Dystopian", 1945));
        books.add(new Book("Moby Dick", "Herman Melville", "Adventure", 1851));
        books.add(new Book("War and Peace", "Leo Tolstoy", "Historical", 1869));
        books.add(new Book("Crime and Punishment", "Fyodor Dostoevsky", "Crime", 1866));

        books.forEach(book -> library.addBookInTheLibrary(book));
    }

    public static void createAndAddMembers(Library library) {
        List<Member> members = new ArrayList<>();
        members.add(new Member("Alice Smith", 101));
        members.add(new Member("Bob Johnson", 102));
        members.add(new Member("Carol Davis", 103));
        members.add(new Member("David Brown", 104));
        members.add(new Member("Eva Green", 105));

        members.forEach(member -> library.addMemberToTheLibrary(member));

    }

}