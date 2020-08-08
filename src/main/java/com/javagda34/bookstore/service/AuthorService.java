package com.javagda34.bookstore.service;

import com.javagda34.bookstore.model.Author;
import com.javagda34.bookstore.model.dto.CreateAuthorDto;
import com.javagda34.bookstore.model.mapper.AuthorMapper;
import com.javagda34.bookstore.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public boolean createAuthor(CreateAuthorDto authorDto) {
        if (!authorRepository.existsByNameAndLastNameAndBirthDate( //jeśli nie istnieje rekord
                authorDto.getFirstName(),
                authorDto.getLastName(),
                authorDto.getDateOfBirth())) {
            Author author = authorMapper.createAuthorFromCreationDto(authorDto);
            authorRepository.save(author);
            return true;
        }
        return true;
    }
}
