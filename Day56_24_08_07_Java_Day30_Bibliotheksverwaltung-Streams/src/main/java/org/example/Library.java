package org.example;

import com.sun.jdi.ObjectCollectedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books;
    private List<Member> members;

    // Konstruktoren, Getter und Setter

    public Library() {
        this.books = new ArrayList<Book>();
        this.members = new ArrayList<Member>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }




    // Methoden zum Hinzufügen von Büchern und Mitgliedern

    public void addBookInTheLibrary(Book book) {
        if (!books.contains(book)) books.add(book);
    }

    public void addMemberToTheLibrary(Member member) {
        if (!members.contains(member)) members.add(member);
    }

    //-----------------------



    // Ein Buch an ein Mitglied ausleihen.
    public void borrowBook(int memberId, String book) {
        Member member = getMember(memberId);
        member.borrowBook(getNotBorrowBook(book));
    }



    // Ein Buch zurückgeben.

    public void returnBook(int memberId, String book) {
        Member member = getMember(memberId);
        member.returnBook(getBook(book).getFirst());
    }




    // Aller Bücher eines bestimmten Genres ausgeben
    public void printAllListedBooksFromGanre(String genre) {
        books.stream()
               .filter(b -> b.getGenre().equals(genre))
               .forEach(System.out::println);
    }




    // Alle Bücher eines bestimmten Autors ausgeben.
    public void printAllListedAutors() {
        books.stream()
                .map(Book::getAuthor)
                .distinct()
                .forEach(System.out::println);
    }

    // Alle Bücher, die von einem bestimmten Mitglied ausgeliehen wurde anzeigen.
    public void printAllBorrowedBooks(int memberId) {
        Member member = getMember(memberId);
        member.getBorrowedBooks().forEach(System.out::println);
    }

    // Top 5 der aktuell meistgeliehenen Bücher
    public void printTop5BorrowedBooks() {
        // Count the number of times each book is borrowed using streams
        Map<String, Long> bookBorrowCount = members.stream()
                .flatMap(member -> member.getBorrowedBooks().stream()) // Flatten the list of borrowed books
                .collect(Collectors.groupingBy(Book::getTitle, Collectors.counting())); // Count borrows by title

        // Sort the entries by borrow count in descending order and limit to top 5
        List<Map.Entry<String, Long>> topFiveBooks = bookBorrowCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .toList();

        // Print the top 5 borrowed books
        System.out.println("Top 5 Borrowed Books:");
        for (int i = 0; i < topFiveBooks.size(); i++) {
            Map.Entry<String, Long> entry = topFiveBooks.get(i);
            System.out.println((i + 1) + ". " + entry.getKey() + " - Borrowed " + entry.getValue() + " times");

        }
    }

    // Durchschnittliches Veröffentlichungsjahr der Bücher

    public void printAvgReleasYeah() {
        int avgYear = (int) books.stream()
               .mapToInt(Book::getPublicationYear)
               .average()
               .orElse(0);

        System.out.println("Durchschnittliches Veröffentlichungsjahr: " + avgYear);
    }

    //---

    // Privat methods
    private Member getMember(int memberId) {
        Member member = members.stream()
                .filter(m -> m.getMemberId() == memberId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));
        return member;
    }

    private Book getNotBorrowBook(String book) {
        List<Book> books = getBook(book);
        if (!books.isEmpty()) {
            return books.stream()
                    .filter(b -> !b.isLoan())
                    .findFirst()
                    .orElseThrow(() -> new ObjectCollectedException("No available book"));
        }
        throw new ObjectCollectedException("Book not found");
    }

    private List<Book> getBook(String book) {
        return books.stream()
                .filter(b -> b.getTitle().equals(book))
                .collect(Collectors.toList());
    }

}
