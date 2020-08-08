package com.javagda34.bookstore.service;

import com.javagda34.bookstore.model.Author;
import com.javagda34.bookstore.model.dto.AuthorInfo;
import com.javagda34.bookstore.model.dto.CreateAuthorDto;
import com.javagda34.bookstore.model.mapper.AuthorMapper;
import com.javagda34.bookstore.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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
        return false;
    }

    public List<AuthorInfo> findAuthorsFromLastDecades() {
        return findAuthorsFromLastDecades(30);
    }

    public List<AuthorInfo> findAuthorsFromLastDecades(int years) {
        return authorRepository.findAllByBirthDateAfter(LocalDate.now().minusYears(years))
                .stream()
                .map(authorMapper::authorToInfo)
                .collect(Collectors.toList());
    }
}
