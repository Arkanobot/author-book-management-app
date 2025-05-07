package com.example.demo.service;

import com.example.demo.model.Author;
import com.example.demo.repository.AuthorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * Test class for AuthorService.
 * Tests business logic and exception handling.
 */
@ExtendWith(MockitoExtension.class)
public class AuthorServiceTest {

    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private AuthorService authorService;

    private Author author;

    @BeforeEach
    void setUp() {
        author = new Author();
        author.setName("Test Author");
        author.setEmail("test@example.com");
        author.setBiography("Test biography");
    }

    @Test
    void whenGetAllAuthors_thenReturnsAllAuthors() {
        // Given
        Author author2 = new Author();
        author2.setName("Another Author");
        author2.setEmail("another@example.com");
        when(authorRepository.findAllAuthorsWithBooks())
                .thenReturn(Arrays.asList(author, author2));

        // When
        List<Author> authors = authorService.getAllAuthors();

        // Then
        assertThat(authors).hasSize(2);
        assertThat(authors).extracting(Author::getName)
                .containsExactlyInAnyOrder("Test Author", "Another Author");
    }

    @Test
    void whenGetAuthorById_thenReturnsAuthor() {
        // Given
        when(authorRepository.findAuthorWithBooks(1L)).thenReturn(author);

        // When
        Author foundAuthor = authorService.getAuthorById(1L);

        // Then
        assertThat(foundAuthor).isNotNull();
        assertThat(foundAuthor.getName()).isEqualTo("Test Author");
    }

    @Test
    void whenSaveAuthor_thenAuthorIsSaved() {
        // Given
        when(authorRepository.save(any(Author.class))).thenReturn(author);

        // When
        Author savedAuthor = authorService.saveAuthor(author);

        // Then
        assertThat(savedAuthor).isNotNull();
        assertThat(savedAuthor.getName()).isEqualTo("Test Author");
        verify(authorRepository).save(author);
    }

    @Test
    void whenSaveAuthorWithInvalidData_thenThrowsException() {
        // Given
        Author invalidAuthor = new Author();
        when(authorRepository.save(any(Author.class)))
                .thenThrow(new DataIntegrityViolationException("Invalid data"));

        // When/Then
        assertThrows(DataIntegrityViolationException.class, () -> {
            authorService.saveAuthor(invalidAuthor);
        });
    }

    @Test
    void whenDeleteAuthor_thenAuthorIsDeleted() {
        // Given
        doNothing().when(authorRepository).deleteById(1L);

        // When
        authorService.deleteAuthor(1L);

        // Then
        verify(authorRepository).deleteById(1L);
    }
} 