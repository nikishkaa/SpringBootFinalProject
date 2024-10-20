package org.example.springbootfinalproject.repository;


import org.example.springbootfinalproject.dto.UserDto;
import org.example.springbootfinalproject.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByUsername(String username);

    AppUser save(UserDto userDto);
}