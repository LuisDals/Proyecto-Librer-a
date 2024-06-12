package com.example.demo.application.mapper;

import com.example.demo.application.dto.BookRegisterDto;
import com.example.demo.domain.entity.BookRegister;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        uses = {BookMapper.class, UserMapper.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface BookRegisterMapper extends EntityMapper<BookRegisterDto, BookRegister> {
    @Mappings({@Mapping(
            source = "user.username",
            target = "userId"
    ),@Mapping(
            source = "book.bookName",
            target = "bookName"
    )})
    BookRegisterDto toDto(BookRegister bookRegister);

    @Mappings({@Mapping(
            source = "userId",
            target = "user.username"
    ),@Mapping(
            source = "bookName",
            target = "book.bookName"
    )})
    BookRegister toEntity(BookRegisterDto bookRegisterDto);
}
