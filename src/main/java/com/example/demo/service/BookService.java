package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Service class for managing book-related business operations.
 * Handles CRUD operations and business logic for books.
 */
@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * Retrieves all books with their associated authors.
     * @return List of all books with their authors
     */
    @Transactional(readOnly = true)
    public List<Book> getAllBooks() {
        return bookRepository.findAllBooksWithAuthors();
    }

    /**
     * Retrieves a specific book by ID with its author.
     * @param id The ID of the book to retrieve
     * @return The book with its author
     */
    @Transactional(readOnly = true)
    public Book getBookById(Long id) {
        return bookRepository.findBookWithAuthor(id);
    }

    /**
     * Saves a new book or updates an existing one.
     * @param book The book to save
     * @return The saved book
     */
    @Transactional
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    /**
     * Deletes a book by its ID.
     * @param id The ID of the book to delete
     */
    @Transactional
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public Book updateBook(Long id, Book bookDetails) {
        Book book = bookRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Book not found"));
        
        book.setTitle(bookDetails.getTitle());
        book.setIsbn(bookDetails.getIsbn());
        book.setDescription(bookDetails.getDescription());
        book.setPrice(bookDetails.getPrice());
        book.setPublicationDate(bookDetails.getPublicationDate());
        book.setAuthor(bookDetails.getAuthor());
        
        return bookRepository.save(book);
    }
} 