package com.example.bookbackend.service;

import com.example.bookbackend.entity.Book;
import com.example.bookbackend.exception.ResourceNotFoundException;
import com.example.bookbackend.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public List<Book> getAllByAuthorId(Long id) {
        List<Book> books = bookRepository.findByAuthorId(id);
        if(books.isEmpty()){
            throw new ResourceNotFoundException("books", "authorId", id);
        }
        return books;
    }
}
