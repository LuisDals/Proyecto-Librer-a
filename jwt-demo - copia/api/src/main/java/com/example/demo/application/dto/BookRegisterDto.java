package com.example.demo.application.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BookRegisterDto implements Serializable {
    private Long id;
    private String userId;
    private String bookName;
    private Date datePickUp;
    private Date returnDate;
    private BigDecimal priceWithDiscount;

    public BookRegisterDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
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

    public BigDecimal getPriceWithDiscount() {
        return priceWithDiscount;
    }

    public void setPriceWithDiscount(BigDecimal priceWithDiscount) {
        this.priceWithDiscount = priceWithDiscount;
    }
}
