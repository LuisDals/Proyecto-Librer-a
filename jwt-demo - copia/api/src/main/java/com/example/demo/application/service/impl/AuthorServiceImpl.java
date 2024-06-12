package com.example.demo.application.service.impl;

import com.example.demo.application.dto.AuthorDto;
import com.example.demo.application.mapper.AuthorMapper;
import com.example.demo.application.service.AuthorService;
import com.example.demo.domain.entity.Author;
import com.example.demo.domain.persistence.AuthorPersistence;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorMapper authorMapper;
    private final AuthorPersistence authorPersistence;

    public AuthorServiceImpl(AuthorMapper authorMapper, AuthorPersistence authorPersistence) {
        this.authorMapper = authorMapper;
        this.authorPersistence = authorPersistence;
    }

    @Override
    public AuthorDto createAuthor(AuthorDto authorDto) {
        Author author = this.authorMapper.toEntity(authorDto);
        author = this.authorPersistence.save(author);
        return this.authorMapper.toDto(author);
    }
}
