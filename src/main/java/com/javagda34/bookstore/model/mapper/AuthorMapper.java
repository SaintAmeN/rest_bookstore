package com.javagda34.bookstore.model.mapper;

import com.javagda34.bookstore.model.Author;
import com.javagda34.bookstore.model.dto.AuthorInfo;
import com.javagda34.bookstore.model.dto.CreateAuthorDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

// wskazujemy, żeby mapper był componentem
// domyślnie mapper nie musi byc uzywany ze spring'iem
// dlatego dopisując to sprawiamy, że powstanie singleton tej klasy
@Mapper(componentModel = "spring")
public interface AuthorMapper {

    @Mappings({
            @Mapping(target = "name", source = "firstName"),
            @Mapping(target = "lastName", source = "lastName"),
            @Mapping(target = "birthDate", source = "dateOfBirth")
    })
    Author createAuthorFromCreationDto(CreateAuthorDto dto);

    @Mappings({
            @Mapping(target = "fullName", expression = "java(source.getName() + ' ' + source.getLastName())"),
            @Mapping(target = "yearBorn", expression = "java(source.getBirthDate().getYear())"),
    })
    AuthorInfo authorToInfo(Author source);

}
