package com.example.demo.controller;

import com.example.demo.model.Author;
import com.example.demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Controller for handling author-related HTTP requests.
 * Manages the author management interface and operations.
 */
@Controller
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    /**
     * Displays the list of all authors.
     * @param model The model to add attributes to
     * @return The view name for the author list
     */
    @GetMapping
    public String listAuthors(Model model) {
        model.addAttribute("authors", authorService.getAllAuthors());
        model.addAttribute("content", "author/list");
        return "common/layout";
    }

    /**
     * Shows the form for creating a new author.
     * @param model The model to add attributes to
     * @return The view name for the author form
     */
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("author", new Author());
        model.addAttribute("content", "author/form");
        return "common/layout";
    }

    /**
     * Processes the creation of a new author.
     * @param author The author data from the form
     * @param redirectAttributes Attributes for the redirect
     * @return Redirect to the author list
     */
    @PostMapping
    public String createAuthor(@ModelAttribute Author author, RedirectAttributes redirectAttributes) {
        authorService.saveAuthor(author);
        redirectAttributes.addFlashAttribute("success", "Author created successfully");
        return "redirect:/authors";
    }

    /**
     * Shows the form for editing an existing author.
     * @param id The ID of the author to edit
     * @param model The model to add attributes to
     * @return The view name for the author form
     */
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("author", authorService.getAuthorById(id));
        model.addAttribute("content", "author/form");
        return "common/layout";
    }

    /**
     * Processes the update of an existing author.
     * @param id The ID of the author to update
     * @param author The updated author data
     * @param redirectAttributes Attributes for the redirect
     * @return Redirect to the author list
     */
    @PostMapping("/update/{id}")
    public String updateAuthor(@PathVariable Long id, @ModelAttribute Author author, RedirectAttributes redirectAttributes) {
        author.setId(id);
        authorService.saveAuthor(author);
        redirectAttributes.addFlashAttribute("success", "Author updated successfully");
        return "redirect:/authors";
    }

    /**
     * Deletes an author.
     * @param id The ID of the author to delete
     * @param redirectAttributes Attributes for the redirect
     * @return Redirect to the author list
     */
    @PostMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        authorService.deleteAuthor(id);
        redirectAttributes.addFlashAttribute("success", "Author deleted successfully");
        return "redirect:/authors";
    }
} 