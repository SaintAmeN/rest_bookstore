package com.javagda34.bookstore.service;

import com.javagda34.bookstore.model.Author;
import com.javagda34.bookstore.model.Book;
import com.javagda34.bookstore.model.dto.CreateAuthorDto;
import com.javagda34.bookstore.model.dto.CreateBookDto;
import com.javagda34.bookstore.model.mapper.BookMapper;
import com.javagda34.bookstore.repository.AuthorRepository;
import com.javagda34.bookstore.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final BookMapper bookMapper;

    public boolean createBook(CreateBookDto dto) {
        if (!bookRepository.existsByTitleAndYearPublishedAndCategory(
                dto.getTitle(),
                dto.getYear(),
                dto.getCategory())) {
            Book book = bookMapper.bookFromCreateDto(dto);

            // szukamy autorów
            Set<Author> bookAuthors = findAuthors(dto.getAuthors());
            book.setAuthors(bookAuthors); // przypisujemy znalezione obiekty do książki

            bookRepository.save(book);
            return true;
        }
        return false;
    }

    private Set<Author> findAuthors(List<CreateAuthorDto> authors) {
        if(authors == null){
            return new HashSet<>();
        }
        return authors.stream()
                .map(createAuthorDto -> {
                    return authorRepository.findByNameAndLastNameAndBirthDate(
                            createAuthorDto.getFirstName(),
                            createAuthorDto.getLastName(),
                            createAuthorDto.getDateOfBirth());
                })
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());
    }
}
