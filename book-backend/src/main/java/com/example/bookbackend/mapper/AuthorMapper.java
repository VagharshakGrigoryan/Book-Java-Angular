package com.example.bookbackend.mapper;


import com.example.bookbackend.dtos.AuthorDto;
import com.example.bookbackend.entity.Author;
import com.example.bookbackend.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {

    private final BookRepository bookRepository;

    @Autowired
    public AuthorMapper(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Author dtoToAuthor(AuthorDto dto) {
        return new Author(
                dto.getId(),
                dto.getFirstName(),
                dto.getLastName(),
                dto.getBirthDate(),
                dto.getMemoir(),
                dto.getImageUrl(),
                (dto.getId() == null) ? null: bookRepository.findByAuthorId(dto.getId())
        );
    }

    public AuthorDto authorToDto(Author author) {
        return new AuthorDto(
                author.getId(),
                author.getFirstName(),
                author.getLastName(),
                author.getBirthDate(),
                author.getMemoir(),
                author.getImageUrl()
        );
    }
}
