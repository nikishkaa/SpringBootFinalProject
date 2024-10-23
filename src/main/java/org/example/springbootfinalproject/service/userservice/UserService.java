package org.example.springbootfinalproject.service.userservice;

import org.example.springbootfinalproject.dto.userdto.UserDto;
import org.example.springbootfinalproject.entity.user.User;

import java.util.List;

public interface UserService {
    User findByEmail(String email);

    User save(UserDto userDto);

    List<UserDto> findAllUsers();
}