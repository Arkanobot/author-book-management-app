package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import com.example.demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Controller for handling book-related HTTP requests.
 * Manages the book management interface and operations.
 */
@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    private final AuthorService authorService;

    @Autowired
    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    /**
     * Displays the list of all books.
     * @param model The model to add attributes to
     * @return The view name for the book list
     */
    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        model.addAttribute("content", "book/list");
        return "common/layout";
    }

    /**
     * Shows the form for creating a new book.
     * @param model The model to add attributes to
     * @return The view name for the book form
     */
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("authors", authorService.getAllAuthors());
        model.addAttribute("content", "book/form");
        return "common/layout";
    }

    /**
     * Processes the creation of a new book.
     * @param book The book data from the form
     * @param redirectAttributes Attributes for the redirect
     * @return Redirect to the book list
     */
    @PostMapping
    public String createBook(@ModelAttribute Book book, RedirectAttributes redirectAttributes) {
        bookService.saveBook(book);
        redirectAttributes.addFlashAttribute("success", "Book created successfully");
        return "redirect:/books";
    }

    /**
     * Shows the form for editing an existing book.
     * @param id The ID of the book to edit
     * @param model The model to add attributes to
     * @return The view name for the book form
     */
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookService.getBookById(id));
        model.addAttribute("authors", authorService.getAllAuthors());
        model.addAttribute("content", "book/form");
        return "common/layout";
    }

    /**
     * Processes the update of an existing book.
     * @param id The ID of the book to update
     * @param book The updated book data
     * @param redirectAttributes Attributes for the redirect
     * @return Redirect to the book list
     */
    @PostMapping("/update/{id}")
    public String updateBook(@PathVariable Long id, @ModelAttribute Book book, RedirectAttributes redirectAttributes) {
        book.setId(id);
        bookService.updateBook(id, book);
        redirectAttributes.addFlashAttribute("success", "Book updated successfully");
        return "redirect:/books";
    }

    /**
     * Deletes a book.
     * @param id The ID of the book to delete
     * @param redirectAttributes Attributes for the redirect
     * @return Redirect to the book list
     */
    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        bookService.deleteBook(id);
        redirectAttributes.addFlashAttribute("success", "Book deleted successfully");
        return "redirect:/books";
    }
} 