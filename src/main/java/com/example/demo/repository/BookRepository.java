package com.example.demo.repository;

import com.example.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Repository interface for managing Book entities.
 * Provides custom queries for fetching books with their associated authors.
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    /**
     * Finds a book by ID and eagerly loads its author.
     */
    @Query("SELECT b FROM Book b JOIN FETCH b.author WHERE b.id = ?1")
    Book findBookWithAuthor(Long id);

    /**
     * Retrieves all books and eagerly loads their authors.
     */
    @Query("SELECT b FROM Book b JOIN FETCH b.author")
    List<Book> findAllBooksWithAuthors();
} 