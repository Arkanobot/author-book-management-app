package com.example.demo.repository;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.dao.DataIntegrityViolationException;
import java.math.BigDecimal;
import java.time.LocalDate;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test class for BookRepository.
 * Tests CRUD operations and custom queries.
 */
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BookRepository bookRepository;

    private Author author;

    @BeforeEach
    void setUp() {
        author = new Author();
        author.setName("Test Author");
        author.setEmail("test@example.com");
        entityManager.persist(author);
        entityManager.flush();
    }

    @Test
    void whenSaveBook_thenBookIsSaved() {
        // Given
        Book book = new Book();
        book.setTitle("Test Book");
        book.setIsbn("1234567890");
        book.setPrice(new BigDecimal("29.99"));
        book.setAuthor(author);
        book.setPublicationDate(LocalDate.now());

        // When
        Book savedBook = bookRepository.save(book);

        // Then
        assertThat(savedBook.getId()).isNotNull();
        assertThat(savedBook.getTitle()).isEqualTo("Test Book");
        assertThat(savedBook.getAuthor()).isEqualTo(author);
    }

    @Test
    void whenSaveBookWithoutRequiredFields_thenThrowsException() {
        // Given
        Book book = new Book();
        // Not setting required fields (title, isbn, price, author)

        // When/Then
        assertThrows(DataIntegrityViolationException.class, () -> {
            bookRepository.save(book);
        });
    }

    @Test
    void whenFindBookWithAuthor_thenReturnsBookWithAuthor() {
        // Given
        Book book = new Book();
        book.setTitle("Test Book");
        book.setIsbn("1234567890");
        book.setPrice(new BigDecimal("29.99"));
        book.setAuthor(author);
        book.setPublicationDate(LocalDate.now());
        entityManager.persist(book);
        entityManager.flush();

        // When
        Book foundBook = bookRepository.findBookWithAuthor(book.getId());

        // Then
        assertThat(foundBook).isNotNull();
        assertThat(foundBook.getTitle()).isEqualTo("Test Book");
        assertThat(foundBook.getAuthor()).isNotNull();
        assertThat(foundBook.getAuthor().getName()).isEqualTo("Test Author");
    }

    @Test
    void whenFindAllBooksWithAuthors_thenReturnsAllBooks() {
        // Given
        Book book1 = new Book();
        book1.setTitle("Book 1");
        book1.setIsbn("1111111111");
        book1.setPrice(new BigDecimal("19.99"));
        book1.setAuthor(author);
        book1.setPublicationDate(LocalDate.now());
        entityManager.persist(book1);

        Book book2 = new Book();
        book2.setTitle("Book 2");
        book2.setIsbn("2222222222");
        book2.setPrice(new BigDecimal("29.99"));
        book2.setAuthor(author);
        book2.setPublicationDate(LocalDate.now());
        entityManager.persist(book2);
        entityManager.flush();

        // When
        var books = bookRepository.findAllBooksWithAuthors();

        // Then
        assertThat(books).hasSize(2);
        assertThat(books).extracting(Book::getTitle)
                .containsExactlyInAnyOrder("Book 1", "Book 2");
    }
} 