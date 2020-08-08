package com.javagda34.bookstore.controller;

import com.javagda34.bookstore.model.dto.AuthorInfo;
import com.javagda34.bookstore.model.dto.CreateAuthorDto;
import com.javagda34.bookstore.service.AuthorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "/author", description = "Operations about authors")
@RestController // rest controller zwraca obiekty (które sam serializuje do json)
                // controller - (w odróżnieniu) zwraca nazwy/adresy widoków do request dispachera - który je ładuje
@RequestMapping(path = "/author")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @ApiOperation(value = "Use to add Author to database.",
            notes = "Author with identical first and last name can't exist in database.")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Properly added author to database."),
            @ApiResponse(code = 400, message = "Author with same name, last name and birth date is already in database.")
    })
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
