package com.example.demo.application.dto;

import java.io.Serializable;

public class GenreDto implements Serializable {
    private Long id;
    private String name;

    public GenreDto() {
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
