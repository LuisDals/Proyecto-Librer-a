package com.example.demo.application.service.impl;

import com.example.demo.application.dto.UserDto;
import com.example.demo.application.mapper.UserMapper;
import com.example.demo.application.service.UserService;
import com.example.demo.domain.entity.User;
import com.example.demo.domain.persistence.UserPersistence;
import com.example.demo.infraestructure.persistence.UserJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService {
    private final UserJpaRepository userJpaRepository;
    private final UserPersistence userPersistence;
    private final UserMapper userMapper;

    public UserServiceImpl(UserJpaRepository userJpaRepository, UserPersistence userPersistence, UserMapper userMapper) {
        this.userJpaRepository = userJpaRepository;
        this.userPersistence = userPersistence;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto findUser(String username) {
        Optional<User> userOptional = userPersistence.find(username);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return userMapper.toDto(user);
        } else {
            return null;
        }
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        Optional<User> userOptional = this.userPersistence.find(userDto.getUsername());
        if (userOptional.isPresent()) {
            User user = (User)this.userMapper.toEntity(userDto);
            User updatedUser = this.userPersistence.updateUser(user);
            return (UserDto)this.userMapper.toDto(updatedUser);
        } else {
            throw new EntityNotFoundException("Usuario no encontrado con nombre de usuario: " + userDto.getUsername());
        }
    }

    @Override
    /*public List<UserDto> getAllUsers() {
        Stream var10000 = this.userJpaRepository.findAll().stream();
        UserMapper var10001 = this.userMapper;
        Objects.requireNonNull(var10001);
        List<UserDto> userDtos = (List)var10000.map(var10001::toDto).collect(Collectors.toList());
        return userDtos;
    }*/
    public List<UserDto> getAllUsers() {
        List<User> users = userJpaRepository.findAll();
        Objects.requireNonNull(userMapper);
        List<UserDto> userDtos = users.stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());

        return userDtos;
    }
}

