package org.example.springbootfinalproject.service.userservice;

import org.example.springbootfinalproject.dto.userdto.UserDto;
import org.example.springbootfinalproject.entity.user.Role;
import org.example.springbootfinalproject.entity.user.User;
import org.example.springbootfinalproject.repository.userrepository.RoleRepository;
import org.example.springbootfinalproject.repository.userrepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    PasswordEncoder passwordEncoder;

    private UserRepository userRepository;
    private RoleRepository roleRepository;


    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        super();
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    @Override
    public User save(UserDto userDto) {
        User user = new User(userDto.getUsername(), passwordEncoder.encode(userDto.getPassword()), userDto.getEmail(), userDto.getPhoneNumber());
        Role role = roleRepository.findByName("DEFAULT_USER");
        if (role == null) {
            role = setDefaultRole();
        }

        user.setRole(role);
        return userRepository.save(user);
    }

    private Role setDefaultRole() {
        Role role = new Role();
        role.setName("DEFAULT_USER");
        return roleRepository.save(role);
    }


    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map((user) -> mapToUserDto(user))
                .collect(Collectors.toList());
    }

    private UserDto mapToUserDto(User user) {
        return new UserDto(user.getEmail(), user.getUsername(), user.getPhoneNumber());
    }


    @Override
    @Transactional
    public void deleteByEmail(String email) {
        userRepository.deleteByEmail(email);
    }

    @Override
    public User updateUser(UserDto userDto, String email) {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        User user = userRepository.findByEmail(email);
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
//        if (!user.getEmail().equals(userDto.getEmail())) {
//            user.setEmail(userDto.getEmail());
//        }
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setUpdatedTs(timestamp);
        userRepository.save(user);
        return null;
    }
}