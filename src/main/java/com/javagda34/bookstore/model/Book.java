package com.javagda34.bookstore.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private int yearPublished;

    @Enumerated(EnumType.STRING)
    private BookCategory category;

    private String isbn;

    @ManyToMany
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Author> authors;
}
