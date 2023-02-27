package com.cgi.library.service;

import com.cgi.library.entity.Book;
import com.cgi.library.model.BookDTO;
import com.cgi.library.model.CheckOutDTO;
import com.cgi.library.repository.BookRepository;
import com.cgi.library.util.ModelMapperFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.util.List;
import java.util.UUID;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Page<BookDTO> getBooks() throws JsonProcessingException {
        ModelMapper modelMapper = ModelMapperFactory.getMapper();
        List<Book> books = bookRepository.findAll();

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        System.out.println("book0:"+books.get(0));
        String json="000";
        try {
            json = ow.writeValueAsString(books.get(0));
        }
        catch (JsonProcessingException e){
            System.out.println("ERROR:"+e.toString());
        }

        System.out.println("books list:"+books.toString());
        System.out.println("books json:"+json);
        return null;
    }

    public BookDTO getBook(UUID bookId) {
        Book book = bookRepository.getOne(bookId);
        return ModelMapperFactory.getMapper().map(book, BookDTO.class);
    }

    public UUID saveBook(BookDTO bookDTO) {
        ModelMapper modelMapper = ModelMapperFactory.getMapper();
        return bookRepository.save(modelMapper.map(bookDTO, Book.class)).getId();
    }

    public void deleteBook(UUID bookId) {
        bookRepository.deleteById(bookId);
    }
}
