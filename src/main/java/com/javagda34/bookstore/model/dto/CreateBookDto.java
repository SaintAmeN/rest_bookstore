package com.javagda34.bookstore.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.javagda34.bookstore.model.BookCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
// jeśli pole nie zostanie wysłane, to nie będzie odebrane (nie ma konieczności podawania wszystkich pól)
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class CreateBookDto {
    private String title;
    private int year;
    private BookCategory category;

    private List<CreateAuthorDto> authors;
}
