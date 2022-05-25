package com.example.bookbackend.controller;

import com.example.bookbackend.entity.Author;
import com.example.bookbackend.exception.ResourceNotFoundException;
import com.example.bookbackend.repository.AuthorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Vagharhak Grigoryan
 */


@CrossOrigin( origins = "http://localhost:4200" )
@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository userRepository) {
        this.authorRepository = userRepository;
    }

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable(value = "id") Long authorId) throws ResourceNotFoundException {
        Author author = authorRepository.findById(authorId).orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + authorId));
        return ResponseEntity.ok().body(author);
    }

    @PostMapping
    public Author createAuthor(@RequestBody Author author) {
        return authorRepository.save(author);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(
            @PathVariable(value = "id") Long authorId, @Valid @RequestBody Author authorDetail)
            throws ResourceNotFoundException {

        Author author = authorRepository.findById(authorId).orElseThrow(() -> new ResourceNotFoundException("Author not found on :: " + authorId));
        author.setFirstName(authorDetail.getFirstName());
        author.setLastName(authorDetail.getLastName());
        author.setBirthDate(authorDetail.getBirthDate());
        author.setImageUrl(authorDetail.getImageUrl());
        final Author updateAuthor = authorRepository.save(author);
        return ResponseEntity.ok(updateAuthor);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteAuthor(@PathVariable(value = "id") Long authorId) throws Exception {
        Author author = authorRepository.findById(authorId).orElseThrow(() -> new ResourceNotFoundException("Author not found on :: " + authorId));
        authorRepository.delete(author);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}