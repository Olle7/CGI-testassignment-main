package com.cgi.library.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class FrontendController {
    @GetMapping("")
    public String MainPage() {
        return "main_page.html";
    }

    @GetMapping("/table_of_books")
    public String TableOfBooks() {
        return "table_of_books.html";
    }

    @GetMapping("/table_of_checkouts")
    public String TableOfCheckouts() {
        return "table_of_checkouts.html";
    }
}