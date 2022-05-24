package com.example.bookbackend.controller;

import com.example.bookbackend.dtos.AuthorDto;
import com.example.bookbackend.entity.Author;
import com.example.bookbackend.payload.PostResponse;
import com.example.bookbackend.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@CrossOrigin( origins = "http://localhost:4200" )
@RestController
@RequestMapping("authors")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<Object> getAll() {
        List<EntityModel<?>> authors =  authorService.getAll().stream()
                .map(book -> EntityModel.of(book, linkTo(BookController.class).slash(book.getId()).withSelfRel()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(authors);
    }

    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody AuthorDto authorDto){
        Author author = this.authorService.create(authorDto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(author.getId())
                .toUri();

        return ResponseEntity.created(location).body(new PostResponse(author.getId(), location));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable("id") Long id) {
        AuthorDto author = this.authorService.getById(id);
        EntityModel<?> entityModel = EntityModel.of(author, linkTo(BookController.class).slash(id).withSelfRel());
        return ResponseEntity.ok(entityModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable("id") Long id) {
        this.authorService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
