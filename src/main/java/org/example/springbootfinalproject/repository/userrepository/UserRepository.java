package org.example.springbootfinalproject.repository.userrepository;

import org.example.springbootfinalproject.dto.userdto.UserDto;
import org.example.springbootfinalproject.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);

    User save(UserDto userDto);

    @Transactional
    void deleteByEmail(String email);
}