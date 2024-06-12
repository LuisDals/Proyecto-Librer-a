package com.example.demo.application.mapper;

import com.example.demo.application.dto.GenreDto;
import com.example.demo.domain.entity.Genre;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GenreMapper extends EntityMapper<GenreDto, Genre> {
}
