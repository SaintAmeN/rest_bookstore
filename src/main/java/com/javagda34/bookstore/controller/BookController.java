package com.javagda34.bookstore.controller;

import com.javagda34.bookstore.component.ISBNValidator;
import com.javagda34.bookstore.model.dto.CreateBookDto;
import com.javagda34.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    // TODO: Zadania po kolei
    //  - (sami) stworzyć metodę do dodawania książki.
    //      (CreateBookDto) Pola:
    //      tytuł(title),
    //      rok publ(year),
    //      kategoria(category)
    //  - (wspólnie) stworzyć metodę do dodawania książki. Pola: tytuł, rok publ, kategoria, dane autorów

    private final BookService bookService;
    private final ISBNValidator isbnValidator;

    @PostMapping("")
    public ResponseEntity createBook(@RequestBody  CreateBookDto dto) {
        boolean success = bookService.createBook(dto);
        if(success){
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    //  - (wspólnie) stworzyć metodę do pytania o poprawność isbn (poprawność formatu isbn-13)


    //  - (wspólnie) przypisywanie autora do książki
    //  - (sami) (PathVariable & RequestParam - zrób na dwa sposoby, dwa endpoint'y) listowanie autorów książki
    //  - (wspólnie) usuwanie danego autora z książki
    //  - (sami) (PathVariable) przypisywanie isbn do książki
}
