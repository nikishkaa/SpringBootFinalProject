package org.example.springbootfinalproject.repository;

import org.example.springbootfinalproject.dto.UserDto;
import org.example.springbootfinalproject.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);

    User save(UserDto userDto);
}