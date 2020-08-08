package com.javagda34.bookstore.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAuthorDto {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
}
