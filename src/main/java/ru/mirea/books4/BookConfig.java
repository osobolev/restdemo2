package ru.mirea.books4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.mirea.books4.nonspring.BookRepository;
import ru.mirea.books4.nonspring.BookService;

import javax.sql.DataSource;

@Configuration
public class BookConfig {

    private final DataSource ds;

    public BookConfig(DataSource ds) {
        this.ds = ds;
    }

    @Bean
    public BookRepository bookRepository() {
        BookRepository bookRepo = new BookRepository(ds);
        bookRepo.init(); // Создаем структуру БД при необходимости
        return bookRepo;
    }

    @Bean
    public BookService bookService() {
        return new BookService(bookRepository());
    }
}
