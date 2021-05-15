package pl.coderslab.model;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getAllBooks();
    void addBook(Book book);
    Optional<Book> getOnBook(Long id);
    void deleteBook(Long id);
    void editBook(Book book);

}
