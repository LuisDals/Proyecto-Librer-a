package com.example.demo.application.service;

import com.example.demo.application.dto.BookRegisterDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface BookRegisterService {
    Page<BookRegisterDto>getBookRegisterByUserId(String userId, Pageable pageable);
    Page<BookRegisterDto>getItems(Pageable pageable);
}
