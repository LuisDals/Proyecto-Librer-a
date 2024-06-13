package com.example.demo.application.service;

import com.example.demo.application.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
   UserDto findUser(String username);
   UserDto updateUser(UserDto userDto);
   List<UserDto> getAllUsers();
   void deleteUser(String username);
}
