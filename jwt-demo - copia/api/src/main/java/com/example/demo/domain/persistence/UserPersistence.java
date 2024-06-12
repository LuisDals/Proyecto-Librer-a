package com.example.demo.domain.persistence;

import com.example.demo.domain.entity.User;

import java.util.Optional;

public interface UserPersistence {
    User save(User user);
    Optional<User> find(String username);
    User updateUser(User user);
}
