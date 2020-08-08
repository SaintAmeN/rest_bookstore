package com.javagda34.bookstore.repository;

import com.javagda34.bookstore.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    // select * from author where exists (select count(*) from author where name=? and lastName =? and brithDate =?)
    boolean existsByNameAndLastNameAndBirthDate(String name, String lastName, LocalDate birthDate);
}
