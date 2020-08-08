package com.javagda34.bookstore.model.mapper;

import com.javagda34.bookstore.model.Book;
import com.javagda34.bookstore.model.dto.CreateBookDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mappings({
            @Mapping(source = "year", target = "yearPublished"),
            @Mapping(target = "authors", ignore = true)
    })
    Book bookFromCreateDto(CreateBookDto dto);
}
