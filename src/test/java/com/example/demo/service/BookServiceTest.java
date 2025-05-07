package com.example.demo.service;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * Test class for BookService.
 * Tests business logic and exception handling.
 */
@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    private Book book;
    private Author author;

    @BeforeEach
    void setUp() {
        author = new Author();
        author.setName("Test Author");
        author.setEmail("test@example.com");

        book = new Book();
        book.setTitle("Test Book");
        book.setIsbn("1234567890");
        book.setPrice(new BigDecimal("29.99"));
        book.setAuthor(author);
        book.setPublicationDate(LocalDate.now());
    }

    @Test
    void whenGetAllBooks_thenReturnsAllBooks() {
        // Given
        Book book2 = new Book();
        book2.setTitle("Another Book");
        book2.setIsbn("0987654321");
        book2.setPrice(new BigDecimal("19.99"));
        book2.setAuthor(author);
        when(bookRepository.findAllBooksWithAuthors())
                .thenReturn(Arrays.asList(book, book2));

        // When
        List<Book> books = bookService.getAllBooks();

        // Then
        assertThat(books).hasSize(2);
        assertThat(books).extracting(Book::getTitle)
                .containsExactlyInAnyOrder("Test Book", "Another Book");
    }

    @Test
    void whenGetBookById_thenReturnsBook() {
        // Given
        when(bookRepository.findBookWithAuthor(1L)).thenReturn(book);

        // When
        Book foundBook = bookService.getBookById(1L);

        // Then
        assertThat(foundBook).isNotNull();
        assertThat(foundBook.getTitle()).isEqualTo("Test Book");
        assertThat(foundBook.getAuthor()).isEqualTo(author);
    }

    @Test
    void whenSaveBook_thenBookIsSaved() {
        // Given
        when(bookRepository.save(any(Book.class))).thenReturn(book);

        // When
        Book savedBook = bookService.saveBook(book);

        // Then
        assertThat(savedBook).isNotNull();
        assertThat(savedBook.getTitle()).isEqualTo("Test Book");
        verify(bookRepository).save(book);
    }

    @Test
    void whenSaveBookWithInvalidData_thenThrowsException() {
        // Given
        Book invalidBook = new Book();
        when(bookRepository.save(any(Book.class)))
                .thenThrow(new DataIntegrityViolationException("Invalid data"));

        // When/Then
        assertThrows(DataIntegrityViolationException.class, () -> {
            bookService.saveBook(invalidBook);
        });
    }

    @Test
    void whenUpdateBook_thenBookIsUpdated() {
        // Given
        Book updatedBook = new Book();
        updatedBook.setTitle("Updated Book");
        updatedBook.setIsbn("1234567890");
        updatedBook.setPrice(new BigDecimal("39.99"));
        updatedBook.setAuthor(author);
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));
        when(bookRepository.save(any(Book.class))).thenReturn(updatedBook);

        // When
        Book result = bookService.updateBook(1L, updatedBook);

        // Then
        assertThat(result).isNotNull();
        assertThat(result.getTitle()).isEqualTo("Updated Book");
        verify(bookRepository).save(any(Book.class));
    }

    @Test
    void whenDeleteBook_thenBookIsDeleted() {
        // Given
        doNothing().when(bookRepository).deleteById(1L);

        // When
        bookService.deleteBook(1L);

        // Then
        verify(bookRepository).deleteById(1L);
    }
} 