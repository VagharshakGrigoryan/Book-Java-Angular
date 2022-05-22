package com.example.bookbackend.controller;

import com.example.bookbackend.exception.ResourceNotFoundException;
import com.example.bookbackend.model.Book;
import com.example.bookbackend.repository.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin( origins = "http://localhost:4200" )
@RestController
@RequestMapping( "/books" )
public class BookController {

	private final BookRepository bookRepository;

	public BookController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@GetMapping
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	@PostMapping
	public Book createBook(@RequestBody Book book) {
		return bookRepository.save(book);
	}

	@GetMapping( "/{id}" )
	public ResponseEntity<Book> getBookById(@PathVariable Long id) {
		Book book = bookRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Book not exist with id :" + id));
		return ResponseEntity.ok(book);
	}


	@PutMapping( "/{id}" )
	public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
		Book book = bookRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Book not exist with id :" + id));

		book.setTitle(bookDetails.getTitle());
		book.setLanguage(bookDetails.getLanguage());
		book.setPrice(bookDetails.getPrice());

		Book updateBook = bookRepository.save(book);
		return ResponseEntity.ok(updateBook);
	}

	@DeleteMapping( "/{id}" )
	public ResponseEntity<Map<String, Boolean>> deleteBook(@PathVariable Long id) {
		Book book = bookRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Book not exist with id :" + id));

		bookRepository.delete(book);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);

	}
}