package com.example.demo.application.mapper;

import com.example.demo.application.dto.BookDto;
import com.example.demo.domain.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        uses = {BookRegisterMapper.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface BookMapper extends EntityMapper<BookDto, Book> {

    BookDto toDto(Book book);
    Book toEntity(BookDto bookDto);

}
