package com.springbootacademy.project1.util;

import com.springbootacademy.project1.DTO.BookDTO;
import com.springbootacademy.project1.entity.Books;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Bean;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
    List<BookDTO> entityListToDTOList(List<Books> books);
}
