package de.supercode.thelibrary.controller;

import de.supercode.thelibrary.entities.Book;
import de.supercode.thelibrary.services.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ArrayList<Book> getAllBooks(@RequestParam(required = false) Long bookid){
        if(bookid == null)
            return bookService.getAllBooks();
        else
            return bookService.getABook(bookid);
    }
    //?bookid=2 @RequestParams
//    @GetMapping("/{id}")
//    public Book getABook(@PathVariable long id){
//        return bookService.getABook(id);
//    }

//    @GetMapping("/book")
//    public Book getAnotherBook(@RequestParam(required = false) Long bookid){
//        System.out.println(bookid);
//        return bookService.getABook(0);
//    }

    @PostMapping
    public void addBook(@RequestBody Book book){
        bookService.addBook(book);
    }

    @PutMapping
    public boolean updateBook(@RequestBody Book book){
        return bookService.updateBook(book);
    }

    @DeleteMapping("/delete")
    public boolean deleteBook(@RequestParam Long bookid){
        if (bookid == null) return false;
        return bookService.deleteBook(bookid);
    }
}
