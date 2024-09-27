package de.supercode.thelibrary.services;

import de.supercode.thelibrary.entities.Book;
import de.supercode.thelibrary.repositories.BookRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookService {

    BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book){
        bookRepository.addBook(book);
    }

    public ArrayList<Book> getAllBooks(){
       return bookRepository.getAllBooks();
    }

    public ArrayList<Book> getABook(long id){
        return new ArrayList<Book>(List.of(bookRepository.getBook(id)));
    }

    public boolean updateBook(Book book){
        return bookRepository.updateBook(book);
    }

    public boolean deleteBook(long id){
        return bookRepository.deleteBook(id);
    }
}
