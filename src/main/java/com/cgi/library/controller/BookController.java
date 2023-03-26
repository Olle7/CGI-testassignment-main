package com.cgi.library.controller;

import com.cgi.library.entity.Book;
import com.cgi.library.model.BookDTO;
import com.cgi.library.service.BookService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @ResponseBody
    @RequestMapping(value = "getBooks", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getBooks() throws JsonProcessingException {
        return bookService.getBooks();
    }

    @GetMapping(value = "getBook")
    public ResponseEntity<BookDTO> getBook(@RequestParam(value = "bookId") UUID bookId) {
        return ResponseEntity.ok(bookService.getBook(bookId));
    }

    @PostMapping(value = "saveBook")
    public ResponseEntity<String> saveBook(@RequestBody BookDTO book) {
        return ResponseEntity.ok(String.valueOf(bookService.saveBook(book)));
    }

    @DeleteMapping(value = "deleteBook")
    public ResponseEntity<String> deleteBook(@RequestParam(value = "bookId") UUID bookId) {
        System.out.println("DELETE RECIEVED");
        bookService.deleteBook(bookId);
        return ResponseEntity.ok("");
    }
}