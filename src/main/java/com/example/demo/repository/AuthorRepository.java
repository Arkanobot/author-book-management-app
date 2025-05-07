package com.example.demo.repository;

import com.example.demo.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Repository interface for managing Author entities.
 * Provides custom queries for fetching authors with their associated books.
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    /**
     * Finds an author by ID and eagerly loads their books.
     * Uses LEFT JOIN to include authors without any books.
     */
    @Query("SELECT a FROM Author a LEFT JOIN FETCH a.books WHERE a.id = ?1")
    Author findAuthorWithBooks(Long id);

    /**
     * Retrieves all authors and eagerly loads their books.
     * Uses LEFT JOIN to include authors without any books.
     */
    @Query("SELECT a FROM Author a LEFT JOIN FETCH a.books")
    List<Author> findAllAuthorsWithBooks();
} 