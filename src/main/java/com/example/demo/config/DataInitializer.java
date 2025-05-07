package com.example.demo.config;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void run(String... args) {
        // Create authors
        Author author1 = new Author();
        author1.setName("J.K. Rowling");
        author1.setEmail("jkrowling@example.com");
        author1.setBiography("British author best known for the Harry Potter series");

        Author author2 = new Author();
        author2.setName("George R.R. Martin");
        author2.setEmail("grmartin@example.com");
        author2.setBiography("American novelist and short story writer");

        Author author3 = new Author();
        author3.setName("Stephen King");
        author3.setEmail("sking@example.com");
        author3.setBiography("American author of horror, supernatural fiction, suspense, and fantasy novels");

        authorRepository.saveAll(Arrays.asList(author1, author2, author3));

        // Create books
        Book book1 = new Book();
        book1.setTitle("Harry Potter and the Philosopher's Stone");
        book1.setIsbn("978-0747532743");
        book1.setDescription("The first book in the Harry Potter series");
        book1.setPrice(new BigDecimal("19.99"));
        book1.setPublicationDate(LocalDate.of(1997, 6, 26));
        book1.setAuthor(author1);

        Book book2 = new Book();
        book2.setTitle("A Game of Thrones");
        book2.setIsbn("978-0553103540");
        book2.setDescription("The first book in A Song of Ice and Fire series");
        book2.setPrice(new BigDecimal("24.99"));
        book2.setPublicationDate(LocalDate.of(1996, 8, 1));
        book2.setAuthor(author2);

        Book book3 = new Book();
        book3.setTitle("The Shining");
        book3.setIsbn("978-0385121675");
        book3.setDescription("A horror novel by Stephen King");
        book3.setPrice(new BigDecimal("14.99"));
        book3.setPublicationDate(LocalDate.of(1977, 1, 28));
        book3.setAuthor(author3);

        bookRepository.saveAll(Arrays.asList(book1, book2, book3));
    }
} 