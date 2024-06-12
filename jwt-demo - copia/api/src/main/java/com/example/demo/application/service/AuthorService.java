package com.example.demo.application.service;

import com.example.demo.application.dto.AuthorDto;
import org.springframework.stereotype.Service;

@Service
public interface AuthorService {
    AuthorDto createAuthor(AuthorDto authorDto);
}
