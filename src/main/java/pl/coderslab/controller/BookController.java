package pl.coderslab.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.model.Book;
import pl.coderslab.model.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping("")
    @ResponseBody
    List<Book> getListOfBooks(){
        return bookService.getAllBooks();
    }

    @PostMapping("")
    public void addBook(@RequestBody Book book){
        bookService.addBook(book);
    }

    @GetMapping("/{id}")
    public Book getOneBook(@PathVariable Long id){
        return this.bookService.getOnBook(id).orElseThrow(()-> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "nie znaleziono");
        });
    }
    @DeleteMapping("/{id}")
    public void deletBook(@PathVariable Long id){
        bookService.deleteBook(id);
    }

    @PutMapping("")
    @ResponseBody
    public void editBook(@RequestBody Book book){
        bookService.editBook(book);
    }

    @RequestMapping("/helloBook")
    public Book helloBook(){
        return new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel", "Helion", "programming");
    }
}
