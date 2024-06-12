package com.example.demo.application.mapper;

import com.example.demo.application.dto.AuthorDto;
import com.example.demo.domain.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AuthorMapper extends   EntityMapper<AuthorDto, Author> {
}
