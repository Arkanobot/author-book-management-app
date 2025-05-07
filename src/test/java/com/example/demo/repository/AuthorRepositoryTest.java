package com.example.demo.repository;

import com.example.demo.model.Author;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.dao.DataIntegrityViolationException;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test class for AuthorRepository.
 * Tests CRUD operations and custom queries.
 */
@DataJpaTest
public class AuthorRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    void whenSaveAuthor_thenAuthorIsSaved() {
        // Given
        Author author = new Author();
        author.setName("John Doe");
        author.setEmail("john@example.com");
        author.setBiography("Test biography");

        // When
        Author savedAuthor = authorRepository.save(author);

        // Then
        assertThat(savedAuthor.getId()).isNotNull();
        assertThat(savedAuthor.getName()).isEqualTo("John Doe");
        assertThat(savedAuthor.getEmail()).isEqualTo("john@example.com");
    }

    @Test
    void whenSaveAuthorWithoutRequiredFields_thenThrowsException() {
        // Given
        Author author = new Author();
        // Not setting required fields (name and email)

        // When/Then
        assertThrows(DataIntegrityViolationException.class, () -> {
            authorRepository.save(author);
        });
    }

    @Test
    void whenFindAuthorWithBooks_thenReturnsAuthorWithBooks() {
        // Given
        Author author = new Author();
        author.setName("Jane Doe");
        author.setEmail("jane@example.com");
        entityManager.persist(author);
        entityManager.flush();

        // When
        Author foundAuthor = authorRepository.findAuthorWithBooks(author.getId());

        // Then
        assertThat(foundAuthor).isNotNull();
        assertThat(foundAuthor.getName()).isEqualTo("Jane Doe");
        assertThat(foundAuthor.getBooks()).isNotNull();
    }

    @Test
    void whenFindAllAuthorsWithBooks_thenReturnsAllAuthors() {
        // Given
        Author author1 = new Author();
        author1.setName("Author 1");
        author1.setEmail("author1@example.com");
        entityManager.persist(author1);

        Author author2 = new Author();
        author2.setName("Author 2");
        author2.setEmail("author2@example.com");
        entityManager.persist(author2);
        entityManager.flush();

        // When
        var authors = authorRepository.findAllAuthorsWithBooks();

        // Then
        assertThat(authors).hasSize(2);
        assertThat(authors).extracting(Author::getName)
                .containsExactlyInAnyOrder("Author 1", "Author 2");
    }
} 