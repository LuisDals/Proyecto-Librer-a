package com.example.demo.infraestructure.persistence;

import com.example.demo.domain.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
    Page<Book> findAll(Pageable pageable);
    Page<Book> findByGenre(String genre, Pageable pageable);
}
