package ru.mirea.books4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.mirea.books4.nonspring.BookService;

import javax.sql.DataSource;

@Configuration
public class BookConfig {

    private final DataSource ds;

    public BookConfig(DataSource ds) {
        this.ds = ds;
    }

    @Bean
    public BookService bookService() {
        BookService bookService = new BookService(ds);
        bookService.init(); // Создаем структуру БД при необходимости
        return bookService;
    }

    @Bean
    public BookRest bookRest() {
        return new BookRest(bookService());
    }
}
