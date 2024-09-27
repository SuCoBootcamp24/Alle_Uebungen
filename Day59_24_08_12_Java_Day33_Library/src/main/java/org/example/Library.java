package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<Loan> loans = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void loanBook(Book book, Date startDate, Date endDate) {
        loans.add(new Loan(book, startDate, endDate));
    }

    // 1. Übung
    public List<Book> getBooksSortedByPublicationYear() {
        return books.stream()
                .sorted(Comparator.comparingInt(Book::getPublicationYear))
                .collect(Collectors.toList());
    }

    // 2. Übung
    public List<Author> getAuthorsSortedByBirthYear() {
        return books.stream()
                .flatMap(book -> book.getAuthors().stream())
                .distinct()
                .sorted(Comparator.comparingInt(Author::getBirthYear))
                .collect(Collectors.toList());

    }

    // 3. Übung
    public List<Book> filterBooksByPageCount(int minPages, int maxPages) {
        return books.stream()
                .filter(book -> book.getPages() > minPages && book.getPages() < maxPages)
                .collect(Collectors.toList());
    }

    // 4. Übung
    public Map<Author, List<Book>> groupBooksByAuthor() { //hilfe mit ki  ((kann man hier auch nur titel und jahr des buches in die liste soeichern?
        return books.stream()
                .flatMap(book -> book.getAuthors().stream()
                        .map(author -> new AbstractMap.SimpleEntry<>(author, book))
                )
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.mapping(Map.Entry::getValue, Collectors.toList())));

    }

    // 5. Übung
    public Optional<Author> getOldestAuthor() {  //???????
        return books.stream()
                .flatMap(book -> book.getAuthors().stream())
                .max(Comparator.comparingInt(Author::getBirthYear));
    }

    // 6. Übung
    public List<Book> getBooksByTitleKeyword(String keyword) {
        return books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    /*
    // 7. Übung
    public List<Book> getMostLoanedBooks() { // ??????????? WARUM????
        var xy = loans.stream()
                .map(loan -> loan.getBook)
                .collect(Collectors.groupingBy(book -> book, Collectors.counting()))
                .sorted()
                .
    }
     */

    // 8. Übung
    public Map<Book, Long> getLoanCountPerBook() {
        return null;
    }

    // 9. Übung
    public List<Book> getBooksLoanedByAuthor(Author author) {
        return null;
    }

    // 10. Übung
    public double getAverageLoanDuration() {
        return 0.0;
    }

    // Bonus: 11. Übung
    public String getMostPopularAuthorByBorrowedBooksCount() {
        return null;
    }

    // Alle Bücher mit mind 200 seiten
    public void excersise() {
        var result = books.stream()
                .filter(book -> book.getPages() > 200)
                .map(book -> book.getPublicationYear())
                .collect(Collectors.toSet());

        //Titel aller bücher mit mehr als einem Autor
        var result2 = books.stream()
                .filter(book -> book.getAuthors().size() >= 2)
                .map(book -> book.getTitle())
                .collect(Collectors.toList());


        var result3 = books.stream()
                .filter(book -> book.getAuthors().size() > 1)
                .mapToInt(book -> book.getTitle().length())
                .average()
                .orElse(0.0);


        var result4 = books.stream()
                .flatMap(book -> book.getAuthors().stream())
                .collect(Collectors.toList());


        var result5 = books.stream()
                .flatMap(book -> book.getAuthors().stream())
                .mapToInt(author -> author.getBirthYear())
                .average()
                .orElse(0.0);

        var result6 = books.stream()
                .collect(Collectors.groupingBy(book -> book.getPublicationYear()));


        var result7 = books.stream()
                .collect(Collectors.groupingBy(
                        book -> book.getPublicationYear(),
                        Collectors.averagingInt(book -> book.getPages())
                        ));

        var result8 = books.stream()
                .collect(Collectors.groupingBy(
                        Book::getPublicationYear,
                        Collectors.averagingInt(Book::getPages)
                        ))
                .entrySet().stream()
                .max(Comparator.comparingDouble(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse(null);
    }
}