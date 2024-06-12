package com.example.demo.application.dto;

import java.util.Date;

public class RentRequestDto {
    private String username;
    private Long bookId;
    private Date datePickUp;
    private Date returnDate;

    public RentRequestDto() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Date getDatePickUp() {
        return datePickUp;
    }

    public void setDatePickUp(Date datePickUp) {
        this.datePickUp = datePickUp;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
