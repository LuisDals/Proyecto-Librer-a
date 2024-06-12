package com.example.demo.application.service.impl;

import com.example.demo.domain.entity.Book;
import com.example.demo.domain.entity.BookRegister;
import com.example.demo.domain.entity.User;
import com.example.demo.infraestructure.persistence.BookRegisterRepository;
import com.example.demo.infraestructure.persistence.BookRepository;
import com.example.demo.infraestructure.persistence.UserJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
public class RentalRequestServiceImpl {
    @Autowired
    private UserJpaRepository userRepository;
    @Autowired
    private BookRegisterRepository bookRegisterRepository;
    @Autowired
    private BookRepository bookRepository;

    private static final int DISCOUNT_THRESHOLD_DAYS = 15;
    private static final BigDecimal DISCOUNT_RATE = new BigDecimal("0.10"); // 10% discount

    public BookRegister rentBook(String username, Long bookId, Date datePickUp, Date returnDate) {
        User user = userRepository.findById(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new EntityNotFoundException("Book not found"));

        long rentalDays = ChronoUnit.DAYS.between(datePickUp.toInstant(), returnDate.toInstant());
        BigDecimal basePrice = book.getRentPrice().multiply(BigDecimal.valueOf(rentalDays));
        BigDecimal priceWithDiscount = applyDiscount(user, basePrice, rentalDays);

        BookRegister bookRegister = new BookRegister();
        bookRegister.setUser(user);
        bookRegister.setBook(book);
        bookRegister.setDatePickUp(datePickUp);
        bookRegister.setReturnDate(returnDate);
        bookRegister.setPriceWithDiscount(priceWithDiscount);

        bookRegister = bookRegisterRepository.save(bookRegister);

        user.setTotalRentalDays(user.getTotalRentalDays() + (int) rentalDays);
        userRepository.save(user);

        return bookRegister;
    }

    private BigDecimal applyDiscount(User user, BigDecimal basePrice, long rentalDays) {
        int totalRentalDays = user.getTotalRentalDays() + (int) rentalDays;
        if (totalRentalDays >= DISCOUNT_THRESHOLD_DAYS) {
            return basePrice.subtract(basePrice.multiply(DISCOUNT_RATE));
        }
        return basePrice;
    }

    public int getTotalRentalDays(String username) {
        User user = userRepository.findById(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return user.getTotalRentalDays();
    }
}
