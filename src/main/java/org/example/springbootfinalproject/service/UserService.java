package org.example.springbootfinalproject.service;

import org.example.springbootfinalproject.dto.UserDto;
import org.example.springbootfinalproject.entity.user.User;

public interface UserService {
    User findByEmail(String email);

    User save(UserDto userDto);
}