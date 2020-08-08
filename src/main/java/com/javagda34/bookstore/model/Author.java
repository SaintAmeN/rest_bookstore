package com.javagda34.bookstore.model;

import com.sun.xml.bind.v2.model.core.ID;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String lastName;

    private LocalDate birthDate;

    // mappedby jest po stronie przeciwnej (w relacji)
    // do obiektu, który będę częściej zapisywał, w celu
    // dodania relacji
    @ManyToMany(mappedBy = "authors")
    @EqualsAndHashCode.Exclude
    private Set<Book> books;

}
