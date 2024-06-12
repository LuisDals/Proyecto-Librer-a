package com.example.demo.application.dto;

import com.example.demo.domain.entity.Author;
import com.example.demo.domain.entity.Genre;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;

public class BookDto implements Serializable {
    private Long id;
    private String bookName;
    private byte[] image;
    private Author author;
    private Genre genre;
    private String publicationDate;
    private BigDecimal rentPrice;
    private BigDecimal salePrice;
    private boolean available;

    public BookDto() {
    }

    @JsonCreator
    public BookDto(
            @JsonProperty("id") Long id,
            @JsonProperty("bookName") String bookName,
            @JsonProperty("image") byte[] image,
            @JsonProperty("author") String authorName,
            @JsonProperty("genre") String genreName,
            @JsonProperty("publicationDate") String publicationDate,
            @JsonProperty("rentPrice") BigDecimal rentPrice,
            @JsonProperty("salePrice") BigDecimal salePrice,
            @JsonProperty("available") boolean available) {
        this.id = id;
        this.bookName = bookName;
        this.image = image;
        this.author = new Author(authorName);
        this.genre = new Genre(genreName);
        this.publicationDate = publicationDate;
        this.rentPrice = rentPrice;
        this.salePrice = salePrice;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public BigDecimal getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(BigDecimal rentPrice) {
        this.rentPrice = rentPrice;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
