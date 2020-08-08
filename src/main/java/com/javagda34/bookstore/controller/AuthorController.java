package com.javagda34.bookstore.controller;

import com.javagda34.bookstore.model.dto.CreateAuthorDto;
import com.javagda34.bookstore.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // rest controller zwraca obiekty (które sam serializuje do json)
                // controller - (w odróżnieniu) zwraca nazwy/adresy widoków do request dispachera - który je ładuje
@RequestMapping(path = "/author")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping("")
    public void submitAuthor(@RequestBody CreateAuthorDto author){
        boolean success = authorService.createAuthor(author);

    }
}
