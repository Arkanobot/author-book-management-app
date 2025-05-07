package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller for handling the home page and main navigation.
 * Provides the entry point to the application.
 */
@Controller
public class HomeController {

    /**
     * Displays the home page of the application.
     * @param model The model to add attributes to
     * @return The view name for the home page
     */
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("content", "home");
        return "common/layout";
    }
} 