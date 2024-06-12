package com.example.demo.application.dto;

import java.io.Serializable;

public class AuthorDto implements Serializable {
    private Long id;
    private String name;

    public AuthorDto(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
