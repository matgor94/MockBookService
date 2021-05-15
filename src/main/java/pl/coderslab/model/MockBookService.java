package pl.coderslab.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MockBookService implements BookService{
    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public MockBookService(){
        books = new ArrayList<>();
        books.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel", "Helion", "programming"));
        books.add(new Book(2L, "51515855", "Grube wióry", "Rafał Pacześ", "MP", "novel"));
        books.add(new Book(3L, "5656879789", "Mikrokontrolery z rdzeniem ARM9: w przykładach", "Lucjan Bryndza", "BTC", "programming"));
    }

    @Override
    public List<Book> getAllBooks() {
        return books;
    }
    //4l bo w konstruktorze klas ustawilismy 3 pozycje
    private static Long nextId = 4L;
    @Override
    public void addBook(Book book) {
        book.setId(nextId++);
        books.add(book);
    }

    @Override
    public Optional<Book> getOnBook(Long id) {
        return books.stream()
                .filter(element -> element.getId().equals(id)).findFirst();
    }

    @Override
    public void deleteBook(Long id) {
        if(!getOnBook(id).isEmpty()){
            books.remove(this.getOnBook(id).get());
        }
    }

    @Override
    public void editBook(Book book) {
        if(this.getOnBook(book.getId()).isPresent()){
            int indexOf = books.indexOf(this.getOnBook(book.getId()).get());
            books.set(indexOf, book);
        }
    }


}
