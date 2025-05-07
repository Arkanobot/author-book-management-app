package com.example.demo.service;

import com.example.demo.model.Author;
import com.example.demo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Service class for managing author-related business operations.
 * Handles CRUD operations and business logic for authors.
 */
@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    /**
     * Retrieves all authors with their associated books.
     * @return List of all authors with their books
     */
    @Transactional(readOnly = true)
    public List<Author> getAllAuthors() {
        return authorRepository.findAllAuthorsWithBooks();
    }

    /**
     * Retrieves a specific author by ID with their books.
     * @param id The ID of the author to retrieve
     * @return The author with their books
     */
    @Transactional(readOnly = true)
    public Author getAuthorById(Long id) {
        return authorRepository.findAuthorWithBooks(id);
    }

    /**
     * Saves a new author or updates an existing one.
     * @param author The author to save
     * @return The saved author
     */
    @Transactional
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    /**
     * Deletes an author by their ID.
     * @param id The ID of the author to delete
     */
    @Transactional
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
} 