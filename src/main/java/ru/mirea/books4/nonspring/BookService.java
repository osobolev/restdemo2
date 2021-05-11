package ru.mirea.books4.nonspring;

import java.util.List;
import java.util.Optional;

public class BookService {

    private final BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    public List<Book> getAllBooks() {
        return repo.getAllBooks();
    }

    private static void checkDetails(BookDetails details) {
        if (details.getAuthor() == null)
            throw new IllegalArgumentException("No author");
        if (details.getTitle() == null)
            throw new IllegalArgumentException("No title");
    }

    public Optional<Book> getBook(int id) {
        return repo.getBook(id);
    }

    public Book addBook(BookDetails details) {
        checkDetails(details);
        return repo.addBook(details);
    }

    public Optional<Book> updateBook(int id, BookDetails details) {
        checkDetails(details);
        return repo.updateBook(id, details);
    }

    public boolean deleteBook(int id) {
        return repo.deleteBook(id);
    }
}
