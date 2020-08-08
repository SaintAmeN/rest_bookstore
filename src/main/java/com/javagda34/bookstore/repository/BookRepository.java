package com.javagda34.bookstore.repository;

import com.javagda34.bookstore.model.Book;
import com.javagda34.bookstore.model.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    boolean existsByTitleAndYearPublishedAndCategory(String title, int year, BookCategory category);
}
