package com.javagda34.bookstore.controller;

import com.javagda34.bookstore.model.dto.AuthorInfo;
import com.javagda34.bookstore.model.dto.CreateAuthorDto;
import com.javagda34.bookstore.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // rest controller zwraca obiekty (które sam serializuje do json)
                // controller - (w odróżnieniu) zwraca nazwy/adresy widoków do request dispachera - który je ładuje
@RequestMapping(path = "/author")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping("")
    public ResponseEntity<Void> submitAuthor(@RequestBody CreateAuthorDto author){
        boolean success = authorService.createAuthor(author);
        if(success){
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/fromLastDecades") // ostatnie 30 lat
    public List<AuthorInfo> getAuthorsFromLastDecades(){
        // zwrócić obiekty AuthorInfo które zawierają:
        //      - pole name: imie + " " + nazwisko
        //      - int rok urodzenia
        return authorService.findAuthorsFromLastDecades();
    }

    // /fromLastDecades?years=10        == request param
    // /fromLastDecades/10              == path variable (zmienna ze ścieżki)
    @GetMapping("/fromLastDecades/{years}")
    public List<AuthorInfo> getAuthorsFromLastDecades(@PathVariable(name = "years") int years){
        return authorService.findAuthorsFromLastDecades(years);
    }


}
